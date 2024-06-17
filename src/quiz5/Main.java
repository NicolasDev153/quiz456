package quiz5;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        // For testing with DummyCommunicationManager
        CommunicationManager dummyCommunicationManager = new DummyCommunicationManager();
        UserInteractionManager userInteractionManager = new UserInteractionManager(dummyCommunicationManager);

        // Send some data
        String data = "{\"question\": \"What is the capital of France?\", \"user_id\": 123}";
        userInteractionManager.sendData(data);

        // Receive data
        userInteractionManager.receiveData();

        // For using with the actual CommunicationManager and a remote service
        // String baseUrl = "http://your-chatbot-service.com/api";
        // CommunicationManager communicationManager = new CommunicationManager(baseUrl);
        // UserInteractionManager userInteractionManager = new UserInteractionManager(communicationManager);
    }
}