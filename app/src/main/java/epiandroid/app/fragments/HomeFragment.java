package epiandroid.app.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import epiandroid.app.R;
import epiandroid.app.adapters.SectionItemAdapter;
import epiandroid.app.helpers.Helper;
import epiandroid.app.models.infos.Board;
import epiandroid.app.models.infos.UserInfo;
import epiandroid.app.models.infos.board.Activity;
import epiandroid.app.models.infos.board.Module;
import epiandroid.app.models.login.Token;
import epiandroid.app.network.NetworkManager;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import java.util.List;

public class HomeFragment extends Fragment {
    private NetworkManager nm = NetworkManager.instance;
    private ListView[] section_list = new ListView[5];
    private FragmentManager fm;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.homefragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getUserInfo();
    }

    public void getUserInfo() {
        Call<UserInfo> log_request = nm.getNetworkService().getUserInfos(nm.getToken());
        log_request.enqueue(new Callback<UserInfo>() {

            @Override
            public void onResponse(Response<UserInfo> response, Retrofit retrofit) {
                if (response.code() == 200) {
                    try { setSections(response.body()); }
                    catch (Throwable t) {}
                }
                else {
                }
            }

            @Override
            public void onFailure(Throwable t) {

            }
        });
    }

    public void sendToken(Object obj, String token) {
        Activity activity = (Activity) obj;
        String[] data = activity.getTitle_link().split(getString(R.string.slash));
        Call<Token> log_request = nm.getNetworkService().validateToken(nm.getToken(),
                Integer.parseInt(data[2]), data[3], data[4], data[5], data[6], token);
        log_request.enqueue(new Callback<Token>() {

            @Override
            public void onResponse(Response<Token> response, Retrofit retrofit) {
                if (response.code() == 200) {
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

    private void setSections(UserInfo info) {
        Board board = info.getBoard();
        fm = getActivity().getSupportFragmentManager();
        RelativeLayout v = (RelativeLayout)getActivity().findViewById(R.id.home_id);

        section_list[0] = (ListView)v.findViewById(R.id.module_list_id);
        section_list[1] = (ListView)v.findViewById(R.id.intership_list_id);
        section_list[2] = (ListView)v.findViewById(R.id.activities_list_id);
        section_list[3] = (ListView)v.findViewById(R.id.marks_list_id);
        section_list[4] = (ListView)v.findViewById(R.id.projects_list_id);
        setHeader(section_list[0], R.drawable.module_icon,
                Helper.config_file.getSection().getModules(), board.getModules());
        setHeader(section_list[1], R.drawable.internship_icon,
                Helper.config_file.getSection().getInternship(), board.getStages());
        setHeader(section_list[2], R.drawable.module_icon,
                Helper.config_file.getSection().getActivities(), board.getActivites());
        setHeader(section_list[3], R.drawable.mark_icon,
                Helper.config_file.getSection().getMarks(), board.getNotes());
        setHeader(section_list[4], R.drawable.projets_icon,
                Helper.config_file.getSection().getProjects(), board.getProjets());
        for (ListView vi: section_list) {
            vi.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return false;
                }
            });
        }

        section_list[2].setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Bundle b = new Bundle();
                Module m = (Module) adapterView.getAdapter().getItem(i);
                TokenFragment tok = new TokenFragment();
                b.putSerializable(getString(R.string.activity_instance), m);
                b.putInt(getString(R.string.tab_index), 3);
                tok.setArguments(b);
                tok.show(fm, getString(R.string.dialog_callback));
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
