package epiandroid.app.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import epiandroid.app.R;
import epiandroid.app.adapters.MessageAdapter;
import epiandroid.app.models.infos.History;
import epiandroid.app.models.planning.Planning;
import epiandroid.app.network.NetworkManager;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

import java.util.List;

public class MessageActivity extends Activity {
    private NetworkManager nm = NetworkManager.instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.message);
        try { retrieveOtherMessage(); }
        catch (Throwable t) {}
    }

    private void fillList(History[] hs) {
        ListView list = (ListView) findViewById(R.id.message_list);
        ListAdapter listad = new MessageAdapter(this, hs);
        list.setAdapter(listad);
    }

    private void retrieveOtherMessage() {
        Call<History[]> log_request = nm.getNetworkService().getMessages(nm.getToken());
        log_request.enqueue(new Callback<History[]>() {

            @Override
            public void onResponse(Response<History[]> response, Retrofit retrofit) {
                fillList(response.body());
            }

            @Override
            public void onFailure(Throwable t) {}
        });
    }
}
