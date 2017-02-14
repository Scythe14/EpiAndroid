package epiandroid.app.activities;

import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.NotificationCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import epiandroid.app.fragments.TabListener;
import epiandroid.app.fragments.TabsPagerAdapter;
import epiandroid.app.R;
import epiandroid.app.models.infos.UserInfo;
import epiandroid.app.models.infos.board.Module;
import epiandroid.app.models.login.Token;
import epiandroid.app.network.NetworkManager;
import epiandroid.app.services.NotificationService;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private TabsPagerAdapter adapter;
    private AlarmManager alarmManager;
    private PendingIntent pendingIntent;
    private NetworkManager nm = NetworkManager.instance;

    public TabsPagerAdapter getAdapter() { return adapter; }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

        viewPager = (ViewPager)findViewById(R.id.pager);
        tabLayout = (TabLayout)findViewById(R.id.tab_layout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        addTabs(tabLayout);
        Intent myIntent = new Intent(this, NotificationService.class);
        pendingIntent = PendingIntent.getService(this,  0, myIntent, 0);

        alarmManager = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.add(Calendar.SECOND, 1);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), 10 * 60 * 1000, pendingIntent);
        getInfo();
    }

    @Override
    protected void onStop() {
        super.onStop();
        alarmManager.cancel(pendingIntent);
    }

    private void addTabs(TabLayout tabLayout) {
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.profile));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.planning));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.logo));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.administration));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.module));
    }

    private void getInfo() {
        final HomeActivity cpy = this;
        Call<UserInfo> log_request = nm.getNetworkService().getUserInfos(nm.getToken());
        log_request.enqueue(new Callback<UserInfo>() {

            @Override
            public void onResponse(Response<UserInfo> response, Retrofit retrofit) {
                if (response.code() == 200) {
                    adapter = new TabsPagerAdapter(getSupportFragmentManager(),
                            tabLayout.getTabCount(),
                            response.body(), cpy);
                }
                else {
                    finish();
                    return ;
                }
                viewPager.setAdapter(adapter);
                viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
                tabLayout.setOnTabSelectedListener(new TabListener(viewPager));
            }

            @Override
            public void onFailure(Throwable t) {
                finish();
            }
        });
    }
}
