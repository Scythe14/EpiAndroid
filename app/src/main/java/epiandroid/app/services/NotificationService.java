package epiandroid.app.services;

import android.app.IntentService;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.widget.EditText;
import epiandroid.app.R;
import epiandroid.app.models.planning.Planning;
import epiandroid.app.network.NetworkManager;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NotificationService extends Service {
    private static NetworkManager nm;

    private void sendNotification(Planning[] plannings) throws ParseException {
        for (Planning p: plannings) {
            if (p.getStart() == null)
                return ;
            String start = p.getStart().split(" ")[1];
            SimpleDateFormat sdf = new SimpleDateFormat(getString(R.string.time_format));
            sdf.setLenient(false);
            String date = sdf.format(new Date());
            Date today = sdf.parse(date);
            Date d = sdf.parse(String.valueOf(start));
            long days = (d.getTime() - today.getTime()) / 1000;
            if (days < 600 && days >= 0)
                createNotification(p);
        }
    }

    private void createNotification(Planning p) {
        String title;

        if (p.getActi_title() == null || p.getActi_title().equals(getString(R.string.null_str)))
            title = p.getTitle();
        else
            title = p.getActi_title();
        NotificationCompat.Builder mBuilder =
                new NotificationCompat.Builder(this)
                        .setSmallIcon(R.drawable.planning)
                        .setContentTitle(getString(R.string.app_name))
                        .setContentText(title + getString(R.string.in) + getString(R.string.tenmin));
        NotificationManager mNotificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        mNotificationManager.notify(0, mBuilder.build());
    }

    private void retrievePlanning(String date) {
        Call<Planning[]> log_request = nm.getNetworkService().getPlanning(nm.getToken(), date, date);
        log_request.enqueue(new Callback<Planning[]>() {

            @Override
            public void onResponse(Response<Planning[]> response, Retrofit retrofit) {
                if (response.code() == 200) {
                    try { sendNotification(response.body());}
                    catch (ParseException t) {}
                }
            }

            @Override
            public void onFailure(Throwable t) { t.printStackTrace(); }
        });
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int ret = super.onStartCommand(intent, flags, startId);
        if (nm == null)
            nm = NetworkManager.instance;
        if (nm.getToken() == null)
            return ret;
        SimpleDateFormat sdf = new SimpleDateFormat(getString(R.string.planning_time_format));
        sdf.setLenient(false);
        String date = sdf.format(new Date());
        retrievePlanning(date);
        return ret;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
