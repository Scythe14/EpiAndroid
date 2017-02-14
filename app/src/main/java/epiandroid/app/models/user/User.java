package epiandroid.app.models.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import epiandroid.app.models.other.Right;

public class User {
    private String login;
    private String title;
    private String internal_email;
    private String lastname;
    private String firstname;
    private UserInfo userinfo;
    private boolean referent_used;
    private String picture;
    private String picture_fun;
    private String scolaryear;
    private int promo;
    private int semester;
    private int uid;
    private int gid;
    private String location;
    private String documents;
    private String userdocs;
    private String shell;
    private boolean close;
    private String ctime;
    private String mtime;
    private String id_promo;
    private String id_history;
    private String course_code;
    private String semester_code;
    private String school_id;
    private String school_code;
    private String school_title;
    private String old_id_promo;
    private String old_id_location;
    private Right rights;
    private boolean invited;
    private int studentyear;
    private boolean admin;
    private boolean editable;
    @JsonIgnore
    private String locations;
    private Group[] groups;
    private int credits;
    private Gpa[] gpa;
    private Gpa[] averageGPA;
    private Spice spice;
    private NetsoulStat nsstat;

    public String getLocations() {
        return locations;
    }

    public void setLocations(String locations) {
        this.locations = locations;
    }

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    public String getSemester_code() {
        return semester_code;
    }

    public void setSemester_code(String semester_code) {
        this.semester_code = semester_code;
    }

    public String getScolaryear() {
        return scolaryear;
    }

