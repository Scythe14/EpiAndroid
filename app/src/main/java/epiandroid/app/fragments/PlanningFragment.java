package epiandroid.app.fragments;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import epiandroid.app.R;
import epiandroid.app.adapters.PlanningAdapter;
import epiandroid.app.models.error.APIError;
import epiandroid.app.models.planning.Planning;
import epiandroid.app.network.NetworkManager;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanningFragment extends Fragment {
    private static String       TAG = "PlanningFragment";
    private NetworkManager      nm = NetworkManager.instance;
    private SimpleDateFormat    sdf;
    private String              date;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.planningfragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        try {
            sdf = new SimpleDateFormat(getString(R.string.planning_time_format));
            sdf.setLenient(false);
            EditText planning_edit = (EditText) getActivity().findViewById(R.id.planning_date_edit);
            date = sdf.format(new Date());
            planning_edit.setText(date);
            retrievePlanning(date);
            planning_edit.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keycode, KeyEvent keyEvent) {
                    TextView textView = (TextView) v;
                    if (keyEvent.getAction() == KeyEvent.ACTION_DOWN &&
                            keycode == KeyEvent.KEYCODE_ENTER) {
                        try {
                            sdf.parse(textView.getText().toString());
                            date = textView.getText().toString();
                            retrievePlanning(date);
                        } catch (ParseException e) {
                            textView.setText(date);
                        }
                        return true;
                    }
                    return (false);
                }
            });
        }
        catch (Throwable t) {t.printStackTrace();}
    }

    private void registration(Planning p, final View view) {
        Call<APIError> log_request = nm.getNetworkService().registerEvent(nm.getToken(),
                Integer.parseInt(p.getScolaryear()), p.getCodemodule(),
                p.getCodeinstance(), p.getCodeacti(), p.getCodeevent());
        log_request.enqueue(new Callback<APIError>() {

            @Override
            public void onResponse(Response<APIError> response, Retrofit retrofit) {
                if (response.code() == 200 && ((response.body() != null) ||
                        (response.body().getError().isEmpty()))) {
                    TextView register = (TextView) view.findViewById(R.id.planning_item_is_registered);
                    register.setText(getString(R.string.unregister));
                    register.setTextColor(Color.parseColor("#ff0000")); //TODO, no magic string
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

    private void unregister(Planning p, final View view) {
        Call<APIError> log_request = nm.getNetworkService().deleteEvent(nm.getToken(),
                Integer.parseInt(p.getScolaryear()), p.getCodemodule(),
                p.getCodeinstance(), p.getCodeacti(), p.getCodeevent());
        log_request.enqueue(new Callback<APIError>() {

            @Override
            public void onResponse(Response<APIError> response, Retrofit retrofit) {
                if (response.code() == 200 && ((response.body() != null) ||
                        (response.body().getError().isEmpty()))) {
                    TextView register = (TextView) view.findViewById(R.id.planning_item_is_registered);
                    register.setText(getString(R.string.register));
                    register.setTextColor(Color.parseColor("#00ff00")); //TODO, no magic string
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

    private void setPlanning(Planning[] planning) {
        ListView listView = (ListView) getActivity().findViewById(R.id.planning_list);
        ListAdapter la = new PlanningAdapter(getActivity(), planning);
        listView.setAdapter(la);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Planning p = (Planning) adapterView.getAdapter().getItem(i);
                TextView register = (TextView) view.findViewById(R.id.planning_item_is_registered);
                if (register.getVisibility() == View.VISIBLE) {
                    if (!p.getEvent_registered().equals(getString(R.string.registered)))
                        registration(p, view);
                    else
                        unregister(p, view);
                }
            }
        });
    }

    private void retrievePlanning(String date) {
        Log.v(TAG, date);
        Call<Planning[]> log_request = nm.getNetworkService().getPlanning(nm.getToken(), date, date);
        log_request.enqueue(new Callback<Planning[]>() {

            @Override
            public void onResponse(Response<Planning[]> response, Retrofit retrofit) {
                if (response.code() == 200) {
                    if (response.body() != null)
                        Log.v(TAG, String.valueOf(response.body().length));
                    try { setPlanning(response.body());}
                    catch (Throwable t) {}
                }
            }

            @Override
            public void onFailure(Throwable t) { t.printStackTrace(); setPlanning(null); }
        });
    }
}
