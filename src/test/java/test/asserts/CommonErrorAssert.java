package test.asserts;

import DataModels.ErrorResponse;
import org.testng.asserts.SoftAssert;

public class CommonErrorAssert {
    private SoftAssert softAssert;

    public CommonErrorAssert() {this.softAssert = new SoftAssert();}

    public void assertBookErrorResponse(ErrorResponse actualError, ErrorResponse expectedError) {
        this.softAssert.assertEquals(actualError.getTitle(), expectedError.getTitle(), "Title didn't match");
        this.softAssert.assertEquals(actualError.getStatus(), expectedError.getStatus(), "Status didn't match");
        this.softAssert.assertAll();
    }
}
