package tests;

import Actions.AccountActions;
import ObjectData.RequestObject.RequestAccount;
import ObjectData.ResponseObject.ResponseAccountGetSuccess;
import ObjectData.ResponseObject.ResponseAccountSuccess;
import ObjectData.ResponseObject.ResponseTokenSuccess;
import PropertyUtility.PropertyUtility;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest {
    public String userId;
    public RequestAccount requestAccountBody;
    public String token;
    public AccountActions accountActions;

    @Test
    public void testMethod() {
        System.out.println("Step 1: Create a new account");
        createAccount();
        System.out.println();

        System.out.println("Step 2: Generate new token");
        generateToken();
        System.out.println();

        System.out.println("Step 3: Get new account");
        getSpecificAccount();
        System.out.println();

        System.out.println("Step 4: Delete account");
        deleteSpecificAccount();
        System.out.println();

        System.out.println("Step 5: Get new account");
        getSpecificAccount();
        System.out.println();
    }

    public void createAccount() {
        accountActions = new AccountActions();

        PropertyUtility propertyUtility = new PropertyUtility("RequestData/createAccountData");
        requestAccountBody = new RequestAccount(propertyUtility.getAllData());
        ResponseAccountSuccess responseAccountBody = accountActions.createNewAccount(requestAccountBody);

        userId = responseAccountBody.getUserID();
//        accountActions.authorizeNewAccount(requestAccountBody);
    }

    public void generateToken() {
        ResponseTokenSuccess responseToken = accountActions.generateToken(requestAccountBody);
        token = responseToken.getToken();
    }

    public void getSpecificAccount() {
        accountActions.getSpecificAccount(token, userId, requestAccountBody);
    }

    public void deleteSpecificAccount() {
        accountActions.deleteSpecificAccount(token, userId);
    }
}
