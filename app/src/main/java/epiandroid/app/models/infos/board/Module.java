package epiandroid.app.models.infos.board;


import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import epiandroid.app.R;
import epiandroid.app.models.error.APIError;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import java.io.Serializable;

public class Module extends HomeInfo implements Serializable {
    private String title;
    private String title_link;
    private String timeline_start;
    private String timeline_end;
    private String timeline_barre;
    private String date_inscription;

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

    @Override
    public void register(View view, Context context) {
        super.register(view, context);
        TextView register = (TextView) view.findViewById(R.id.registration_date);

        if (register.getVisibility() == View.VISIBLE)
            registerModule(view, title_link.split(context.getString(R.string.slash)), context);
        else
            deleteModule(view, title_link.split(context.getString(R.string.slash)), context);
    }

    public void registerModule(final View view, String[] data, final Context context) {
        Call<APIError> log_request = nm.getNetworkService().registerModule(nm.getToken(),
                Integer.parseInt(data[2]), data[3], data[4]);
        log_request.enqueue(new Callback<APIError>() {

            @Override
            public void onResponse(Response<APIError> response, Retrofit retrofit) {
                if (response.code() == 200 && ((response.body() != null) ||
                        (response.body().getError().isEmpty())))
                    whenRegistered(view, context);
                else {
                }
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void deleteModule(final View view, String[] data, final Context context) {
        Call<APIError> log_request = nm.getNetworkService().deleteModule(nm.getToken(),
                Integer.parseInt(data[2]), data[3], data[4]);
        log_request.enqueue(new Callback<APIError>() {

            @Override
            public void onResponse(Response<APIError> response, Retrofit retrofit) {
                if (response.code() == 200 && ((response.body() != null) ||
                        (response.body().getError().isEmpty())))
                    whenUnregistered(view, context);
                else {
                }
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void setView(View view, final Context context) {
        final RelativeLayout rl = (RelativeLayout) view.findViewById(R.id.section_item_id);
        TextView module_name = (TextView) rl.findViewById(R.id.item_name_id);
        TextView startline = (TextView) rl.findViewById(R.id.startline);
        TextView deadline = (TextView) rl.findViewById(R.id.deadline);
        TextView registration_date = (TextView) rl.findViewById(R.id.registration_date);
        TextView register = (TextView) rl.findViewById(R.id.registration);
        final View timeline_passed = rl.findViewById(R.id.timeline_passed);

        registration_date.setText(context.getString(R.string.registration_until) + date_inscription);
        registration_date.setVisibility(View.VISIBLE);
        register.setVisibility(View.VISIBLE);
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
