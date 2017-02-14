package epiandroid.app.models.infos;

import epiandroid.app.models.infos.board.*;

import java.io.Serializable;
import java.util.List;

public class Board implements Serializable {
    private List<Note>      notes;
    private List<Project>   projets;
    private List<Activity>  activites;
    private List<Module>    modules;
    private List<Stage>     stages;
    private List<Ticket>    tickets;
    private List<Susie>     susies;

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public List<Project> getProjets() {
        return projets;
    }

    public void setProjets(List<Project> projets) {
        this.projets = projets;
    }

    public List<Activity> getActivites() {
        return activites;
    }

    public void setActivites(List<Activity> activites) {
        this.activites = activites;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public List<Stage> getStages() {
        return stages;
    }

    public void setStages(List<Stage> stages) {
        this.stages = stages;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public List<Susie> getSusies() {
        return susies;
    }

    public void setSusies(List<Susie> susies) {
        this.susies = susies;
    }

    public class Susie implements Serializable {}
}
