package epiandroid.app.models.infos.board;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import epiandroid.app.R;
import org.w3c.dom.Text;

import java.io.Serializable;

public class Note extends HomeInfo implements Serializable {
    private String  title;
    private String  title_link;
    private String  note;
    private String  noteur;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle_link() {
        return title_link;
    }

    public void setTitle_link(String title_link) {
        this.title_link = title_link;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNoteur() {
        return noteur;
    }

    public void setNoteur(String noteur) {
        this.noteur = noteur;
    }

    @Override
    public void setView(View view, Context context) {
        final RelativeLayout rl = (RelativeLayout) view.findViewById(R.id.section_item_id);
        TextView module_name = (TextView) rl.findViewById(R.id.item_name_id);
        TextView startline = (TextView) rl.findViewById(R.id.startline);
        TextView deadline = (TextView) rl.findViewById(R.id.deadline);
        TextView mark = (TextView) rl.findViewById(R.id.section_item_mark);
        View timeline_passed = rl.findViewById(R.id.timeline_passed);
        View timeline = rl.findViewById(R.id.timeline);

        startline.setVisibility(View.GONE);
        deadline.setVisibility(View.GONE);
        timeline.setVisibility(View.GONE);
        timeline_passed.setVisibility(View.GONE);
        module_name.setText(title);
        mark.setText(context.getString(R.string.note) + note);
        mark.setVisibility(View.VISIBLE);
    }
}
