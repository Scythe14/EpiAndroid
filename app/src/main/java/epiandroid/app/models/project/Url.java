package epiandroid.app.models.project;

public class Url {
    private boolean notation;
    private String title;
    private String link;

    public boolean isNotation() {
        return notation;
    }

    public void setNotation(boolean notation) {
        this.notation = notation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
