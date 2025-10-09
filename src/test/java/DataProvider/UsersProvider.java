package DataProvider;

import DataModels.UsersRequest;
import com.github.javafaker.Faker;

public class UsersProvider {

    public static UsersRequest prepareUsersRequest() {
        UsersRequest usersRequest = new UsersRequest();
        usersRequest.setId(Faker.instance().random().nextInt(105));
        usersRequest.setUserName(Faker.instance().name().username());
        usersRequest.setPassword("Password"+Faker.instance().random().nextInt(10));
        return usersRequest;
    }
}
