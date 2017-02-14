package epiandroid.app.models.other;

import java.io.Serializable;

public class Error implements Serializable {
    public String message;
    public int code;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
