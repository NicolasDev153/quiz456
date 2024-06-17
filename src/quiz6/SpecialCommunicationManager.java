package quiz6;

import quiz5.CommunicationManager;
import java.io.IOException;
class SpecialCommunicationManager extends CommunicationManager {
    private final String commonServiceUrl;
    private final String specialServiceUrl;
    private final String conversationHistory;

    public SpecialCommunicationManager(String commonServiceUrl, String specialServiceUrl, String conversationHistory) {
        super(commonServiceUrl);
        this.commonServiceUrl = commonServiceUrl;
        this.specialServiceUrl = specialServiceUrl;
        this.conversationHistory = conversationHistory;
    }

    @Override
    public String sendData(String data) throws IOException {
        String baseUrl = determineServiceUrl(data);
        return super.sendData(data);
    }

    @Override
    public String receiveData() throws IOException {
        String baseUrl = determineServiceUrl(conversationHistory);
        return super.receiveData();
    }

    private String determineServiceUrl(String data) {
        if (data.contains("help") || conversationHistory.contains("help")) {
            return specialServiceUrl;
        } else {
            return commonServiceUrl;
        }
    }
}
