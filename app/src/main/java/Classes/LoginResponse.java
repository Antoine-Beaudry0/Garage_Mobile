package Classes;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("message")

    private String message ;
    private boolean error ;
    @SerializedName("user")

    private Users user;

    private String token;

    public LoginResponse(String message, boolean error, Users user) {
        this.message = message;
        this.error = error;
        this.user = user;
    }

    public String getMessage() {
        return message;
    }

    public boolean isError() {
        return error;
    }

    public Users getUser() {
        return user;
    }

    // Getter pour token
    public String getToken() {
        return token;
    }

    // Setter pour token
    public void setToken(String token) {
        this.token = token;
    }



}
