package epiandroid.app.models.planning;

public class Planning {
    private boolean allow_register;
    private String codeinstance;
    private String acti_title;
    private boolean allow_token;
    private String codeacti;
    private boolean module_registered;
    private String codemodule;
    private String project;
    private boolean module_available;
    private String titlemodule;
    private String type_title;
    private String type_code;
    private int nb_group;
    private int num_event;
    private int semester;
    private String scolaryear;
    private String start;
    private String codeevent;
    private boolean in_more_than_one_month;
    private String display;
    private String dates;
    private String nb_max_students_projet;
    private String is_rdv;
    private String instance_location;
    private String status_manager;
    private String title;
    private String event_registered;
    private String end;
    private String past;
    private int total_students_registered;

    public String getEvent_registered() {
        return event_registered;
    }

    public void setEvent_registered(String event_registered) {
        this.event_registered = event_registered;
    }

    public boolean isAllow_register() {
        return allow_register;
    }

    public void setAllow_register(boolean allow_register) {
        this.allow_register = allow_register;
    }

    public String getCodeinstance() {
        return codeinstance;
    }

    public void setCodeinstance(String codeinstance) {
        this.codeinstance = codeinstance;
    }

    public String getActi_title() {
        return acti_title;
    }

    public void setActi_title(String acti_title) {
        this.acti_title = acti_title;
    }

    public boolean isAllow_token() {
        return allow_token;
    }

    public void setAllow_token(boolean allow_token) {
        this.allow_token = allow_token;
    }
    public String getCodeacti() {
        return codeacti;
    }

    public void setCodeacti(String codeacti) {
        this.codeacti = codeacti;
    }

    public boolean isModule_registered() {
        return module_registered;
    }

    public void setModule_registered(boolean module_registered) {
        this.module_registered = module_registered;
    }

    public boolean getModule_registered() {
        return this.module_registered;
    }

    public String getCodemodule() {
        return codemodule;
    }

    public void setCodemodule(String codemodule) {
        this.codemodule = codemodule;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public boolean isModule_available() {
        return module_available;
    }

    public void setModule_available(boolean module_available) {
        this.module_available = module_available;
    }

    public String getTitlemodule() {
        return titlemodule;
    }

    public void setTitlemodule(String titlemodule) {
        this.titlemodule = titlemodule;
    }

    public String getType_title() {
        return type_title;
    }

    public void setType_title(String type_title) {
        this.type_title = type_title;
    }

    public String getType_code() {
        return type_code;
    }

    public void setType_code(String type_code) {
        this.type_code = type_code;
    }

    public int getNb_group() {
        return nb_group;
    }

    public void setNb_group(int nb_group) {
        this.nb_group = nb_group;
    }

    public int getNum_event() {
        return num_event;
    }

    public void setNum_event(int num_event) {
        this.num_event = num_event;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getScolaryear() {
        return scolaryear;
    }

    public void setScolaryear(String scolaryear) {
        this.scolaryear = scolaryear;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getCodeevent() {
        return codeevent;
    }

    public void setCodeevent(String codeevent) {
        this.codeevent = codeevent;
    }

    public boolean isIn_more_than_one_month() {
        return in_more_than_one_month;
    }

    public void setIn_more_than_one_month(boolean in_more_than_one_month) {
        this.in_more_than_one_month = in_more_than_one_month;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getNb_max_students_projet() {
        return nb_max_students_projet;
    }

    public void setNb_max_students_projet(String nb_max_students_projet) {
        this.nb_max_students_projet = nb_max_students_projet;
    }

    public String getIs_rdv() {
        return is_rdv;
    }

    public void setIs_rdv(String is_rdv) {
        this.is_rdv = is_rdv;
    }

    public String getInstance_location() {
        return instance_location;
    }

    public void setInstance_location(String instance_location) {
        this.instance_location = instance_location;
    }

    public String getStatus_manager() {
        return status_manager;
    }

    public void setStatus_manager(String status_manager) {
        this.status_manager = status_manager;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getPast() {
        return past;
    }

    public void setPast(String past) {
        this.past = past;
    }

    public int getTotal_students_registered() {
        return total_students_registered;
    }

    public void setTotal_students_registered(int total_students_registered) {
        this.total_students_registered = total_students_registered;
    }
}
