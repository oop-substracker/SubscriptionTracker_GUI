package controller.SubscriptionsRequestHandler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Subscriptions.Subscription;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.List;

public class GetRequestHandler {
    /**
     * Fetches data from the backend using a GET request to the specified API endpoint.
     *
     * @param apiUrl The API endpoint to fetch data from.
     * @return A String containing the response data from the backend, or {@code null} if an error occurs.
     */
    public String fetchData(String apiUrl) {
        try {
            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set request method to GET
            connection.setRequestMethod("GET");

            // Get the response code
            int responseCode = connection.getResponseCode();

            // Read the response
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder response = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();

            // Process response
            String responseData = response.toString();
            System.out.println("Received data from backend: " + responseData);

            connection.disconnect();

            return responseData;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Parses JSON data representing a list of subscriptions into a List of Subscription objects.
     *
     * @param jsonData The JSON data to parse.
     * @return A List of Subscription objects parsed from the JSON data, or an empty list if parsing fails.
     */
    public List<Subscription> parseJsonToSubscriptionList(String jsonData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonData, new TypeReference<List<Subscription>>() {});
        } catch (Exception e) {
            e.printStackTrace();
            // Handle parsing errors
            return Collections.emptyList();
        }
    }
}
