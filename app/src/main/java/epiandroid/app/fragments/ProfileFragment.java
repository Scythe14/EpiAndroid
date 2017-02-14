package epiandroid.app.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import epiandroid.app.R;
import epiandroid.app.activities.MessageActivity;
import epiandroid.app.activities.TrombiActivity;
import epiandroid.app.adapters.GradeAdapter;
import epiandroid.app.helpers.Helper;
import epiandroid.app.models.infos.board.Activity;
import epiandroid.app.models.mark.Mark;
import epiandroid.app.models.modules.Modules;
import epiandroid.app.models.photo.Photo;
import epiandroid.app.models.user.User;
import epiandroid.app.network.NetworkManager;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import java.util.ArrayList;
import java.util.List;

public class ProfileFragment extends Fragment implements View.OnClickListener {
    public static String default_user;
    private NetworkManager nm = NetworkManager.instance;
    private int scolar_year;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.profilefragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        retrieveUserInfo(default_user);
        retrieveUserModule();
        retrievePictureFromUrl(default_user);
    }

    private void retrieveUserModule() {
        Call<Modules> log_request = nm.getNetworkService().getModules(nm.getToken());
        log_request.enqueue(new Callback<Modules>() {

            @Override
            public void onResponse(Response<Modules> response, Retrofit retrofit) {
                if (response.code() == 200) {
                    try  { retrieveUserMark(response.body().getModules()); }
                    catch (Throwable t) { }
                }
            }

            @Override
            public void onFailure(Throwable t) { }
        });
    }

    private void fillGradeList(List<Mark.Note> all_notes, Modules.UserModule[] modules) {
        RelativeLayout profile_layout = (RelativeLayout) getActivity().findViewById(R.id.profile_layout);
        ExpandableListView elv = (ExpandableListView) profile_layout.findViewById(R.id.profile_mark_list);
        ExpandableListAdapter exlad;

        int i = 0;
        List<List<Mark.Note>> notes = new ArrayList<List<Mark.Note>>();
        for (Modules.UserModule g : modules) {
            for (Mark.Note n : all_notes) {
                if (i == notes.size())
                    notes.add(i, new ArrayList<Mark.Note>());
                if (n.getCodemodule().equals(g.getCodemodule())) {
                    notes.get(i).add(n);
                }
            }
            ++i;
        }
        exlad = new GradeAdapter(getActivity(), modules, notes);
        elv.setAdapter(exlad);
    }

    private void retrieveUserMark(final Modules.UserModule[] modules) {
        Call<Mark> log_request = nm.getNetworkService().getMarks(nm.getToken());
        log_request.enqueue(new Callback<Mark>() {

            @Override
            public void onResponse(Response<Mark> response, Retrofit retrofit) {
                if (response.code() == 200) {
                    try { fillGradeList(response.body().getNotes(), modules); }
                    catch (Throwable t) { }
                } else {
                    try  { fillGradeList(response.body().getNotes(), modules); }
                    catch (Throwable t) { }
                }
            }

            @Override
            public void onFailure(Throwable t) { }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        RelativeLayout profile_layout = (RelativeLayout) getActivity().findViewById(R.id.profile_layout);
        ExpandableListView elv = (ExpandableListView) profile_layout.findViewById(R.id.profile_mark_list);

        if (resultCode == getActivity().RESULT_OK) {
            String login = data.getStringExtra(getString(R.string.serial_info));
            if (login.equals(default_user)) {
                elv.setVisibility(View.VISIBLE);
                retrieveUserInfo(default_user);
                retrieveUserModule();
                retrievePictureFromUrl(default_user);
            }
            else {
                elv.setVisibility(View.GONE);
                retrieveUserInfo(login);
                retrievePictureFromUrl(login);
            }
        }
    }

    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.profile_messages: {
                Intent intent = new Intent();
                intent.setClass(getActivity(), MessageActivity.class);
                startActivity(intent);
                break;
            }
            case R.id.trombi: {
                Bundle b = new Bundle();
                b.putInt(getString(R.string.serial_info), scolar_year);
                Intent intent = new Intent();
                intent.putExtras(b);
                intent.setClass(getActivity(), TrombiActivity.class);
                startActivityForResult(intent, 1);
                break;
            }
            case R.id.profile_telephone: {
                String s = getString(R.string.telephone);
                TextView text = (TextView) v;
                int len = text.getText().length();
                String call = getString(R.string.call);

                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse(call + text.getText()
                        .toString().substring(s.length(), len)));
                startActivity(intent);
                break ;
            }
            case R.id.profile_facebook: {
                String s = getString(R.string.facebook);
                TextView text = (TextView) v;
                int len = text.getText().length();

                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(text.getText()
                        .toString().substring(s.length(), len)));
                startActivity(intent);
                break ;
            }
            case R.id.profile_email: {
                String s = getString(R.string.email);
                TextView text = (TextView) v;
                int len = text.getText().length();

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setType(getString(R.string.plain_text));
                intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{text.getText()
                        .toString().substring(s.length(), len)});
                intent.setClassName(getString(R.string.android_gmail),
                        getString(R.string.android_gmail_composed));
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.mail_subject));
                intent.putExtra(Intent.EXTRA_TEXT, getString(R.string.mail_text));
                startActivity(Intent.createChooser(intent, null));
                break ;
            }
        }
    }

    private void fillProfile(User infos) {
        RelativeLayout profile_layout = (RelativeLayout) getActivity().findViewById(R.id.profile_layout);
        RelativeLayout profile_view = (RelativeLayout) profile_layout.findViewById(R.id.profile_view);
        TextView login = (TextView) profile_view.findViewById(R.id.profile_login);
        TextView id = (TextView) profile_view.findViewById(R.id.profile_id);
        TextView city = (TextView) profile_view.findViewById(R.id.profile_city);
        TextView groups = (TextView) profile_view.findViewById(R.id.profile_groups);
        TextView telephone = (TextView) profile_view.findViewById(R.id.profile_telephone);
        TextView birthday = (TextView) profile_view.findViewById(R.id.profile_birthday);
        TextView email = (TextView) profile_view.findViewById(R.id.profile_email);
        TextView facebook = (TextView) profile_view.findViewById(R.id.profile_facebook);
        TextView profile_active = (TextView) profile_view.findViewById(R.id.profile_active);
        TextView profile_idle = (TextView) profile_view.findViewById(R.id.profile_idle);
        TextView profile_out_active = (TextView) profile_view.findViewById(R.id.profile_out_active);
        TextView profile_out_idle = (TextView) profile_view.findViewById(R.id.profile_out_idle);
        TextView profile_messages = (TextView)  profile_view.findViewById(R.id.profile_messages);
        TextView trombi = (TextView)  profile_view.findViewById(R.id.trombi);
        TextView profile_gpa = (TextView) profile_view.findViewById(R.id.profile_gpa);
        TextView profile_credits = (TextView) profile_view.findViewById(R.id.profile_credits);
        TextView profile_spices = (TextView)  profile_view.findViewById(R.id.profile_spices);

        scolar_year = Integer.parseInt(infos.getScolaryear());
        if (default_user.equals(infos.getLogin())) {
            profile_messages.setVisibility(View.VISIBLE);
            trombi.setVisibility(View.VISIBLE);
            profile_messages.setOnClickListener(this);
            trombi.setOnClickListener(this);
        }
        facebook.setOnClickListener(this);
        email.setOnClickListener(this);
        telephone.setOnClickListener(this);
        String s_group = "";
        login.setText(getString(R.string.login) + infos.getLogin());
        id.setText(getString(R.string.uid_gid) + Integer.toString(infos.getUid()) +
                getString(R.string.slash) +
                Integer.toString(infos.getGid()));
        city.setText(getString(R.string.city) + infos.getLocation());
        for (User.Group p: infos.getGroups())
            s_group += p.getTitle() + getString(R.string.space);
        groups.setText(getString(R.string.member) + s_group);
        profile_active.setText(getString(R.string.active) + String.valueOf(infos.getNsstat().getActive()));
        profile_idle.setText(getString(R.string.idle) + String.valueOf(infos.getNsstat().getIdle()));
        profile_out_active.setText(getString(R.string.out_active) + String.valueOf(infos.getNsstat().getOut_active()));
        profile_out_idle.setText(getString(R.string.out_idle) + String.valueOf(infos.getNsstat().getOut_idle()));

        profile_gpa.setText(getString(R.string.gpa) + infos.getGpa()[0].getGpa());
        profile_credits.setText(getString(R.string.credits) + String.valueOf(infos.getCredits()));
        if (infos.getSpice() != null && infos.getSpice().getAvailable_spice() != null) {
            profile_spices.setText(getString(R.string.spices) +
                    String.valueOf(infos.getSpice().getAvailable_spice()));
            profile_spices.setVisibility(View.VISIBLE);
        }
        else
            profile_spices.setVisibility(View.GONE);
        telephone.setVisibility(View.GONE);
        email.setVisibility(View.GONE);
        facebook.setVisibility(View.GONE);
        birthday.setVisibility(View.GONE);
        if (infos.getUserinfo().getTelephone() != null && infos.getUserinfo().getTelephone().getValue() != null) {
            telephone.setText(getString(R.string.telephone) + infos.getUserinfo().getTelephone().getValue());
            telephone.setVisibility(View.VISIBLE);
        }
        if (infos.getUserinfo().getBirthday() != null && infos.getUserinfo().getBirthday().getValue() != null) {
            birthday.setText(getString(R.string.birthday) + infos.getUserinfo().getBirthday().getValue());
            birthday.setVisibility(View.VISIBLE);
        }
        if (infos.getUserinfo().getEmail() != null && infos.getUserinfo().getEmail().getValue() != null) {
            email.setText(getString(R.string.email) + infos.getUserinfo().getEmail().getValue());
            email.setVisibility(View.VISIBLE);
        }
        if (infos.getUserinfo().getFacebook() != null && infos.getUserinfo().getFacebook().getValue() != null) {
            facebook.setText(getString(R.string.facebook) + infos.getUserinfo().getFacebook().getValue());
            facebook.setVisibility(View.VISIBLE);
        }
    }

    private void retrieveUserInfo(final String login) {
        Call<User> log_request = nm.getNetworkService().getInfo(nm.getToken(), login);
        log_request.enqueue(new Callback<User>() {

            @Override
            public void onResponse(Response<User> response, Retrofit retrofit) {
                if (response.code() == 200) {
                    try { fillProfile(response.body()); }
                    catch (Throwable t) { t.printStackTrace(); }
                }
                else {
                    if (!login.equals(default_user)) {
                        retrieveUserInfo(default_user);
                    }
                }
            }

            @Override
            public void onFailure(Throwable t) { }
        });
    }

    private void retrievePictureFromUrl(String login) {
        Call<Photo> log_request = nm.getNetworkService().getPhoto(nm.getToken(), login);
        log_request.enqueue(new Callback<Photo>() {

            @Override
            public void onResponse(Response<Photo> response, Retrofit retrofit) {
                if (response.code() == 200)
                    try { getProfilePicture(response.body().getUrl()); }
                    catch (Throwable t) { }
            }

            @Override
            public void onFailure(Throwable t) { }
        });
    }

    private void getProfilePicture(String url) {
        RelativeLayout profile_layout = (RelativeLayout)getActivity().findViewById(R.id.profile_layout);
        RelativeLayout profile_view;
        if (profile_layout != null) {
            profile_view = (RelativeLayout) profile_layout.findViewById(R.id.profile_view);
            ImageView imgv = (ImageView) profile_view.findViewById(R.id.profile_image);
            new Helper.DownloadImage(imgv).execute(url);
        }
    }
}
