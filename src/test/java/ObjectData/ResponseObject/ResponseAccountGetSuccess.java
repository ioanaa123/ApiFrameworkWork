package ObjectData.ResponseObject;

import ObjectData.BookObject.BookObject;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ResponseAccountGetSuccess {
    @JsonProperty("userId")
    private String userId;

    @JsonProperty("username")
    private String username;

    @JsonProperty("books")
    private List<BookObject> books;

    public String getUserID() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public List<BookObject> getBooks() {
        return books;
    }


}
