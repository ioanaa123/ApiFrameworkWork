package Service.ServiceImplementation;

import InterfaceService.AccountServiceInterface;
import ObjectData.RequestObject.RequestAccount;
import Service.ApiService.AccountApiService;
import io.restassured.response.Response;

public class AccountServiceImpl implements AccountServiceInterface {

    // Facem o instanta de ApiService ca sa putem accesa metodele generale
    private AccountApiService accountApiService;

    public AccountServiceImpl() {
        accountApiService = new AccountApiService();
    }

    @Override
    public Response createAccount(RequestAccount body) {
        return accountApiService.post(body, "/Account/v1/User");
    }

    @Override
    public Response authotizeAccount(RequestAccount body) {
        return accountApiService.post(body, "/Account/v1/Authorized");
    }

    @Override
    public Response generateAccountToken(RequestAccount body) {
        return accountApiService.post(body, "/Account/v1/GenerateToken");
    }

    @Override
    public Response getSpecificAccount(String token, String userId) {
       String url = "/Account/v1/User/" + userId;
       return accountApiService.get(token, url);
    }

    @Override
    public Response deleteSpecificAccount(String token, String userId) {
        String url = "/Account/v1/User/" + userId;
        return accountApiService.delete(token, url);    }
}
