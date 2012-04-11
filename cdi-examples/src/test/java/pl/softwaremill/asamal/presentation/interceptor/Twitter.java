package pl.softwaremill.asamal.presentation.interceptor;

import java.util.ArrayList;
import java.util.List;

public class Twitter {

    private List<String> messages = new ArrayList<String>();

    @MouthSoap
    public void tweet(String message) {
        messages.add(message);
    }

    public List<String> getMessages() {
        return messages;
    }
}
