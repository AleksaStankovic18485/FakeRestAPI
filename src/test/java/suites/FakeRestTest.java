package suites;

import DataModels.Books;
import calls.BooksApi;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Type;
import java.util.List;

public class FakeRestTest {

    public SoftAssert softAssert= new SoftAssert();

    public static boolean isBooksExists(Integer id) {

        Response response = BooksApi.listOfBooksResponse();
        String json = response.getBody().asString();

        Type listType = new TypeToken<List<Books>>() {}.getType();
        List<Books> booksList = new Gson().fromJson(json, listType);

        for (Books book : booksList) {
            if (book.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

}

