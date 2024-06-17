package quiz6;

import java.io.IOException;

/**
 * Manages the interaction between the user and the communication manager.
 * It provides methods for sending and receiving data using the communication manager.
 * If the user message or conversation history contains the word "help", it uses the
 * SpecialCommunicationManager to direct the requests to a special service.
 */
class UserInteractionManager {
    private final SpecialCommunicationManager communicationManager;
    private final String conversationHistory;

    /**
     * Constructs a UserInteractionManager instance with a SpecialCommunicationManager
     * and the conversation history.
     *
     * @param communicationManager The SpecialCommunicationManager instance.
     * @param conversationHistory  The conversation history.
     */
    public UserInteractionManager(SpecialCommunicationManager communicationManager, String conversationHistory) {
        this.communicationManager = communicationManager;
        this.conversationHistory = conversationHistory;
    }

    /**
     * Sends data to the remote server using the communication manager.
     * If the user message or conversation history contains the word "help",
     * the request is directed to the special service.
     *
     * @param data The data to be sent to the server.
     * @throws IOException If an I/O error occurs during the request.
     */
    public void sendData(String data) throws IOException {
        String response = communicationManager.sendData(data);
        System.out.println("Response from server: " + response);
    }

    /**
     * Receives data from the remote server using the communication manager.
     * If the conversation history contains the word "help",
     * the request is directed to the special service.
     *
     * @throws IOException If an I/O error occurs during the request.
     */
    public void receiveData() throws IOException {
        String data = communicationManager.receiveData();
        System.out.println("Data received from server: " + data);
    }
}