package controller.SubscriptionsRequestHandler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import controller.Repositories.SubscriptionsRepository;
import model.Subscriptions.Subscription;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class SubscriptionService implements SubscriptionsRepository {

    private static final String GET_REQUEST_URL = "http://localhost:8080/api/subscriptions/";
    private static final String POST_REQUEST_URL = "http://localhost:8080/api/subscriptions/create";
    private static final ObjectMapper objectMapper =  new ObjectMapper();

    @Override
    public List<Subscription> getMySubscriptions(String userId) {
        try {
            URL url = new URL(GET_REQUEST_URL + userId);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();

            String line;
            StringBuilder response = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            return parseJsonToSubscriptionList(response.toString());

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public Subscription createMySubscription(Subscription subscription) {
        try {
            String jsonSubs = objectMapper.writeValueAsString(subscription);
            URL url = new URL(POST_REQUEST_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonSubs.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // reads the response connection input stream
            String line;
            StringBuilder response = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }

            return parseJsonToSubscription(response.toString());

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Subscription> parseJsonToSubscriptionList(String jsonData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonData, new TypeReference<List<Subscription>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            // Handle parsing errors
            return null;
        }
    }

    public Subscription parseJsonToSubscription(String jsonData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonData, new TypeReference<Subscription>() {});
        } catch (Exception e) {
            e.printStackTrace();
            // Handle parsing errors
            return null;
        }
    }
}
