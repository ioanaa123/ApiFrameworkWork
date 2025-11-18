package Actions;


import ObjectData.RequestObject.RequestAccount;
import ObjectData.ResponseObject.ResponseAccountGetFailed;
import ObjectData.ResponseObject.ResponseAccountGetSuccess;
import ObjectData.ResponseObject.ResponseAccountSuccess;
import ObjectData.ResponseObject.ResponseTokenSuccess;
import RestClient.ResponseStatus;
import Service.ServiceImplementation.AccountServiceImpl;
import io.restassured.response.Response;
import org.testng.Assert;

public class AccountActions {

    private AccountServiceImpl accountServiceImpl;

    public AccountActions() {
        accountServiceImpl = new AccountServiceImpl();
    }

    public ResponseAccountSuccess createNewAccount(RequestAccount requestAccount) {
        Response response = accountServiceImpl.createAccount(requestAccount);
        Assert.assertEquals(response.getStatusCode(), ResponseStatus.SC_CREATED);
        ResponseAccountSuccess responseAccountBody = response.body().as(ResponseAccountSuccess.class);
        Assert.assertEquals(responseAccountBody.getUsername(), requestAccount.getUserName());
        System.out.println(responseAccountBody.getUsername());
        System.out.println(responseAccountBody.getUserID());

        return responseAccountBody;
    }

    public void authorizeNewAccount(RequestAccount requestAccount) {
        Response response = accountServiceImpl.createAccount(requestAccount);
        Assert.assertEquals(response.getStatusCode(), ResponseStatus.SC_OK);
    }

    public ResponseTokenSuccess generateToken(RequestAccount requestAccount) {
        Response response = accountServiceImpl.generateAccountToken(requestAccount);
        Assert.assertEquals(response.getStatusCode(), ResponseStatus.SC_OK);
        ResponseTokenSuccess responseTokenSuccess = response.body().as(ResponseTokenSuccess.class);
        Assert.assertEquals(responseTokenSuccess.getStatus(), "Success");
        Assert.assertEquals(responseTokenSuccess.getResult(), "User authorized successfully.");
        return responseTokenSuccess;
    }

    public void getSpecificAccount(String token, String userId, RequestAccount requestAccount) {
        Response response = accountServiceImpl.getSpecificAccount(token, userId);
        if (response.getStatusCode() == ResponseStatus.SC_OK) {
            Assert.assertEquals(response.getStatusCode(), ResponseStatus.SC_OK);
            ResponseAccountGetSuccess responseAccountGetSuccess = response.body().as(ResponseAccountGetSuccess.class);
            Assert.assertEquals(responseAccountGetSuccess.getUsername(), requestAccount.getUserName());
            System.out.println("User is authorized!");
        } else {
            Assert.assertEquals(response.getStatusCode(), ResponseStatus.SC_UNAUTHORIZED);
            ResponseAccountGetFailed responseAccountGetFailed = response.body().as(ResponseAccountGetFailed.class);
            Assert.assertEquals(responseAccountGetFailed.getCode(), "1200");
            Assert.assertEquals(responseAccountGetFailed.getMessage(), "User not authorized!");
            System.out.println("User not authorized!");
        }
    }

    public void deleteSpecificAccount(String token, String userId) {
        Response response = accountServiceImpl.deleteSpecificAccount(token, userId);
        if (response.getStatusCode() == ResponseStatus.SC_NO_CONTENT) {
            Assert.assertEquals(response.getStatusCode(), ResponseStatus.SC_NO_CONTENT);
            System.out.println("Deleted account");
        } else {
            Assert.assertEquals(response.getStatusCode(), ResponseStatus.SC_UNAUTHORIZED);
            ResponseAccountGetFailed responseAccountGetFailed = response.body().as(ResponseAccountGetFailed.class);
            Assert.assertEquals(responseAccountGetFailed.getCode(), "1200");
            Assert.assertEquals(responseAccountGetFailed.getMessage(), "User not authorized!");
            System.out.println("User not authorized!");
        }
    }
}
