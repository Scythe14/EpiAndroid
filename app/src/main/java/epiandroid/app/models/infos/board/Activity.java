package epiandroid.app.models.infos.board;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import epiandroid.app.R;

import java.io.Serializable;

public class Activity extends HomeInfo implements Serializable {
    private String title;
    private String module;
    private String module_link;
    private String module_code;
    private String title_link;
    private String timeline_start;
    private String timeline_end;
    private String timeline_barre;
    private String date_inscription;
    private String salle;
    private String intervenant;
    private String token;
    private String token_link;
    private String register_link;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getModule_link() {
        return module_link;
    }

    public void setModule_link(String module_link) {
        this.module_link = module_link;
    }

    public String getModule_code() {
        return module_code;
    }

    public void setModule_code(String module_code) {
        this.module_code = module_code;
    }

    public String getTitle_link() {
        return title_link;
    }

    public void setTitle_link(String title_link) {
        this.title_link = title_link;
    }

    public String getTimeline_start() {
        return timeline_start;
    }

    public void setTimeline_start(String timeline_start) {
        this.timeline_start = timeline_start;
    }

    public String getTimeline_end() {
        return timeline_end;
    }

    public void setTimeline_end(String timeline_end) {
        this.timeline_end = timeline_end;
    }

    public String getTimeline_barre() {
        return timeline_barre;
    }

    public void setTimeline_barre(String timeline_barre) {
        this.timeline_barre = timeline_barre;
    }

    public String getDate_inscription() {
        return date_inscription;
    }

    public void setDate_inscription(String date_inscription) {
        this.date_inscription = date_inscription;
    }

    public String getSalle() {
        return salle;
    }

    public void setSalle(String salle) {
        this.salle = salle;
    }

    public String getIntervenant() {
        return intervenant;
    }

    public void setIntervenant(String intervenant) {
        this.intervenant = intervenant;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getToken_link() {
        return token_link;
    }

    public void setToken_link(String token_link) {
        this.token_link = token_link;
    }

    public String getRegister_link() {
        return register_link;
    }

    public void setRegister_link(String register_link) {
        this.register_link = register_link;
    }

    @Override
    public void setView(View view, final Context context) {
        final RelativeLayout rl = (RelativeLayout) view.findViewById(R.id.section_item_id);
        TextView module_name = (TextView) rl.findViewById(R.id.item_name_id);
        TextView startline = (TextView) rl.findViewById(R.id.startline);
        TextView deadline = (TextView) rl.findViewById(R.id.deadline);
        TextView registration_date = (TextView) rl.findViewById(R.id.registration_date);
        TextView register = (TextView) rl.findViewById(R.id.registration);
        TextView section_info = (TextView) rl.findViewById(R.id.section_info);
        final View timeline = rl.findViewById(R.id.timeline);
        final View timeline_passed = rl.findViewById(R.id.timeline_passed);

        if (!date_inscription.isEmpty()) {
            registration_date.setText(context.getString(R.string.registration_until) + date_inscription);
            registration_date.setVisibility(View.VISIBLE);
            register.setVisibility(View.VISIBLE);
        }
        if (!salle.isEmpty()) {
            section_info.setText(salle);
            section_info.setVisibility(View.VISIBLE);
        }
        module_name.setText(title);
        deadline.setText(timeline_end);
        startline.setText(timeline_start);
        ViewTreeObserver vto = timeline_passed.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                timeline_passed.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                setTimeline(rl, context.getString(R.string.date_format));
            }
        });
    }
}
