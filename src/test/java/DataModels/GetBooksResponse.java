package DataModels;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class GetBooksResponse implements Serializable {

    @SerializedName("access")
    @Expose
    private String access;
    @SerializedName("refresh")
    @Expose
    private String refresh;

    public GetBooksResponse() {

    }

    public GetBooksResponse(String access, String refresh) {
        this.access = access;
        this.refresh = refresh;
    }

    public String getAccess() {return access;}
    public void setAccess(String access) {this.access = access;}
    public String getRefresh() {return refresh;}
    public void setRefresh(String refresh) {this.refresh = refresh;}
}
