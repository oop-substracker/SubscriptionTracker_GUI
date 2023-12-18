package controller.SubscriptionsRequestHandler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
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
    private static final String UPDATE_REQUEST_URL = "http://localhost:8080/api/subscriptions/update";
    private static final String UPDATE_TIME_URL = "http://localhost:8080/api/subscriptions/edit/";
    private static final String DELETE_URL = "http://localhost:8080/api/subscriptions/delete/";
    private static final ObjectMapper objectMapper =  new ObjectMapper();

    static {
        // Register the JavaTimeModule with the ObjectMapper
        objectMapper.registerModule(new JavaTimeModule());
    }


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

    @Override
    public void updateSubTimeStamps(String id, Subscription subscription)  {

        try {
            String jsonSubs = objectMapper.writeValueAsString(subscription);
            URL url = new URL(UPDATE_REQUEST_URL + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("PATCH");
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

            System.out.println("Response update message: " + parseJsonToSubscription(response.toString()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateSubRemainingTime(String id) {
        try {
            URL url = new URL(UPDATE_TIME_URL + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Use POST method
            connection.setRequestMethod("POST");
            // Set a custom header to indicate it's a PATCH request
            connection.setRequestProperty("X-HTTP-Method-Override", "PATCH");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // reads the response connection input stream
                String line;
                StringBuilder response = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                System.out.println("Response update message: " + (response.toString()));
            } else {
                System.out.println("Failed to update. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void deleteSubscription(String id) {
        try {
            URL url = new URL(DELETE_URL + id);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("DELETE");

            int responseCode = connection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) {
                // reads the response connection input stream
                String line;
                StringBuilder response = new StringBuilder();
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                System.out.println("Response update message: " + response);
            } else {
                System.out.println("Failed to delete. Response Code: " + responseCode);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public List<Subscription> parseJsonToSubscriptionList(String jsonData) {
        try {
            return objectMapper.readValue(jsonData, new TypeReference<List<Subscription>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            // Handle parsing errors
            return null;
        }
    }

    public Subscription parseJsonToSubscription(String jsonData) {
        try {
            return objectMapper.readValue(jsonData, new TypeReference<Subscription>() {});
        } catch (Exception e) {
            e.printStackTrace();
            // Handle parsing errors
            return null;
        }
    }
}
