package epiandroid.app.models.infos.board;

import java.io.Serializable;

public class Ticket implements Serializable {
    private String code;
    private String shortcode;
    private String login;
    private String creator;
    private String user_title;
    private String picture;
    private String location;
    private String date_creation;
    private String date_update;
    private String status;
    private String title;
    private String assigned;
    private String diffused;
    private String type;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getShortcode() {
        return shortcode;
    }

    public void setShortcode(String shortcode) {
        this.shortcode = shortcode;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getUser_title() {
        return user_title;
    }

    public void setUser_title(String user_title) {
        this.user_title = user_title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate_creation() {
        return date_creation;
    }

    public void setDate_creation(String date_creation) {
        this.date_creation = date_creation;
    }

    public String getDate_update() {
        return date_update;
    }

    public void setDate_update(String date_update) {
        this.date_update = date_update;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAssigned() {
        return assigned;
    }

    public void setAssigned(String assigned) {
        this.assigned = assigned;
    }

    public String getDiffused() {
        return diffused;
    }

    public void setDiffused(String diffused) {
        this.diffused = diffused;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
