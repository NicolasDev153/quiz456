package quiz5;

class DummyCommunicationManager extends CommunicationManager {
    private String data;

    public DummyCommunicationManager() {
        super("dummy");
    }

    @Override
    public String sendData(String data) {
        this.data = data;
        return "{\"status\": \"success\"}";
    }

    @Override
    public String receiveData() {
        return data;
    }
}
