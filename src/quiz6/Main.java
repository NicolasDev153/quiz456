package quiz6;

import java.io.IOException;

/**
 * URLs are given as an example, they don't work/exist
 * URLs should be implemented manually
 */

public class Main {
    public static void main(String[] args) throws IOException {
        String commonServiceUrl = "http://localhost:8080/api"; // Dummy URL
        String specialServiceUrl = "http://localhost:8080/special-api"; // Dummy URL
        String conversationHistory = "Hello, how are you? I need help with something.";

        // Create an instance of SpecialCommunicationManager
        SpecialCommunicationManager communicationManager = new SpecialCommunicationManager(commonServiceUrl, specialServiceUrl, conversationHistory);

        // Create an instance of UserInteractionManager
        UserInteractionManager userInteractionManager = new UserInteractionManager(communicationManager, conversationHistory);

        // Send some data
        String data = "{\"question\": \"I need help with booking a flight.\", \"user_id\": 123}";
        userInteractionManager.sendData(data);

        // Receive data
        userInteractionManager.receiveData();
    }
}