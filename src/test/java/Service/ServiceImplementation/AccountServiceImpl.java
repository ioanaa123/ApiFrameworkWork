package Service.ServiceImplementation;

import InterfaceService.AccountServiceInterface;
import ObjectData.RequestObject.RequestAccount;
import Service.ApiService.AccountApiService;
import io.restassured.response.Response;

public class AccountServiceImpl implements AccountServiceInterface {

    // Facem o instanta de ApiService ca sa putem accesa metodele generale
    private AccountApiService accountApiService;

    @Override
    public Response createAccount(RequestAccount body) {
        accountApiService = new AccountApiService();
        return accountApiService.post(body, "/Account/v1/GenerateToken");
    }

    @Override
    public Response generateAccountToken(RequestAccount body) {
        accountApiService = new AccountApiService();
        return accountApiService.post(body, "/Account/v1/GenerateToken");
    }

    @Override
    public Response getSpecificAccount(String token, String userId) {
        return null;
    }

    @Override
    public Response deleteSpecificAccount(String token, String userId) {
        return null;
    }
}
