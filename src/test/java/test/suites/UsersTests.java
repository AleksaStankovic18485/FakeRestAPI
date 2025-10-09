package test.suites;

import DataModels.BooksRequest;
import DataModels.BooksResponse;
import DataModels.UsersRequest;
import DataModels.UsersResponse;
import DataProvider.BooksProvider;
import DataProvider.UsersProvider;
import calls.BooksApi;
import calls.UsersApi;
//import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.asserts.UsersAsserts;
import test.common.TestBase;

public class UsersTests extends TestBase {

    public static void main(String[] args) {

        UsersRequest postUser = new UsersRequest();
        UsersResponse postUsersResp= UsersApi.postUser(postUser);
    }

    public UsersAsserts usersAsserts = new UsersAsserts();
    UsersRequest usersRequest;
    Integer idOfNewUser;

    @BeforeMethod
    public void prepareTestData(){
        usersRequest = UsersProvider.prepareUsersRequest();
        idOfNewUser = UsersApi.postUser(usersRequest).getId();
    }

    @Test
    //@Description("Verify user has been created")
    public void createUserTest(){

        UsersResponse createUserResponse = UsersApi.postUser(usersRequest);

        usersAsserts.assertCreateNewUser(usersRequest, createUserResponse);
    }

    @Test
    //@Description("Verify that user can be updated")
    public void updateBookTest() {

        UsersRequest updatedUserRequest = UsersProvider.prepareUsersRequest();

        updatedUserRequest.setId(idOfNewUser);

        UsersResponse updatedUserResponse = UsersApi.updateUser(updatedUserRequest);

        usersAsserts.assertCreateNewUser(updatedUserRequest, updatedUserResponse);
    }
}

