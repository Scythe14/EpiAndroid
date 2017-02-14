package epiandroid.app.models.infos;

import java.io.Serializable;

public class Current implements Serializable {
    private String credits_min;
    private String credits_norm;
    private String credits_obj;
    private String nslog_min;
    private String nslog_norm;
    private String credits;
    private String grade;
    private String cycle;
    private String code_module;
    private String current_cycle;
    private String semester_code;
    private String semester_num;
    private String active_log;

    public String getCredits_min() {
        return credits_min;
    }

    public void setCredits_min(String credits_min) {
        this.credits_min = credits_min;
    }

    public String getCredits_norm() {
        return credits_norm;
    }

    public void setCredits_norm(String credits_norm) {
        this.credits_norm = credits_norm;
    }

    public String getCredits_obj() {
        return credits_obj;
    }

    public void setCredits_obj(String credits_obj) {
        this.credits_obj = credits_obj;
    }

    public String getNslog_min() {
        return nslog_min;
    }

    public void setNslog_min(String nslog_min) {
        this.nslog_min = nslog_min;
    }

    public String getNslog_norm() {
        return nslog_norm;
    }

    public void setNslog_norm(String nslog_norm) {
        this.nslog_norm = nslog_norm;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
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

    public String getCode_module() {
        return code_module;
    }

    public void setCode_module(String code_module) {
        this.code_module = code_module;
    }

    public String getCurrent_cycle() {
        return current_cycle;
    }

    public void setCurrent_cycle(String current_cycle) {
        this.current_cycle = current_cycle;
    }

    public String getSemester_code() {
        return semester_code;
    }

    public void setSemester_code(String semester_code) {
        this.semester_code = semester_code;
    }

    public String getSemester_num() {
        return semester_num;
    }

    public void setSemester_num(String semester_num) {
        this.semester_num = semester_num;
    }

    public String getActive_log() {
        return active_log;
    }

    public void setActive_log(String active_log) {
        this.active_log = active_log;
    }
}
