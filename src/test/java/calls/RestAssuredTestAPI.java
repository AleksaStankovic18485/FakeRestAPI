package calls;

import DataModels.GetBooksRequest;
import DataModels.GetBooksResponse;
import com.google.gson.Gson;
import common.GsonFunctions;
import common.RestAssuredFunctions;
import io.restassured.response.Response;

public class RestAssuredTestAPI {

    public static Response listOfBooksResponse() {
        return RestAssuredFunctions.get("api/v1/Books");
    }

    public static GetBooksResponse knjige( GetBooksRequest postBooks){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post("api/v1/Books", postBooks), GetBooksResponse.class);
    }

    public static GetBooksResponse updateBook(GetBooksRequest putBook) {
        return GsonFunctions.parseSuccessResponseToModel(
                RestAssuredFunctions.put("api/v1/Books", putBook.getId(), putBook),
                GetBooksResponse.class
        );
    }

    public static boolean deleteBook(int id) {
        Response response = RestAssuredFunctions.delete("api/v1/Books", id);
        return response.getStatusCode() == 200;
    }

    public static GetBooksResponse getBookById(int id) {
        Response response = RestAssuredFunctions.getById("api/v1/Books", id);
        return GsonFunctions.parseSuccessResponseToModel(response, GetBooksResponse.class);
    }
}