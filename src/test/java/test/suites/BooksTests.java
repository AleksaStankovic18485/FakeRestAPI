package test.suites;

import DataModels.BooksRequest;
import DataModels.BooksResponse;
import DataProvider.BooksProvider;
import calls.BooksApi;
//import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.asserts.BooksAsserts;
import test.common.TestBase;

public class BooksTests extends TestBase {



    public static void main(String[] args) {

        BooksRequest postBook = new BooksRequest();
        BooksResponse postBooksResp= BooksApi.postBook(postBook);
    }

    public BooksAsserts booksAsserts = new BooksAsserts();
    BooksRequest booksRequest;
    Integer idOfNewBook;

    @BeforeMethod
    public void prepareTestData(){
        booksRequest = BooksProvider.prepareBooksRequest();
        idOfNewBook = BooksApi.postBook(booksRequest).getId();
    }
    @Test
    //@Description("Verify book has been created")
    public void createBookTest(){

        BooksResponse createBooksResponse = BooksApi.postBook(booksRequest);

        booksAsserts.assertCreateNewBook(booksRequest, createBooksResponse);
    }

    @Test
    //@Description("Get all books")
    public void getListOfBooks() {
        BooksResponse[] booksResponse = BooksApi.listOfBooksResponse();
        booksAsserts.assertListOfBooks(booksResponse);
    }

    @Test
    //@Description("Verify that book can be updated using prepared request")
    public void updateBookTest() {

        BooksRequest updatedBookRequest = BooksProvider.prepareBooksRequest();

        updatedBookRequest.setId(idOfNewBook);

        BooksResponse updatedBookResponse = BooksApi.updateBook(updatedBookRequest);

        booksAsserts.assertCreateNewBook(updatedBookRequest, updatedBookResponse);
    }



}