    public void setScolaryear(String scolaryear) {
        this.scolaryear = scolaryear;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInternal_email() {
        return internal_email;
    }

    public void setInternal_email(String internal_email) {
        this.internal_email = internal_email;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public UserInfo getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(UserInfo userinfo) {
        this.userinfo = userinfo;
    }

    public boolean isReferent_used() {
        return referent_used;
    }

    public void setReferent_used(boolean referent_used) {
        this.referent_used = referent_used;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getPicture_fun() {
        return picture_fun;
    }

    public void setPicture_fun(String picture_fun) {
        this.picture_fun = picture_fun;
    }

    public int getPromo() {
        return promo;
    }

    public void setPromo(int promo) {
        this.promo = promo;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public int getGid() {
        return gid;
    }

    public void setGid(int gid) {
        this.gid = gid;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDocuments() {
        return documents;
    }

    public void setDocuments(String documents) {
        this.documents = documents;
    }

    public String getUserdocs() {
        return userdocs;
    }

    public void setUserdocs(String userdocs) {
        this.userdocs = userdocs;
    }

    public String getShell() {
        return shell;
    }

    public void setShell(String shell) {
        this.shell = shell;
    }

    public boolean isClose() {
        return close;
    }

    public void setClose(boolean close) {
        this.close = close;
    }

    public String getCtime() {
        return ctime;
    }

    public void setCtime(String ctime) {
        this.ctime = ctime;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public String getId_promo() {
        return id_promo;
    }

    public void setId_promo(String id_promo) {
        this.id_promo = id_promo;
    }

    public String getId_history() {
        return id_history;
    }

    public void setId_history(String id_history) {
        this.id_history = id_history;
    }

    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getSchool_code() {
        return school_code;
    }

    public void setSchool_code(String school_code) {
        this.school_code = school_code;
    }

    public String getSchool_title() {
        return school_title;
    }

    public void setSchool_title(String school_title) {
        this.school_title = school_title;
    }

    public String getOld_id_promo() {
        return old_id_promo;
    }

    public void setOld_id_promo(String old_id_promo) {
        this.old_id_promo = old_id_promo;
    }

    public String getOld_id_location() {
        return old_id_location;
    }

    public void setOld_id_location(String old_id_location) {
        this.old_id_location = old_id_location;
    }

    public Right getRights() {
        return rights;
    }

    public void setRights(Right rights) {
        this.rights = rights;
    }

    public boolean isInvited() {
        return invited;
    }

    public void setInvited(boolean invited) {
        this.invited = invited;
    }

    public int getStudentyear() {
        return studentyear;
    }

    public void setStudentyear(int studentyear) {
        this.studentyear = studentyear;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isEditable() {
        return editable;
    }

    public void setEditable(boolean editable) {
        this.editable = editable;
    }

    public Group[] getGroups() {
        return groups;
    }

    public void setGroups(Group[] groups) {
        this.groups = groups;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Gpa[] getGpa() {
        return gpa;
    }

    public void setGpa(Gpa[] gpa) {
        this.gpa = gpa;
    }

    public Gpa[] getAverageGPA() {
        return averageGPA;
    }

    public void setAverageGPA(Gpa[] averageGPA) {
        this.averageGPA = averageGPA;
    }

    public Spice getSpice() {
        return spice;
    }

    public void setSpice(Spice spice) {
        this.spice = spice;
    }

    public NetsoulStat getNsstat() {
        return nsstat;
    }

    public void setNsstat(NetsoulStat nsstat) {
        this.nsstat = nsstat;
    }

    static public class Gpa {
        public String gpa;
        public String cycle;
        public String gpa_average;

        public String getGpa() {
            return gpa;
        }

        public void setGpa(String gpa) {
            this.gpa = gpa;
        }

        public String getCycle() {
            return cycle;
        }

        public void setCycle(String cycle) {
            this.cycle = cycle;
        }

        public String getGpa_average() {
            return gpa_average;
        }

        public void setGpa_average(String gpa_average) {
            this.gpa_average = gpa_average;
        }
    }

    static public class Spice {
        public String available_spice;
        public int consumed_spice;

        public int getConsumed_spice() {
            return consumed_spice;
        }

        public void setConsumed_spice(int consumed_spice) {
            this.consumed_spice = consumed_spice;
        }

        public String getAvailable_spice() {

            return available_spice;
        }

        public void setAvailable_spice(String available_spice) {
            this.available_spice = available_spice;
        }
    }

    static public class Group {
        public String title;
        public String name;
        public int count;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    static public class UserInfo {
        private Credential telephone;
        private Credential birthday;
        private Credential email;
        private Credential facebook;

        public Credential getTelephone() {
            return telephone;
        }

        public void setTelephone(Credential telephone) {
            this.telephone = telephone;
        }

        public Credential getBirthday() {
            return birthday;
        }

        public void setBirthday(Credential birthday) {
            this.birthday = birthday;
        }

        public Credential getEmail() {
            return email;
        }

        public void setEmail(Credential email) {
            this.email = email;
        }

        public Credential getFacebook() {
            return facebook;
        }

        public void setFacebook(Credential facebook) {
            this.facebook = facebook;
        }

        static public class Credential {
            private String value;
            private boolean adm;
            private boolean is_public;

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public boolean isAdm() {
                return adm;
            }

            public void setAdm(boolean adm) {
                this.adm = adm;
            }

            public boolean getPublic() {
                return is_public;
            }

            public void setPublic(boolean is_public) {
                this.is_public = is_public;
            }
        }
    }

    static public class NetsoulStat {
        public float active;
        public float idle;
        public float out_active;
        public float out_idle;
        public float nslog_norm;

        public float getActive() {
            return active;
        }

        public void setActive(float active) {
            this.active = active;
        }

        public float getIdle() {
            return idle;
        }

        public void setIdle(float idle) {
            this.idle = idle;
        }

        public float getOut_active() {
            return out_active;
        }

        public void setOut_active(float out_active) {
            this.out_active = out_active;
        }

        public float getOut_idle() {
            return out_idle;
        }

        public void setOut_idle(float out_idle) {
            this.out_idle = out_idle;
        }

        public float getNslog_norm() {
            return nslog_norm;
        }

        public void setNslog_norm(float nslog_norm) {
            this.nslog_norm = nslog_norm;
        }
    }
}
