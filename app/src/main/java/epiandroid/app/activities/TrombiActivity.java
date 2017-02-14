package epiandroid.app.activities;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.KeyEvent;
import android.view.View;
import android.widget.*;
import epiandroid.app.R;
import epiandroid.app.adapters.GradeAdapter;
import epiandroid.app.adapters.TrombiAdapter;
import epiandroid.app.models.error.APIError;
import epiandroid.app.models.user.Trombi;
import epiandroid.app.network.NetworkManager;
import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class TrombiActivity extends Activity {
    private Spinner course;
    private Spinner promo;
    private Spinner location;
    private GridView grid;
    private TextView login;
    private boolean isLoading = false;
    private int itemCount = 0;
    private int bufferItemCount = 20;
    private int year;
    private int offset = 0;
    private NetworkManager nm = NetworkManager.instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.trombi);
        course = (Spinner) findViewById(R.id.course);
        promo = (Spinner) findViewById(R.id.promo);
        location = (Spinner) findViewById(R.id.location);
        grid = (GridView) findViewById(R.id.user_grid);
        year = getIntent().getExtras().getInt(getString(R.string.serial_info));
        login = (TextView) findViewById(R.id.trombi_login);
        Button b = (Button) findViewById(R.id.trombi_ok);
        reloadContent();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!login.getText().toString().isEmpty()) {
                    Intent intent = new Intent();
                    intent.putExtra(getString(R.string.serial_info), login.getText().toString());
                    setResult(RESULT_OK, intent);
                    finish();
                }
                else {
                    retrieveUser();
                }
            }
        });
        whenItemClicked();
    }

    private void whenItemClicked() {
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView login = (TextView) view.findViewById(R.id.trombi_item_login);
                Intent intent = new Intent();
                intent.putExtra(getString(R.string.serial_info), login.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void createGrid(Trombi.Item[] items) {
        BaseAdapter b = new TrombiAdapter(items, this);
        grid.setAdapter(b);
    }

    private void reloadContent() {
        grid.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {}

            @Override
            public void onScroll(AbsListView absListView, int firstVisibleItem,
                                 int visibleItemCount, int totalItemCount) {
                if (grid.getAdapter() == null || grid.getAdapter().getCount() == 0)
                    return ;
                if (firstVisibleItem > itemCount) {
                    itemCount = totalItemCount;
                    if (totalItemCount == 0) {
                        isLoading = true; }
                }

                if (isLoading && (totalItemCount > itemCount)) {
                    isLoading = false;
                    itemCount = totalItemCount;
                }

                if (!isLoading && (totalItemCount - visibleItemCount)<=(firstVisibleItem + bufferItemCount)) {
                    moreUser();
                }

            }
        });
    }

    private void moreUser() {
        Call<Trombi> log_request = nm.getNetworkService()
                .getStudents(nm.getToken(), year,
                        (String) location.getSelectedItem(),
                        (String) course.getSelectedItem(),
                        (String) promo.getSelectedItem(), offset);
        log_request.enqueue(new Callback<Trombi>() {

            @Override
            public void onResponse(Response<Trombi> response, Retrofit retrofit) {
                if (response.code() == 200) {
                    ((TrombiAdapter) grid.getAdapter()).addItems(response.body().getItems());
                    offset += grid.getAdapter().getCount();
                }
            }

            @Override
            public void onFailure(Throwable t) {t.printStackTrace();}
        });
    }

    private void retrieveUser() {
        offset = 0;
        Call<Trombi> log_request = nm.getNetworkService()
                .getStudents(nm.getToken(), year,
                        (String) location.getSelectedItem(),
                        (String) course.getSelectedItem(),
                        (String) promo.getSelectedItem(), offset);
        log_request.enqueue(new Callback<Trombi>() {

            @Override
            public void onResponse(Response<Trombi> response, Retrofit retrofit) {
                if (response.code() == 200) {
                    createGrid(response.body().getItems());
                    offset += grid.getAdapter().getCount();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                t.printStackTrace();
            }
        });
    }
}

