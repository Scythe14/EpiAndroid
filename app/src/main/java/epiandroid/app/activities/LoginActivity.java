package epiandroid.app.activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.*;
import epiandroid.app.R;
import epiandroid.app.fragments.ProfileFragment;
import epiandroid.app.helpers.Helper;
import epiandroid.app.models.login.Token;
import epiandroid.app.network.NetworkManager;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import java.io.IOException;

public class LoginActivity extends AppCompatActivity {
    static private String               PREFERENCE;
    private SharedPreferences           sp;
    private SharedPreferences.Editor    editor;

    public LoginActivity() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        PREFERENCE = getString(R.string.login_activity_pref);
        try { Helper.initConfigFile(getAssets().open(getString(R.string.config_json))); }
        catch (IOException e) { e.printStackTrace(); }
        getSupportActionBar().hide();
        setContentView(R.layout.login);
        setButtonBehavior();
    }

    private void login(final CheckBox cb, final ProgressBar pb,
                       final String login, final String password) {
        final NetworkManager nm = NetworkManager.instance;
        final Intent intent = new Intent(this, HomeActivity.class);
        Call<Token> log_request = nm.getNetworkService().login(login, password);
        log_request.enqueue(new Callback<Token>(){

            @Override
            public void onResponse(Response<Token> response, Retrofit retrofit) {
                if (response.code() == 200) {
                    if (cb.isChecked()) {
                        editor.putString(getString(R.string.token_pref), response.body().getToken());
                        editor.apply();
                    }
                    nm.setToken(response.body());
                    pb.setVisibility(View.INVISIBLE);
                    ProfileFragment.default_user = null;
                    startActivity(intent);
                }
                else { pb.setVisibility(View.INVISIBLE); }
            }

            @Override
            public void onFailure(Throwable t) {pb.setVisibility(View.INVISIBLE);}

        });
    }

    private void stockOnPreference(String login, String password, CheckBox cb) {
        if (cb.isChecked()) {
            editor.putString(getString(R.string.login_pref), login);
            editor.putString(getString(R.string.password_pref), password);
            editor.putBoolean(getString(R.string.login_check_pref), true);
            editor.apply();
            return ;
        }
        editor.remove(getString(R.string.login_pref));
        editor.remove(getString(R.string.password_pref));
        editor.remove(getString(R.string.login_check_pref));
        editor.apply();
    }

    private void connexion(final CheckBox cb, final ProgressBar pb,
                           final String login, final String password) {
        if (!pb.isShown()) {
            stockOnPreference(login, password, cb);
            pb.setVisibility(View.VISIBLE);
            login(cb, pb, login, password);
        }
    }

    private void setButtonBehavior() {
        sp = getSharedPreferences(PREFERENCE, Context.MODE_APPEND);
        editor = sp.edit();
        final Button button = (Button) findViewById(R.id.sign_in_button);
        final EditText login = (EditText) findViewById(R.id.login_textfield);
        final EditText password = (EditText) findViewById(R.id.password_textfield);
        final ProgressBar pb = (ProgressBar) findViewById(R.id.progress_bar);
        final CheckBox cb = (CheckBox) findViewById(R.id.check_box);
        login.setText(sp.getString(getString(R.string.login_pref), ""));
        password.setText(sp.getString(getString(R.string.password_pref), ""));
        cb.setChecked(sp.getBoolean(getString(R.string.login_check_pref), false));
        if (cb.isChecked())
            connexion(cb, pb, login.getText().toString(), password.getText().toString()); //d, for the moment
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                connexion(cb, pb, login.getText().toString(),password.getText().toString());
            }
        });
    }
}
