package tests;

import ObjectData.RequestObject.RequestAccount;
import ObjectData.ResponseObject.ResponseAccountSuccess;
import PropertyUtility.PropertyUtility;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest {

    @Test
    public void testMethod() {
        // definim configurarile pt client
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://demoqa.com/");
        requestSpecification.contentType("application/json");

        // definim request-ul
        PropertyUtility propertyUtility = new PropertyUtility("RequestData/createAccountData");
        RequestAccount requestAccountBody = new RequestAccount(propertyUtility.getAllData());

//        JSONObject  createUserBody = new JSONObject();
//        createUserBody.put("userName", "AutomationTest" + System.currentTimeMillis());
//        createUserBody.put("password", "P@ssw0rd!2");
        requestSpecification.body(requestAccountBody);

        // interactional cu response-ul
        Response response = requestSpecification.post("/Account/v1/User");
        System.out.println(response.getStatusCode());
        System.out.println(response.getStatusLine());

        //Validam response body-ul
        ResponseAccountSuccess responseAccountBody = response.body().as(ResponseAccountSuccess.class);
        System.out.println(responseAccountBody.getUserID());
        Assert.assertEquals(responseAccountBody.getUserName(), responseAccountBody.getUserName());

    }
}
