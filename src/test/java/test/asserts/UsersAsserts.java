package test.asserts;

import DataModels.UsersRequest;
import DataModels.UsersResponse;
import calls.UsersApi;
import org.testng.asserts.SoftAssert;

public class UsersAsserts {
    public SoftAssert softAssert=new SoftAssert();
    public void assertCreateNewUser(UsersRequest request, UsersResponse response){
        softAssert.assertEquals(response.getId(), request.getId(), "ID mismatch");
        softAssert.assertEquals(response.getUserName(), request.getUserName(), "Users mismatch");
        softAssert.assertEquals(response.getPassword(), request.getPassword(), "Password mismatch");

        softAssert.assertAll();
    }
    public void assertListOfUsers(UsersResponse[] usersResponse){
        for (int i=0; i<usersResponse.length; i++){
            softAssert.assertFalse(usersResponse[i].getUserName().isEmpty(), "Username mismatch");
        }
        softAssert.assertAll();
    }
    public static boolean isUserExists(Integer id){
        UsersResponse[] listOfUsers = UsersApi.listOfUsersResponse();
        for (int i=0; i<listOfUsers.length; i++){
            if(listOfUsers[i].getId().equals(id)){
                return true;
            }
        }
        return false;
    }

}
