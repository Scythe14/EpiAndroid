package epiandroid.app.models.infos.board;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import epiandroid.app.R;

import java.io.Serializable;

public class Stage extends HomeInfo implements Serializable {
    private String company;
    private String link;
    private String timeline_start;
    private String timeline_end;
    private String timeline_barre;
    private boolean can_note;
    private boolean company_can_note;
    private String status;
    private boolean mandatory;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

    public boolean isCan_note() {
        return can_note;
    }

    public void setCan_note(boolean can_note) {
        this.can_note = can_note;
    }

    public boolean isCompany_can_note() {
        return company_can_note;
    }

    public void setCompany_can_note(boolean company_can_note) {
        this.company_can_note = company_can_note;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isMandatory() {
        return mandatory;
    }

    public void setMandatory(boolean mandatory) {
        this.mandatory = mandatory;
    }

    @Override
    public void setView(View view, final Context context) {
        final RelativeLayout rl = (RelativeLayout) view.findViewById(R.id.section_item_id);
        TextView module_name = (TextView) rl.findViewById(R.id.item_name_id);
        TextView startline = (TextView) rl.findViewById(R.id.startline);
        TextView deadline = (TextView) rl.findViewById(R.id.deadline);
        TextView info = (TextView) rl.findViewById(R.id.section_info);
        final View timeline_passed = rl.findViewById(R.id.timeline_passed);

        info.setText(context.getString(R.string.status) + status);
        info.setVisibility(View.VISIBLE);
        module_name.setText(company);
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
