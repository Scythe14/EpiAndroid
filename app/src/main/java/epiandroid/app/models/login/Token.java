package epiandroid.app.models.login;
import epiandroid.app.models.other.Error;

public class Token {
    private Error error = new Error();
    private String token;

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}