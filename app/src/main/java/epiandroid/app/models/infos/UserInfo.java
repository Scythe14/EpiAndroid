package epiandroid.app.models.infos;

import epiandroid.app.models.other.Error;

import java.io.Serializable;
import java.util.List;

public class UserInfo implements Serializable {
    private String          ip;
    private Board board;
    private History[]   history;
    private Info infos;
    private Current[]  current;
    private Error error;
    private String          token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public History[] getHistory() {
        return history;
    }

    public void setHistory(History[] history) {
        this.history = history;
    }

    public Info getInfos() {
        return infos;
    }

    public void setInfos(Info infos) {
        this.infos = infos;
    }

    public Current[] getCurrent() {
        return current;
    }

    public void setCurrent(Current[] current) {
        this.current = current;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
