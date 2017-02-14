package epiandroid.app.models.infos.board;

import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import epiandroid.app.R;
import epiandroid.app.helpers.Helper;
import epiandroid.app.network.NetworkManager;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class HomeInfo {
    NetworkManager nm = NetworkManager.instance;

    public abstract void setView(View view, Context context);

    public void register(View view, Context context) {}

    public void whenRegistered(final View view, final Context context) {
        TextView registration_date = (TextView) view.findViewById(R.id.registration_date);
        TextView register = (TextView) view.findViewById(R.id.registration);

        register.setText(context.getString(R.string.unregister));
        registration_date.setVisibility(View.GONE);
    }

    public void whenUnregistered(final View view, final Context context) {
        TextView register = (TextView) view.findViewById(R.id.registration);
        TextView registration_date = (TextView) view.findViewById(R.id.registration_date);

        register.setText(context.getString(R.string.register));
        registration_date.setVisibility(View.VISIBLE);
    }

    protected void setTimeline(RelativeLayout view, String date_format) {
        TextView startline = (TextView) view.findViewById(R.id.startline);
        TextView deadline = (TextView) view.findViewById(R.id.deadline);
        View timeline = view.findViewById(R.id.timeline);
        View timeline_passed = view.findViewById(R.id.timeline_passed);
        int height = timeline_passed.getMeasuredHeight();
        float x = timeline_passed.getX();
        float y = timeline_passed.getY();
        Date start;
        Date end;
        Date today = new Date();
        DateFormat[] format = new DateFormat[2];

        format[0] = new SimpleDateFormat(date_format);
        format[1] = new SimpleDateFormat(date_format);
        try {
            start = format[0].parse(startline.getText().toString());
            end = format[1].parse(deadline.getText().toString());
        } catch (ParseException e) {
            return ;
        }
        long full_time = end.getTime() - start.getTime();
        long current_time = end.getTime() - today.getTime();
        int full_width = timeline.getLayoutParams().width;
        int calc = 0;
        RelativeLayout.LayoutParams rl;
        if (current_time < 0)
            rl = new RelativeLayout.LayoutParams(full_width, height);
        else if (full_time != 0) {
            calc = full_width - (int) (current_time * 100 / full_time) * full_width / 100;
            rl = new RelativeLayout.LayoutParams(calc, height);
        }
        else
            rl = new RelativeLayout.LayoutParams(0, height);
        rl.setMargins((int)x, (int)y, 0, 0);
        timeline_passed.setLayoutParams(rl);
    }
}