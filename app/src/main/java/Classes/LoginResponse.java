package Classes;

public class LoginResponse {

    private String message ;
    private boolean error ;
    private Users user;





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



}
