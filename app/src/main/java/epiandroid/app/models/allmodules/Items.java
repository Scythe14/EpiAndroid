package epiandroid.app.models.allmodules;

import android.content.Context;
import android.net.NetworkRequest;
import android.util.Log;
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

public class Items extends HomeInfo {
    static private NetworkManager nm = NetworkManager.instance;
    private int id;
    private String title_cn;
    private int semester;
    private String num;
    private String begin;
    private String end;
    private String end_register;
    private int scolaryear;
    private String code;
    private String codeinstance;
    private String location_title;
    private String instance_location;
    private String flags;
    private String credits;
    private String status;
    private String waiting_grades;
    private String active_promo;
    private String open;
    private String title;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle_cn() {
        return title_cn;
    }

    public void setTitle_cn(String title_cn) {
        this.title_cn = title_cn;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getEnd_register() {
        return end_register;
    }

    public void setEnd_register(String end_register) {
        this.end_register = end_register;
    }

    public int getScolaryear() {
        return scolaryear;
    }

    public void setScolaryear(int scolaryear) {
        this.scolaryear = scolaryear;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCodeinstance() {
        return codeinstance;
    }

    public void setCodeinstance(String codeinstance) {
        this.codeinstance = codeinstance;
    }

    public String getLocation_title() {
        return location_title;
    }

    public void setLocation_title(String location_title) {
        this.location_title = location_title;
    }

    public String getInstance_location() {
        return instance_location;
    }

    public void setInstance_location(String instance_location) {
        this.instance_location = instance_location;
    }

    public String getFlags() {
        return flags;
    }

    public void setFlags(String flags) {
        this.flags = flags;
    }

    public String getCredits() {
        return credits;
    }

    public void setCredits(String credits) {
        this.credits = credits;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getWaiting_grades() {
        return waiting_grades;
    }

    public void setWaiting_grades(String waiting_grades) {
        this.waiting_grades = waiting_grades;
    }

    public String getActive_promo() {
        return active_promo;
    }

    public void setActive_promo(String active_promo) {
        this.active_promo = active_promo;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    private void registerModule(final TextView register, final Context context) {
        Call<APIError> log_request = nm.getNetworkService().registerModule(nm.getToken(),
                this.getScolaryear(), this.getCode(),
                this.getCodeinstance());
        log_request.enqueue(new Callback<APIError>() {

            @Override
            public void onResponse(Response<APIError> response, Retrofit retrofit) {
                Log.v("untagstp", String.valueOf(response.code()) + " registered.");
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

    private void unregisterModule(final TextView register, final Context context) {
        Call<APIError> log_request = nm.getNetworkService().deleteModule(nm.getToken(),
                this.getScolaryear(), this.getCode(),
                this.getCodeinstance());
        log_request.enqueue(new Callback<APIError>() {

            @Override
            public void onResponse(Response<APIError> response, Retrofit retrofit) {
                Log.v("untagstp", String.valueOf(response.code()) + " unregistered.");
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

    public void register(View view, Context context) {
        TextView register = (TextView) view.findViewById(R.id.registration);

        if (register.getVisibility() == View.VISIBLE) {
            if (register.getText().toString().equals(context.getString(R.string.register)))
                registerModule(register, context);
            else
                unregisterModule(register, context);
        }
    }

    @Override
    public void setView(View view, final Context context) {
        final RelativeLayout rl = (RelativeLayout) view.findViewById(R.id.section_item_id);
        TextView module_name = (TextView) rl.findViewById(R.id.item_name_id);
        TextView startline = (TextView) rl.findViewById(R.id.startline);
        TextView deadline = (TextView) rl.findViewById(R.id.deadline);
        TextView register = (TextView) rl.findViewById(R.id.registration);
        View timeline = rl.findViewById(R.id.timeline);
        final View timeline_passed = rl.findViewById(R.id.timeline_passed);

        if (status != null) {
            if (status.equals(context.getString(R.string.notregistered))) {
                register.setVisibility(View.VISIBLE);
                register.setText(context.getString(R.string.register));
            } else if (status.equals(context.getString(R.string.alreadyregistered))) {
                register.setVisibility(View.VISIBLE);
                register.setText(context.getString(R.string.unregister));
            }
        }
        module_name.setText(title);
        if (begin == null) {
            deadline.setVisibility(View.GONE);
            startline.setVisibility(View.GONE);
            timeline.setVisibility(View.GONE);
            timeline_passed.setVisibility(View.GONE);
        }
        else {
            deadline.setText(end);
            startline.setText(begin);
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
}
