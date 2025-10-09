package calls;

import DataModels.UsersRequest;
import DataModels.UsersResponse;
import com.google.gson.GsonBuilder;
import common.GsonFunctions;
import common.RestAssuredFunctions;
import constants.ApiEndpoints;
import io.restassured.response.Response;

public class UsersApi {

    public static UsersResponse[] listOfUsersResponse() {
        return GsonFunctions.parseSuccessResponseToModel(
                RestAssuredFunctions.get(ApiEndpoints.USERS),
                UsersResponse[].class
        );
    }

    public static UsersResponse postUser(UsersRequest postUser) {
        String jsonPayload = new GsonBuilder().setPrettyPrinting().create().toJson(postUser);
        System.out.println("Sending JSON payload:\n" + jsonPayload);

        return GsonFunctions.parseSuccessResponseToModel(
                RestAssuredFunctions.post(ApiEndpoints.USERS, postUser),
                UsersResponse.class
        );
    }

    public static UsersResponse updateUser(UsersRequest putUser) {
        return GsonFunctions.parseSuccessResponseToModel(
                RestAssuredFunctions.put(ApiEndpoints.USERS, putUser.getId(), putUser),
                UsersResponse.class
        );
    }

    public static Response deleteUser(int id) {
        return RestAssuredFunctions.delete(ApiEndpoints.USERS, id);
    }

    public static UsersResponse getUserById(int id) {
        Response response = RestAssuredFunctions.getById(ApiEndpoints.USERS, id);
        return GsonFunctions.parseSuccessResponseToModel(response, UsersResponse.class);
    }
}