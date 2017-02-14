package epiandroid.app.adapters;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import epiandroid.app.R;
import epiandroid.app.models.planning.Planning;

public class PlanningAdapter extends BaseAdapter {
    private Planning[] plannings;
    private Context context;
    private static LayoutInflater inflater;

    public PlanningAdapter(Context context, Planning[] plannings) {
        this.context = context;
        this.plannings = plannings;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        if (plannings == null)
            return 0;
        return plannings.length;
    }

    @Override
    public Object getItem(int i) {
        if (plannings == null)
            return null;
        return plannings[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View contentView = view;

        if (contentView == null)
            contentView = inflater.inflate(R.layout.planning_item, null);
        LinearLayout planning_item_date
                = (LinearLayout)contentView.findViewById(R.id.planning_item_date);
        TextView item_date_start
                = (TextView)planning_item_date.findViewById(R.id.planning_item_date_start);
        TextView item_date_end
                = (TextView)planning_item_date.findViewById(R.id.planning_item_date_end);
        item_date_start.setText(plannings[i].getStart().split(" ")[1]);
        item_date_end.setText(context.getString(R.string.seperate_date) +
                plannings[i].getEnd().split(" ")[1]);
        LinearLayout planning_item_body = (LinearLayout) contentView.findViewById(R.id.planning_item_body);
        TextView item_body_title
                = (TextView) planning_item_body.findViewById(R.id.planning_item_body_title);
        TextView item_body_desc
                = (TextView) planning_item_body.findViewById(R.id.planning_item_body_desc);
        TextView item_body_slot
                = (TextView) planning_item_body.findViewById(R.id.planning_item_body_slot);
        TextView is_registered
                = (TextView) planning_item_body.findViewById(R.id.planning_item_is_registered);
        TextView on_module
                = (TextView) planning_item_body.findViewById(R.id.planning_item_module_registered);

        item_body_title.setText(context.getString(R.string.title) + plannings[i].getActi_title());
        item_body_desc.setText(context.getString(R.string.module) + plannings[i].getTitlemodule());
        item_body_slot.setText(context.getString(R.string.type_title) + plannings[i].getType_title());
        if (!plannings[i].getEvent_registered().equals(context.getString(R.string.registered))) {
            is_registered.setText(context.getString(R.string.register));
            is_registered.setTextColor(context.getResources().getColor(R.color.green));
        }
        else {
            is_registered.setText(context.getString(R.string.unregister));
            is_registered.setTextColor(context.getResources().getColor(R.color.red));
        }
        if (!plannings[i].getModule_registered()) {
            on_module.setText(context.getString(R.string.not_registered_module));
            is_registered.setVisibility(View.GONE);
        }
        else {
            on_module.setText(context.getString(R.string.registered_module));
            is_registered.setVisibility(View.VISIBLE);
        }
        return contentView;
    }
}
