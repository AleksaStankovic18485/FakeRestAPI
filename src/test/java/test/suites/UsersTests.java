package test.suites;

import DataModels.UsersRequest;
import DataModels.UsersResponse;
import DataProvider.UsersProvider;
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



}

