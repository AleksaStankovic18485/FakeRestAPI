package test.suites;

import DataModels.BooksRequest;
import DataModels.BooksResponse;
import calls.BooksApi;
import jdk.jfr.Description;
import org.testng.annotations.Test;
import test.asserts.BooksAsserts;
import test.common.TestBase;

public class BooksTests extends TestBase {

    public static void main(String[] args) {

        BooksRequest postBook = new BooksRequest();
        BooksResponse postBooksResp= BooksApi.postBook(postBook);
    }

    public BooksAsserts booksAsserts = new BooksAsserts();

//    @Test
//    @Description("Verify book has been created")
//    public void createBookTest(){
//        BooksRequest createBookRequest = new BooksRequest(102,"Mokra krpa na dnu mora", "Govori sama za sebe", 102, "Krpa na dnu mora se sva nakvasila, kako sokantno", "2025-10-06T13:37:13.983Z");
//
//        BooksResponse createBooksResponse = BooksApi.postBook(createBookRequest);
//
//        booksAsserts.assertCreateNewBook(createBookRequest, createBooksResponse);
//    }
//
//    @Test
//    @Description("Get all")
//    public void getListOfBooks() {
//        BooksResponse[] booksResponse = BooksApi.listOfBooksResponse();
//        booksAsserts.assertListOfBooks(booksResponse);
//    }
}

