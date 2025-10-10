package DataModels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class InvalidParamsUsersRequest implements Serializable {

    @SerializedName("id")
    @Expose
    private Integer id;

    @SerializedName("userName")
    @Expose
    private Integer userName;

    @SerializedName("password")
    @Expose
    private String password;

    private final static long serialVersionUID = 1528647374608478116L;

    public InvalidParamsUsersRequest() {}

    public InvalidParamsUsersRequest(Integer id, Integer userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserName() {
        return userName;
    }

    public void setUserName(Integer userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}