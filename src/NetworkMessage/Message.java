package NetworkMessage;

import java.util.ArrayList;

public class Message {
    private String machineType;
    private String machineId;
    private String warning;
    private String message;

    public Message(String m){
        message = m;
        if(m.contains(":")){
                            for (int j = 0; j < m.length(); j++) {
                                if (m.charAt(j) == ':'){
                                    String tempStart = m.substring(0,j);
                                    tempStart = tempStart.trim();
                                    machineType = tempStart.substring(0, j-1);
                                    machineId = tempStart.substring(j-1,j);
                                    String tempEnd = m.substring(j + 1,m.length());
                                    tempEnd = tempEnd.trim();
                                    warning = tempEnd;
                                    message = tempStart + ":" + tempEnd;
                                }
                            }


                        }

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
