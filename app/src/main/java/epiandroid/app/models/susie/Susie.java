package epiandroid.app.models.susie;

import epiandroid.app.models.other.Calendar;
import epiandroid.app.models.other.Maker;
import epiandroid.app.models.other.Owner;
import epiandroid.app.models.other.Right;

import java.util.List;

public class Susie {
    private int id;
    private int id_calendar;
    private String location;
    private String type_room;
    private String type;
    private String start;
    private String end;
    private String title;
    private String description;
    private int nb_place;
    private String color;
    private boolean confirm_owner;
    private boolean confirm_maker;
    private String id_owner;
    private String id_maker;
    private String rating_event;
    private String rating_student;
    private String duration;
    private List<Login> logins;
    private Right rights;
    private Calendar calendar;
    private Owner owner;
    private Maker maker;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_calendar() {
        return id_calendar;
    }

    public void setId_calendar(int id_calendar) {
        this.id_calendar = id_calendar;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType_room() {
        return type_room;
    }

    public void setType_room(String type_room) {
        this.type_room = type_room;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNb_place() {
        return nb_place;
    }

    public void setNb_place(int nb_place) {
        this.nb_place = nb_place;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isConfirm_owner() {
        return confirm_owner;
    }

    public void setConfirm_owner(boolean confirm_owner) {
        this.confirm_owner = confirm_owner;
    }

    public boolean isConfirm_maker() {
        return confirm_maker;
    }

    public void setConfirm_maker(boolean confirm_maker) {
        this.confirm_maker = confirm_maker;
    }

    public String getId_owner() {
        return id_owner;
    }

    public void setId_owner(String id_owner) {
        this.id_owner = id_owner;
    }

    public String getId_maker() {
        return id_maker;
    }

    public void setId_maker(String id_maker) {
        this.id_maker = id_maker;
    }

    public String getRating_event() {
        return rating_event;
    }

    public void setRating_event(String rating_event) {
        this.rating_event = rating_event;
    }

    public String getRating_student() {
        return rating_student;
    }

    public void setRating_student(String rating_student) {
        this.rating_student = rating_student;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public List<Login> getLogins() {
        return logins;
    }

    public void setLogins(List<Login> logins) {
        this.logins = logins;
    }

    public Right getRights() {
        return rights;
    }

    public void setRights(Right rights) {
        this.rights = rights;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Maker getMaker() {
        return maker;
    }

    public void setMaker(Maker maker) {
        this.maker = maker;
    }
}
