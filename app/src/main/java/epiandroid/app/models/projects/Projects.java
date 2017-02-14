package epiandroid.app.models.projects;

import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import epiandroid.app.R;
import epiandroid.app.models.error.APIError;
import epiandroid.app.models.infos.board.HomeInfo;
import epiandroid.app.network.NetworkManager;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class Projects extends HomeInfo {
    static private NetworkManager nm = NetworkManager.instance;
    private int registered;
    private String num;
    private String title_module;
    private String num_event;
    private String type_acti;
    private String seats;
    private String acti_title;
    private String info_creneau;
    private String type_acti_code;
    private String end_acti;
    private String codemodule;
    private String project;
    private String begin_acti;
    private String code_location;
    private String end_event;
    private String scolaryear;
    private String codeinstance;
    private String begin_event;
    private String codeacti;

    public int getRegistered() {
        return registered;
    }

    public void setRegistered(int registered) {
        this.registered = registered;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getTitle_module() {
        return title_module;
    }

    public void setTitle_module(String title_module) {
        this.title_module = title_module;
    }

    public String getNum_event() {
        return num_event;
    }

    public void setNum_event(String num_event) {
        this.num_event = num_event;
    }

    public String getType_acti() {
        return type_acti;
    }

    public void setType_acti(String type_acti) {
        this.type_acti = type_acti;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getActi_title() {
        return acti_title;
    }

    public void setActi_title(String acti_title) {
        this.acti_title = acti_title;
    }

    public String getInfo_creneau() {
        return info_creneau;
    }

    public void setInfo_creneau(String info_creneau) {
        this.info_creneau = info_creneau;
    }

    public String getType_acti_code() {
        return type_acti_code;
    }

    public void setType_acti_code(String type_acti_code) {
        this.type_acti_code = type_acti_code;
    }

    public String getEnd_acti() {
        return end_acti;
    }

    public void setEnd_acti(String end_acti) {
        this.end_acti = end_acti;
    }

    public String getCodemodule() {
        return codemodule;
    }

    public void setCodemodule(String codemodule) {
        this.codemodule = codemodule;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getBegin_acti() {
        return begin_acti;
    }

    public void setBegin_acti(String begin_acti) {
        this.begin_acti = begin_acti;
    }

    public String getCode_location() {
        return code_location;
    }

    public void setCode_location(String code_location) {
        this.code_location = code_location;
    }

    public String getEnd_event() {
        return end_event;
    }

    public void setEnd_event(String end_event) {
        this.end_event = end_event;
    }

    public String getScolaryear() {
        return scolaryear;
    }

    public void setScolaryear(String scolaryear) {
        this.scolaryear = scolaryear;
    }

    public String getCodeinstance() {
        return codeinstance;
    }

    public void setCodeinstance(String codeinstance) {
        this.codeinstance = codeinstance;
    }

    public String getBegin_event() {
        return begin_event;
    }

    public void setBegin_event(String begin_event) {
        this.begin_event = begin_event;
    }

    public String getCodeacti() {
        return codeacti;
    }

    public void setCodeacti(String codeacti) {
        this.codeacti = codeacti;
    }

    private void registerProject(final TextView register, final Context context) {
        Call<APIError> log_request = nm.getNetworkService().registerProject(nm.getToken(),
                Integer.parseInt(this.getScolaryear()), this.getCodemodule(),
                this.getCodeinstance(), this.getCodeacti());
        log_request.enqueue(new Callback<APIError>() {

            @Override
            public void onResponse(Response<APIError> response, Retrofit retrofit) {
                if (response.code() == 200 && ((response.body() != null) ||
                        (response.body().getError().isEmpty()))) {
                    register.setText(context.getString(R.string.unregister));
                }
                else {
                }
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void unregisterProject(final TextView register, final Context context) {
        Call<APIError> log_request = nm.getNetworkService().deleteProject(nm.getToken(),
                Integer.parseInt(this.getScolaryear()), this.getCodemodule(),
                this.getCodeinstance(), this.getCodeacti());
        log_request.enqueue(new Callback<APIError>() {

            @Override
            public void onResponse(Response<APIError> response, Retrofit retrofit) {
                if (response.code() == 200 && ((response.body() != null) ||
                        (response.body().getError().isEmpty()))) {
                    register.setText(context.getString(R.string.register));
                }
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
    public void register(View view, Context context) {
        super.register(view, context);
        TextView register = (TextView) view.findViewById(R.id.registration);

        if (register.getVisibility() == View.VISIBLE) {
            if (register.getText().toString().equals(context.getString(R.string.register)))
                registerProject(register, context);
            else
                unregisterProject(register, context);
        }
    }

    @Override
    public void setView(View view, final Context context) {
        final RelativeLayout rl = (RelativeLayout) view.findViewById(R.id.section_item_id);
        TextView module_name = (TextView) rl.findViewById(R.id.item_name_id);
        TextView startline = (TextView) rl.findViewById(R.id.startline);
        TextView deadline = (TextView) rl.findViewById(R.id.deadline);
        TextView register = (TextView) rl.findViewById(R.id.registration);
        final View timeline_passed = rl.findViewById(R.id.timeline_passed);

        register.setVisibility(View.VISIBLE);
        if (registered == 0)
            register.setText(context.getString(R.string.register));
        else
            register.setText(context.getString(R.string.unregister));
        module_name.setText(acti_title);
        deadline.setText(end_acti);
        startline.setText(begin_acti);
        ViewTreeObserver vto = timeline_passed.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                timeline_passed.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                setTimeline(rl, context.getString(R.string.planning_time_format));
            }
        });
    }
}
