package test.common;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class TestBase {

    @BeforeClass
    public void beforeClass() {
        RestAssured.baseURI= "https://fakerestapi.azurewebsites.net";
    }
}
