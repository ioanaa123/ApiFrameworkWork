package Service;

import RestClient.RequestType;
import RestClient.RestClient;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CommonApiService {

    // Layer 2: presupune definirea actiunilor care se vor face pe configurarile de client (layer 1)

    public Response post(Object body, String endPoint) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.body(body);
        Response response = performRequest(RequestType.REQUEST_POST, requestSpecification, endPoint);
        return response;
    }

    public Response get(String token, String endPoint) {
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.header("Authorization", "Bearer Token" + token);
        Response response = performRequest(RequestType.REQUEST_GET, requestSpecification, endPoint);
        return response;
    }


    // metoda care instanteaza legatura cu layer
    private Response performRequest(String requestType, RequestSpecification requestSpecification, String endPoint) {
        return new RestClient().performRequest(requestType, requestSpecification, endPoint);
    }
}
