package quiz5;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

class CommunicationManager {
    private final String baseUrl;

    public CommunicationManager(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String sendData(String data) throws IOException {
        return sendHttpRequest(baseUrl + "/send_data", "POST", data);
    }

    public String receiveData() throws IOException {
        return sendHttpRequest(baseUrl + "/receive_data", "GET", null);
    }

    private String sendHttpRequest(String urlString, String requestMethod, String requestBody) throws IOException {
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod(requestMethod);

        if (requestBody != null) {
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            try (OutputStream outputStream = connection.getOutputStream()) {
                outputStream.write(requestBody.getBytes());
            }
        }

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            return readResponse(connection.getInputStream());
        } else {
            return "Error: " + responseCode;
        }
    }

    private String readResponse(InputStream inputStream) {
        Scanner scanner = new Scanner(inputStream);
        StringBuilder response = new StringBuilder();
        while (scanner.hasNextLine()) {
            response.append(scanner.nextLine());
        }
        scanner.close();
        return response.toString();
    }
}