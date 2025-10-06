package common;

import io.restassured.response.Response;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

public class RestAssuredFunctions {

    public static Response get(String url){
        return given()
                .contentType(ContentType.JSON)
                .get(url);
    }

    public static Response getById(String url, int id) {
        return given()
                .contentType(ContentType.JSON)
                .get(url + "/" + id);
    }


    public static Response post(String url, Object body) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .post(url);
    }


    public static Response put(String url, int id, Object body) {
        return given()
                .contentType(ContentType.JSON)
                .body(body)
                .put(url + "/" + id);
    }


    public static Response delete(String url, int id) {
        return given()
                .contentType(ContentType.JSON)
                .delete(url + "/" + id);
    }

}
