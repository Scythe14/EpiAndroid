package epiandroid.app.models.allmodules;

/**
 * Created by bouca-_d on 29/01/2016.
 */

public class Preload {
    private int token;
    private int scolaryear;
    private String location;
    private String course;
    private String coursePrecises;

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public int getScolaryear() {
        return scolaryear;
    }

    public void setScolaryear(int scolaryear) {
        this.scolaryear = scolaryear;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCoursePrecises() {
        return coursePrecises;
    }

    public void setCoursePrecises(String coursePrecises) {
        this.coursePrecises = coursePrecises;
    }
}
