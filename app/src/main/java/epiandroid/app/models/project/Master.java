package epiandroid.app.models.project;

public class Master {
    private String login;
    private String date_ins;
    private String date_modif;
    private String status;
    private String picture;
    private String title;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getDate_ins() {
        return date_ins;
    }

    public void setDate_ins(String date_ins) {
        this.date_ins = date_ins;
    }

    public String getDate_modif() {
        return date_modif;
    }

    public void setDate_modif(String date_modif) {
        this.date_modif = date_modif;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
