package epiandroid.app.models.modules;

public class Modules {
    private UserModule[] modules;

    public UserModule[] getModules() {
        return modules;
    }

    public void setModules(UserModule[] modules) {
        this.modules = modules;
    }

    static public class UserModule {
        private int scolaryear;
        private String id_user_history;
        private String codemodule;
        private String codeinstance;
        private String title;
        private String id_instance;
        private String cycle;
        private String grade;
        private int credits;
        private String flags;
        private int barrage;
        private String instance_id;
        private String module_rating;
        private int semester;

        public int getScolaryear() {
            return scolaryear;
        }

        public void setScolaryear(int scolaryear) {
            this.scolaryear = scolaryear;
        }

        public String getId_user_history() {
            return id_user_history;
        }

        public void setId_user_history(String id_user_history) {
            this.id_user_history = id_user_history;
        }

        public String getCodemodule() {
            return codemodule;
        }

        public void setCodemodule(String codemodule) {
            this.codemodule = codemodule;
        }

        public String getCodeinstance() {
            return codeinstance;
        }

        public void setCodeinstance(String codeinstance) {
            this.codeinstance = codeinstance;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getId_instance() {
            return id_instance;
        }

        public void setId_instance(String id_instance) {
            this.id_instance = id_instance;
        }

        public String getCycle() {
            return cycle;
        }

        public void setCycle(String cycle) {
            this.cycle = cycle;
        }

        public String getGrade() {
            return grade;
        }

        public void setGrade(String grade) {
            this.grade = grade;
        }

        public int getCredits() {
            return credits;
        }

        public void setCredits(int credits) {
            this.credits = credits;
        }

        public String getFlags() {
            return flags;
        }

        public void setFlags(String flags) {
            this.flags = flags;
        }

        public int getBarrage() {
            return barrage;
        }

        public void setBarrage(int barrage) {
            this.barrage = barrage;
        }

        public String getInstance_id() {
            return instance_id;
        }

        public void setInstance_id(String instance_id) {
            this.instance_id = instance_id;
        }

        public String getModule_rating() {
            return module_rating;
        }

        public void setModule_rating(String module_rating) {
            this.module_rating = module_rating;
        }

        public int getSemester() {
            return semester;
        }

        public void setSemester(int semester) {
            this.semester = semester;
        }
    }
}
