package calls;

import DataModels.BooksRequest;
import DataModels.BooksResponse;
import common.GsonFunctions;
import common.RestAssuredFunctions;
import constants.ApiEndpoints;
import io.restassured.response.Response;

public class BooksApi {

    public static BooksResponse[] listOfBooksResponse() {

        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.get(ApiEndpoints.BOOKS), BooksResponse[].class);
    }

    public static BooksResponse postBook(BooksRequest postBooks){
        return GsonFunctions.parseSuccessResponseToModel(RestAssuredFunctions.post(ApiEndpoints.BOOKS, postBooks), BooksResponse.class);
    }

    public static BooksResponse updateBook(BooksRequest putBook) {
        return GsonFunctions.parseSuccessResponseToModel(
                RestAssuredFunctions.put(ApiEndpoints.BOOKS, putBook.getId(), putBook),
                BooksResponse.class
        );
    }

    public static Response deleteBook(int id) {
        return RestAssuredFunctions.delete(ApiEndpoints.BOOKS, id);
    }

    public static BooksResponse getBookById(int id) {
        Response response = RestAssuredFunctions.getById(ApiEndpoints.BOOKS, id);
        return GsonFunctions.parseSuccessResponseToModel(response, BooksResponse.class);
    }
}