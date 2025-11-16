package ObjectData.RequestObject;

import ObjectData.RequestPreparation;

import java.util.HashMap;

public class RequestAccount implements RequestPreparation {

    private String userName;
    private String password;

    public RequestAccount(HashMap<String, String> testData) {
        prepareObject(testData);
    }

    @Override
    public void prepareObject(HashMap<String, String> testData) {
        for (String key : testData.keySet()) {
            switch (key) {
                case "userName":
                    setUserName(testData.get(key));
                    break;
                case "password":
                    setPassword(testData.get(key));
                    break;
            }
        }
        adjustObjectValue();
    }

    private void adjustObjectValue(){
        userName = userName + System.currentTimeMillis();
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
