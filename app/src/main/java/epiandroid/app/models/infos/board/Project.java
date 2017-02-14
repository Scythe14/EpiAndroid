package epiandroid.app.models.infos.board;

import android.content.Context;
import android.util.Log;
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

public class Project extends HomeInfo implements Serializable {
    private String title;
    private String title_link;
    private String timeline_start;
    private String timeline_end;
    private String timeline_barre;
    private String date_inscription;
    private String id_activite;
    private String soutenance_name;
    private String soutenance_link;
    private String soutenance_date;
    private String soutenance_salle;

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

    public String getId_activite() {
        return id_activite;
    }

    public void setId_activite(String id_activite) {
        this.id_activite = id_activite;
    }

    public String getSoutenance_name() {
        return soutenance_name;
    }

    public void setSoutenance_name(String soutenance_name) {
        this.soutenance_name = soutenance_name;
    }

    public String getSoutenance_link() {
        return soutenance_link;
    }

    public void setSoutenance_link(String soutenance_link) {
        this.soutenance_link = soutenance_link;
    }

    public String getSoutenance_date() {
        return soutenance_date;
    }

    public void setSoutenance_date(String soutenance_date) {
        this.soutenance_date = soutenance_date;
    }

    public String getSoutenance_salle() {
        return soutenance_salle;
    }

    public void setSoutenance_salle(String soutenance_salle) {
        this.soutenance_salle = soutenance_salle;
    }

    @Override
    public void register(View view, Context context) {
        super.register(view, context);
        TextView register = (TextView) view.findViewById(R.id.registration_date);

        if (register.getVisibility() == View.VISIBLE)
            registerProject(view, title_link.split(context.getString(R.string.slash)), context);
        else
            deleteProject(view, title_link.split(context.getString(R.string.slash)), context);
    }

    public void registerProject(final View view, String[] data, final Context context) {
        Call<APIError> log_request = nm.getNetworkService().registerProject(nm.getToken(),
                Integer.parseInt(data[2]), data[3], data[4], data[5]);
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

    public void deleteProject(final View view, String[] data, final Context context) {
        Call<APIError> log_request = nm.getNetworkService().registerProject(nm.getToken(),
                Integer.parseInt(data[2]), data[3], data[4], data[5]);
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

        register.setVisibility(View.VISIBLE);
        if (!date_inscription.isEmpty() && date_inscription.compareTo("false") != 0) {
            registration_date.setText(context.getString(R.string.registration_until) + date_inscription);
            registration_date.setVisibility(View.VISIBLE);
            register.setText(context.getString(R.string.register));
        }
        else
            register.setText(context.getString(R.string.unregister));
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
