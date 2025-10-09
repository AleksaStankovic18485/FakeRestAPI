package test.asserts;

import DataModels.BooksRequest;
import DataModels.BooksResponse;
import calls.BooksApi;
import org.testng.asserts.SoftAssert;

public class BooksAsserts {

    public SoftAssert softAssert= new SoftAssert();

    public void assertCreateNewBook(BooksRequest request, BooksResponse response) {
        softAssert.assertEquals(response.getId(), request.getId(), "ID mismatch");
        softAssert.assertEquals(response.getTitle(), request.getTitle(), "Title mismatch");
        softAssert.assertEquals(response.getDescription(), request.getDescription(), "Description mismatch");
        softAssert.assertEquals(response.getPageCount(), request.getPageCount(), "Page count mismatch");
        softAssert.assertEquals(response.getExcerpt(), request.getExcerpt(), "Excerpt mismatch");
        softAssert.assertEquals(response.getPublishDate(), request.getPublishDate(), "Publish date mismatch");

        softAssert.assertAll();
    }

    public void assertListOfBooks(BooksResponse[] booksResponse) {
        for (int i=0; i<booksResponse.length; i++){
            softAssert.assertFalse(booksResponse[i].getTitle().isEmpty(), "Title mismatch");
        }
        softAssert.assertAll();
    }

    public static boolean isBookExists(Integer id){
        BooksResponse[] listofBooks = BooksApi.listOfBooksResponse();
        for (int i=0; i< listofBooks.length; i++){
            if(listofBooks[i].getId().equals(id)){
                return true;
            }
        }
        return false;
    }
//    public void assertDeletedBook(int id) {
//        Response response = RestAssuredTestAPI.getBookByIdRaw(id); // metoda koja vraća Response, ne parsira
//        SoftAssert softAssert = new SoftAssert();
//
//        softAssert.assertEquals(response.getStatusCode(), 404, "Expected 404 after deleting book");
//
//        softAssert.assertAll();
//    }
}