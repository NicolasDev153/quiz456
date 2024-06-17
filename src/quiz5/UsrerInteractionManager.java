package quiz5;
import java.io.IOException;

class UserInteractionManager {
    private final CommunicationManager communicationManager;

    public UserInteractionManager(CommunicationManager communicationManager) {
        this.communicationManager = communicationManager;
    }

    /**
     * Sends data to the remote server using the communication manager.
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
     *
     * @throws IOException If an I/O error occurs during the request.
     */
    public void receiveData() throws IOException {
        String data = communicationManager.receiveData();
        System.out.println("Data received from server: " + data);
    }
}