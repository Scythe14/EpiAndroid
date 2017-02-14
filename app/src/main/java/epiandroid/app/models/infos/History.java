package epiandroid.app.models.infos;

import epiandroid.app.models.infos.board.User;
import org.codehaus.jackson.annotate.JsonProperty;

import java.io.Serializable;

public class History implements Serializable {
    @JsonProperty("class")
    private String klass;
    private String title;
    private User user;
    private String content;
    private String date;
    private String id;
    private String visible;
    private String id_activite;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public String getId_activite() {
        return id_activite;
    }

    public void setId_activite(String id_activite) {
        this.id_activite = id_activite;
    }

    public String getclass() {
        return klass;
    }

    public void setclass(String klass) {
        this.klass = klass;
    }
}
