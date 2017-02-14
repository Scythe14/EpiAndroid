package epiandroid.app.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import epiandroid.app.R;
import epiandroid.app.adapters.SectionItemAdapter;
import epiandroid.app.helpers.Helper;
import epiandroid.app.models.allmodules.AllModules;
import epiandroid.app.models.infos.UserInfo;
import epiandroid.app.models.projects.Projects;
import epiandroid.app.network.NetworkManager;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import java.util.List;

public class ModuleFragment extends Fragment {
    private NetworkManager nm = NetworkManager.instance;
    private ListView[] section_list = new ListView[2];
    static private UserInfo user_info =  null;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.homefragment, container, false);
        if (user_info == null)
            user_info = (UserInfo)getArguments().getSerializable(getString(R.string.serial_info));
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getAllModules();
    }

    private void retrieveModules(AllModules modules) {
        RelativeLayout v = (RelativeLayout)getActivity().findViewById(R.id.home_id);

        section_list[0] = (ListView) v.findViewById(R.id.module_list_id);
        setHeader(section_list[0], R.drawable.module_icon,
                Helper.config_file.getSection().getModules(), modules.getItems());
        getAllProjects();
    }

    private void retrieveProjects(List<Projects> projects) {
        RelativeLayout v = (RelativeLayout) getActivity().findViewById(R.id.home_id);

        section_list[1] = (ListView) v.findViewById(R.id.projects_list_id);
        setHeader(section_list[1], R.drawable.internship_icon,
                Helper.config_file.getSection().getProjects(), projects);
        for (ListView vi : section_list) {
            vi.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return false;
                }
            });
        }

        section_list[1].setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });
    }

    private void getAllProjects() {
        Call<List<Projects>> log_request = nm.getNetworkService().getProjects(nm.getToken());
        log_request.enqueue(new Callback<List<Projects>>() {

            @Override
            public void onResponse(Response<List<Projects>> response, Retrofit retrofit) {
                if (response.code() == 200) {
                    try { retrieveProjects(response.body()); }
                    catch (Throwable t) {}
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

    private void getAllModules() {
        Call<AllModules> log_request = nm.getNetworkService().getAllModules(nm.getToken(),
                Integer.parseInt(user_info.getInfos().getScolaryear()), user_info.getInfos().getLocation(),
                user_info.getInfos().getCourse_code());
        log_request.enqueue(new Callback<AllModules>() {

            @Override
            public void onResponse(Response<AllModules> response, Retrofit retrofit) {
                if (response.code() == 200) {
                    try { retrieveModules(response.body()); }
                    catch (Throwable t) {}
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

    private void setHeader(ListView listview, int icon, final String section_name, Object obj) {
        listview.setAdapter(new SectionItemAdapter(getActivity(), (List<Object>)obj));
        View view = getActivity().getLayoutInflater().inflate(R.layout.section, null);
        ImageView section_image = (ImageView) view.findViewById(R.id.section_image);
        section_image.setImageResource(icon);
        TextView section_title = (TextView)view.findViewById(R.id.section_title);
        Helper.setListViewHeightBasedOnChildren(listview, getResources().getDimensionPixelSize(R.dimen.header_size));
        section_title.setText(section_name);
        listview.addHeaderView(view);
    }

}
