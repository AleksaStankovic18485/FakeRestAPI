package test;

import DataModels.GetBooksRequest;
import DataModels.GetBooksResponse;
import calls.RestAssuredTestAPI;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import common.RestAssuredFunctions;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import test.common.TestBase;

public class BooksTests extends TestBase {

    public static void main(String[] args) {

        GetBooksRequest postBook = new  GetBooksRequest();
        GetBooksResponse postBooksResp= RestAssuredTestAPI.knjige(postBook);
    }

    @Test
    public void getActivities_shouldReturn200() {
        Response response = RestAssuredFunctions.get("api/v1/Activities");

        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response body:\n" + response.getBody().asString());

        Assert.assertEquals(response.getStatusCode(), 200, "Status code 200");

        JsonArray activities = JsonParser.parseString(response.getBody().asString()).getAsJsonArray();

        Assert.assertTrue(activities.size() > 0, "Lista aktivnosti ne treba da bude prazna");

    }
}

