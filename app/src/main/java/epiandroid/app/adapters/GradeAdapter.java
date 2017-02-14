package epiandroid.app.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import epiandroid.app.R;
import epiandroid.app.models.mark.Mark;
import epiandroid.app.models.modules.Modules;

import java.util.List;

public class GradeAdapter extends BaseExpandableListAdapter {
    private Modules.UserModule[] data_header;
    private List<List<Mark.Note>> data_child;
    private Context context;

    public GradeAdapter(Context context, Modules.UserModule[] data_header,
                        List<List<Mark.Note>> data_child) {
        this.context = context;
        this.data_child = data_child;
        this.data_header = data_header;
    }

    @Override
    public int getGroupCount() {
        return data_header.length;
    }

    @Override
    public int getChildrenCount(int i) {
        if (data_child == null)
            return 0;
        return data_child.get(i).size();
    }

    @Override
    public Object getGroup(int i) {
        return data_header[i];
    }

    @Override
    public Object getChild(int i, int i1) {
        if (data_child == null)
            return null;
        return data_child.get(i).get(i1);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        View convertView = view;
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.profile_grade, null);
        }
        RelativeLayout grade_view = (RelativeLayout) convertView.findViewById(R.id.grade_view);
        TextView attributed_grade = (TextView) grade_view.findViewById(R.id.attributed_grade);
        TextView grade_module_name = (TextView) grade_view.findViewById(R.id.grade_module_name);
        TextView grade_credits = (TextView) grade_view.findViewById(R.id.grade_credits);
        TextView grade_cycle = (TextView) grade_view.findViewById(R.id.grade_cycle);
        TextView grade_semester = (TextView) grade_view.findViewById(R.id.grade_semester);

        if (context.getString(R.string.acquis).equals(data_header[i].getGrade())) {
            attributed_grade.setText(context.getString(R.string._acquis));
        }
        else if (context.getString(R.string.echec).equals(data_header[i].getGrade()))
            attributed_grade.setText(context.getString(R.string._echec));
        else
            attributed_grade.setText(data_header[i].getGrade());
        grade_module_name.setText(context.getString(R.string.module) + data_header[i].getTitle());
        grade_credits.setText(context.getString(R.string.credits) + String.valueOf(data_header[i].getCredits()));
        grade_cycle.setText(context.getString(R.string.cycle) + data_header[i].getCycle());
        grade_semester.setText(context.getString(R.string.semester) + String.valueOf(data_header[i].getSemester()));
        return convertView;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        View convertView = view;
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.profile_grade_item, null);
        }
        TextView grade_item_title = (TextView) convertView.findViewById(R.id.grade_item_title);
        TextView grade_item_corrector = (TextView) convertView.findViewById(R.id.grade_item_corrector);
        TextView grade_item_date = (TextView) convertView.findViewById(R.id.grade_item_date);
        TextView grade_item_comment = (TextView) convertView.findViewById(R.id.grade_item_comment);
        TextView grade_item_note = (TextView) convertView.findViewById(R.id.grade_item_note);

        grade_item_title.setText(context.getString(R.string.title) +
                data_child.get(i).get(i1).getTitle());
        grade_item_corrector.setText(context.getString(R.string.corrector) +
                data_child.get(i).get(i1).getCorrecteur());
        grade_item_date.setText(context.getString(R.string.date) +
                data_child.get(i).get(i1).getDate());
        grade_item_comment.setText(context.getString(R.string.comment) +
                data_child.get(i).get(i1).getComment());
        grade_item_note.setText(context.getString(R.string.note) +
                data_child.get(i).get(i1).getFinal_note());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
