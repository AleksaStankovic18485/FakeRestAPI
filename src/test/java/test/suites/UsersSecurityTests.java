package test.suites;

import DataModels.ErrorResponse;
import DataModels.UsersRequest;
import DataModels.InvalidParamsUsersRequest;
import calls.UsersApi;
import constants.ErrorMessages;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.asserts.UsersAsserts;
import test.asserts.CommonErrorAssert;
import test.common.TestBase;

public class UsersSecurityTests extends TestBase {

    public UsersAsserts booksAsserts = new UsersAsserts();
    UsersRequest usersRequest;
    Integer idOfNewUser;

    @BeforeMethod
    public void prepareTestData(){
        usersRequest = new UsersRequest(-1, "Akica", "Test1");
        idOfNewUser =  UsersApi.postUser(usersRequest).getId();
    }

    @Test
    public void verifyCannotGetUser() {

        ErrorResponse actualError = UsersApi.getUserWithError(idOfNewUser);

        CommonErrorAssert commonErrorAssert = new CommonErrorAssert();
        commonErrorAssert.assertBookErrorResponse(actualError, new ErrorResponse(ErrorMessages.NOT_FOUND, 404));
    }

    @Test
    public void verifyUpdateBookInvalidParams() {

        ErrorResponse actualError = UsersApi.updateErrorUser(new InvalidParamsUsersRequest(1, 2, "Test1"));

        CommonErrorAssert commonErrorAssert= new CommonErrorAssert();
        commonErrorAssert.assertBookErrorResponse(actualError, new ErrorResponse(ErrorMessages.VALIDATION, 400));
    }
}
