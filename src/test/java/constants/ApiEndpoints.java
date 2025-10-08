package constants;

import DataModels.Users;

public class ApiEndpoints {

    //Aktivnosti
    public static final String ACTIVITIES = "/api/v1/Activities";
    public static String SINGLE_ACTIVITY(Integer id) {return ACTIVITIES+"/"+id;}

    //Autoi
    public static final String AUTHORS = "/api/v1/Authors";
    public static String SINGLE_AUTHOR(Integer id) {return AUTHORS+"/"+id;}

    //KoverSlike
    public static final String COVERPHOTOS = "/api/v1/coverPhotos";
    public static String SINGLE_COVERPHOTO(Integer id) {return COVERPHOTOS+"/"+id;}

    //Knjige
    public static final String BOOKS = "/api/v1/Books";
    public static String SINGLE_BOOK(Integer id) {return BOOKS+"/"+id;}

    //Korisnici
    public static final String USERS = "/api/v1/Users";
    public static String SINGLE_USER(Integer id) {return USERS +"/"+id;}

}
