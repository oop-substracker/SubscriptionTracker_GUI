package controller.AuthRequestHandler;

import com.fasterxml.jackson.core.type.TypeReference;
import controller.Repositories.AuthenticationRepository;
import model.Subscriptions.Subscription;
import model.UserAccount.User;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.List;

public class AuthenticationService implements AuthenticationRepository {

    private static final String REGISTER_URL = "http://localhost:8080/api/register";
    private static final String LOGIN_URL = "http://localhost:8080/api/login";
    private static final ObjectMapper objectMapper = new ObjectMapper();
    private static int responseCode =  999;
    private static String error;
    private User user;

    @Override
    public void makeRegistrationRequest(User user) {
        try {
            // Convert User object to JSON string
            String jsonUser = objectMapper.writeValueAsString(user);

            // Set up the URL and open the connection
            URL url = new URL(REGISTER_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Set up the connection properties
            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            // Write the JSON data to the connection's output stream
            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonUser.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            printResponse(connection);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void makeLoginRequest(User user) {
        try {
            String jsonUser = objectMapper.writeValueAsString(user);
            URL url = new URL(LOGIN_URL);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            connection.setRequestMethod("POST");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setDoOutput(true);

            try (OutputStream os = connection.getOutputStream()) {
                byte[] input = jsonUser.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            printResponse(connection);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void printResponse(HttpURLConnection connection) throws IOException {
        int responseCode = connection.getResponseCode();
        System.out.println("Response code: " + responseCode);

        if (responseCode == HttpURLConnection.HTTP_OK) {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                StringBuilder responseBody = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    responseBody.append(line);
                }

                setUser(parseJsonToSubscriptionList(responseBody.toString()));
            }
        } else {
            InputStream errorStream = connection.getErrorStream();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(errorStream))) {
                String line;
                StringBuilder responseBody = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    responseBody.append(line);
                }
                setError(responseBody.toString());
            }
        }

        setResponseCode(responseCode);
    }

    public User parseJsonToSubscriptionList(String jsonData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(jsonData, new TypeReference<User>() {});
        } catch (Exception e) {
            e.printStackTrace();
            // Handle parsing errors
            return null;
        }
    }

    public  int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        AuthenticationService.responseCode = responseCode;
    }

    @Override
    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String getError() {
        return error;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
