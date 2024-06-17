package quiz5;

public class UsrerInteractionManager {
        private final CommunicationManager communicationManager;

        public UserInteractionManager(CommunicationManager communicationManager) {
            this.communicationManager = communicationManager;
        }

        public void sendData(String data) throws IOException {
            String response = communicationManager.sendData(data);
            System.out.println("Response from server: " + response);
        }

        public void receiveData() throws IOException {
            String data = communicationManager.receiveData();
            System.out.println("Data received from server: " + data);
        }
}
