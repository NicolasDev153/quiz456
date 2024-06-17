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

    /**
     * Sends data to the remote server using a POST request.
     *
     * @param data The data to be sent to the server.
     * @return The response from the server.
     * @throws IOException If an I/O error occurs during the request.
     */
    public String sendData(String data) throws IOException {
        return sendHttpRequest(baseUrl + "/send_data", "POST", data);
    }

    /**
     * Receives data from the remote server using a GET request.
     *
     * @return The data received from the server.
     * @throws IOException If an I/O error occurs during the request.
     */
    public String receiveData() throws IOException {
        return sendHttpRequest(baseUrl + "/receive_data", "GET", null);
    }

    /**
     * Sends an HTTP request (GET or POST) to the specified URL with optional request body.
     *
     * @param urlString    The URL to send the request to.
     * @param requestMethod The HTTP request method (GET or POST).
     * @param requestBody   The request body for POST requests, or null for GET requests.
     * @return The response from the server.
     * @throws IOException If an I/O error occurs during the request.
     */
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

    /**
     * Reads the response from the input stream and returns it as a string.
     *
     * @param inputStream The input stream to read the response from.
     * @return The response as a string.
     * @throws IOException If an I/O error occurs during reading the response.
     */
    private String readResponse(InputStream inputStream) throws IOException {
        Scanner scanner = new Scanner(inputStream);
        StringBuilder response = new StringBuilder();
        while (scanner.hasNextLine()) {
            response.append(scanner.nextLine());
        }
        scanner.close();
        return response.toString();
    }
}