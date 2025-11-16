package ObjectData.ResponseObject;

import ObjectData.BookObject.BookObject;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseAccountSuccess {
    @JsonProperty("userID")
    private String userID;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("books")
    private List<BookObject> books;

    public String getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public List<BookObject> getBooks() {
        return books;
    }
}
