package epiandroid.app.models.infos;

import java.io.Serializable;

public class Info implements Serializable {
    private String id;
    private String login;
    private String title;
    private String email;
    private String internal_email;
    private String lastname;
    private String firstname;
    private String userinfo;
    private String referent_used;
    private String picture;
    private String picture_fun;
    private String email_referent;
    private String pass_referent;
    private String scolaryear;
    private int promo;
    private int semester;
    private int uid;
    private int gid;
    private String location;
    private String documents;
    private String userdocs;
    private String shell;
    private String netsoul;
    private String close;
    private String close_reason;
    private String ctime;
    private String mtime;
    private String comment;
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
    private String invited;
    private int studentyear;
    private String admin;
    private int decoded;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public String getUserinfo() {
        return userinfo;
    }

    public void setUserinfo(String userinfo) {
        this.userinfo = userinfo;
    }

    public String getReferent_used() {
        return referent_used;
    }

    public void setReferent_used(String referent_used) {
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

    public String getEmail_referent() {
        return email_referent;
    }

    public void setEmail_referent(String email_referent) {
        this.email_referent = email_referent;
    }

    public String getPass_referent() {
        return pass_referent;
    }

    public void setPass_referent(String pass_referent) {
        this.pass_referent = pass_referent;
    }

    public String getScolaryear() {
        return scolaryear;
    }

    public void setScolaryear(String scolaryear) {
        this.scolaryear = scolaryear;
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

    public String getNetsoul() {
        return netsoul;
    }

    public void setNetsoul(String netsoul) {
        this.netsoul = netsoul;
    }

    public String getClose() {
        return close;
    }

    public void setClose(String close) {
        this.close = close;
    }

    public String getClose_reason() {
        return close_reason;
    }

    public void setClose_reason(String close_reason) {
        this.close_reason = close_reason;
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

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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

    public String getSemester_code() {
        return semester_code;
    }

    public void setSemester_code(String semester_code) {
        this.semester_code = semester_code;
    }

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
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

    public String getInvited() {
        return invited;
    }

    public void setInvited(String invited) {
        this.invited = invited;
    }

    public int getStudentyear() {
        return studentyear;
    }

    public void setStudentyear(int studentyear) {
        this.studentyear = studentyear;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public int getDecoded() {
        return decoded;
    }

    public void setDecoded(int decoded) {
        this.decoded = decoded;
    }

    public class Right implements Serializable {}
}
