package test;

import common.RestAssuredFunctions;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import test.common.TestBase;

public class GETActivities extends TestBase {

    @Test
    public void getActivities_shouldReturn200() {
        Response response = RestAssuredFunctions.get("api/v1/Activities");

        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response body:\n" + response.getBody().asString());
    }
}

