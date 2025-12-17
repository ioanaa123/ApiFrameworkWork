package tests;

import Actions.AccountActions;
import Hooks.Hooks;
import ObjectData.RequestObject.RequestAccount;
import ObjectData.ResponseObject.ResponseAccountSuccess;
import ObjectData.ResponseObject.ResponseTokenSuccess;
import PropertyUtils.PropertyUtils;


import org.testng.annotations.Test;

public class CreateAccountTest extends Hooks {
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

        PropertyUtils propertyUtils = new PropertyUtils("requestData/createAccountData");
        requestAccountBody = new RequestAccount(propertyUtils.getAllData());
        ResponseAccountSuccess responseAccountBody = accountActions.createNewAccount(requestAccountBody);
        userId = responseAccountBody.getUserID();
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
