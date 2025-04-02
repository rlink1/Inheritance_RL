package NetworkMessage;

import java.util.ArrayList;

public class Message {
    private String machineType;
    private String machineId;
    private String warning;
    private String message;

    public Message(String m){
        message = m;
    }


    public String getMachineType() {
        return machineType;
    }

    public String getMachineId() {
        return machineId;
    }

    public String getWarning() {
        return warning;
    }
    public String getMessage() {
        return message;
    }


}
