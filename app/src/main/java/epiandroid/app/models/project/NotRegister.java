package epiandroid.app.models.project;

import java.util.List;

public class NotRegister {
    private String login;
    private String picture;
    private String title;
    private String location;
    private int promo;
    private String course_code;
    private String grade;
    private String cycle;
    private String date_ins;
    private int credits;
    private List<String>flags;
    private String semester;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getPromo() {
        return promo;
    }

    public void setPromo(int promo) {
        this.promo = promo;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getDate_ins() {
        return date_ins;
    }

    public void setDate_ins(String date_ins) {
        this.date_ins = date_ins;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public List<String> getFlags() {
        return flags;
    }

    public void setFlags(List<String> flags) {
        this.flags = flags;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
