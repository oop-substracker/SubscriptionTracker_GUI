package controller.SubscriptionsRequestHandler;

import controller.Repositories.SubscriptionsRepository;
import model.Subscriptions.Subscription;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class SubscriptionService implements SubscriptionsRepository {

    private static final String GET_REQUEST_URL = "http://localhost:8080/api/subscriptions/";

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

            System.out.println("Response body: " + response);

        } catch(Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
