package test.suites;

import DataModels.ErrorResponse;
import DataModels.BooksRequest;
import DataModels.InvalidParamsBooksRequest;
import calls.BooksApi;
import constants.ErrorMessages;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.asserts.BooksAsserts;
import test.asserts.CommonErrorAssert;
import test.common.TestBase;

public class BooksSecurityTests extends TestBase {

    public BooksAsserts booksAsserts = new BooksAsserts();
    BooksRequest booksRequest;
    Integer idOfNewBook;

    @BeforeMethod
    public void prepareTestData(){
        booksRequest = new BooksRequest(-1, "Proba", "Proba1", 100, "Nema", "2025-10-06T13:37:13.983Z");
        idOfNewBook =  BooksApi.postBook(booksRequest).getId();
    }

    @Test
    public void verifyCannotGetBook() {

        ErrorResponse actualError = BooksApi.getBookWithError(idOfNewBook);

        CommonErrorAssert commonErrorAssert = new CommonErrorAssert();
        commonErrorAssert.assertBookErrorResponse(actualError, new ErrorResponse(ErrorMessages.NOT_FOUND, 404));
    }

    @Test
    public void verifyDeleteBook() {
        BooksApi.deleteBook(idOfNewBook);
        Assert.assertFalse(BooksAsserts.isBookExists(idOfNewBook), "Books is not deleted");
    }

    @Test
    public void verifyCreateBookInvalidParams() {

        ErrorResponse actualError = BooksApi.createBookError(new InvalidParamsBooksRequest(1, 1, "", 100, "Nema", "2025-10-06T13:37:13.983Z"));

        CommonErrorAssert commonErrorAssert= new CommonErrorAssert();
        commonErrorAssert.assertBookErrorResponse(actualError, new ErrorResponse(ErrorMessages.VALIDATION, 400));
    }
}
