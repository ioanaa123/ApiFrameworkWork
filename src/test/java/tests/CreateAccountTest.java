package tests;

import Actions.AccountActions;
import ObjectData.RequestObject.RequestAccount;
import ObjectData.ResponseObject.ResponseAccountSuccess;
import ObjectData.ResponseObject.ResponseTokenSuccess;
import PropertyUtility.PropertyUtility;

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
    }

    public void createAccount() {
        accountActions = new AccountActions();

        PropertyUtility propertyUtility = new PropertyUtility("RequestData/createAccountData");
        requestAccountBody = new RequestAccount(propertyUtility.getAllData());
        ResponseAccountSuccess responseAccountBody = accountActions.createNewAccount(requestAccountBody);

        userId = responseAccountBody.getUserID();

//        definim configurarile pt client
//        RequestSpecification requestSpecification = RestAssured.given();
//        requestSpecification.baseUri("https://demoqa.com/");
//        requestSpecification.contentType("application/json");
//
//        // definim request-ul
//        PropertyUtility propertyUtility = new PropertyUtility("RequestData/createAccountData");
//        requestAccountBody = new RequestAccount(propertyUtility.getAllData());
//        requestSpecification.body(requestAccountBody);
//
//        // interactional cu response-ul
//        Response response = requestSpecification.post("/Account/v1/User");
//        System.out.println(response.getStatusCode());
//        Assert.assertEquals(response.getStatusCode(), 201);
//        System.out.println(response.getStatusLine());
//
//
//        //Validam response body-ul
//        ResponseAccountSuccess responseAccountBody = response.body().as(ResponseAccountSuccess.class);
//        userId = responseAccountBody.getUserID();
//        Assert.assertEquals(responseAccountBody.getUsername(), requestAccountBody.getUserName());
    }

    public void generateToken() {
        ResponseTokenSuccess responseToken = accountActions.generateToken(requestAccountBody);
        token = responseToken.getToken();

//        RequestSpecification requestSpecification = RestAssured.given();
//        requestSpecification.baseUri("https://demoqa.com/");
//        requestSpecification.contentType("application/json");
//
//        requestSpecification.body(requestAccountBody);
//
//        Response response = requestSpecification.post("/Account/v1/GenerateToken");
//        System.out.println(response.getStatusCode());
//        Assert.assertEquals(response.getStatusCode(), 200);
//        System.out.println(response.getStatusLine());
//
//        ResponseTokenSuccess responseToken = response.body().as(ResponseTokenSuccess.class);
//        System.out.println(responseToken.getToken());
//        token = responseToken.getToken();
//        System.out.println(responseToken.getStatus());
//        Assert.assertEquals(responseToken.getStatus(), "Success");
//        System.out.println(responseToken.getResult());
//        Assert.assertEquals(responseToken.getResult(), "User authorized successfully.");
    }

    public void getSpecificAccount() {
//        RequestSpecification requestSpecification = RestAssured.given();
//        requestSpecification.baseUri("https://demoqa.com/");
//        requestSpecification.contentType("application/json");
//        requestSpecification.header("Authorization", "Bearer " + token);
//
//        Response response = requestSpecification.get("/Account/v1/User/" + userId);
//        System.out.println(response.getStatusCode());
//        Assert.assertEquals(response.getStatusCode(), 200);
//        System.out.println(response.getStatusLine());
//
//        ResponseAccountGetSuccess responseAccountGetSuccess = response.body().as(ResponseAccountGetSuccess.class);
//        Assert.assertEquals(responseAccountGetSuccess.getUsername(), requestAccountBody.getUserName());
//        System.out.println(responseAccountGetSuccess.getUsername());

        accountActions.getSpecificAccount(token, userId, requestAccountBody);


    }
}
