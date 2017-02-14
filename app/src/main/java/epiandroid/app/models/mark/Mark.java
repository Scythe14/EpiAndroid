package epiandroid.app.models.mark;

import java.io.Serializable;
import java.util.List;

public class Mark implements Serializable {
    private List<Note> notes;

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public static class Note {
        public int scolaryear;
        public String codemodule;
        public String titlemodule;
        public String codeinstance;
        public String codeacti;
        public String title;
        public String date;
        public String correcteur;
        public float final_note;
        public String comment;

        public int getScolaryear() {
            return scolaryear;
        }

        public void setScolaryear(int scolaryear) {
            this.scolaryear = scolaryear;
        }

        public String getCodemodule() {
            return codemodule;
        }

        public void setCodemodule(String codemodule) {
            this.codemodule = codemodule;
        }

        public String getTitlemodule() {
            return titlemodule;
        }

        public void setTitlemodule(String titlemodule) {
            this.titlemodule = titlemodule;
        }

        public String getCodeinstance() {
            return codeinstance;
        }

        public void setCodeinstance(String codeinstance) {
            this.codeinstance = codeinstance;
        }

        public String getCodeacti() {
            return codeacti;
        }

        public void setCodeacti(String codeacti) {
            this.codeacti = codeacti;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getCorrecteur() {
            return correcteur;
        }

        public void setCorrecteur(String correcteur) {
            this.correcteur = correcteur;
        }

        public float getFinal_note() {
            return final_note;
        }

        public void setFinal_note(float final_note) {
            this.final_note = final_note;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }
    }
}
