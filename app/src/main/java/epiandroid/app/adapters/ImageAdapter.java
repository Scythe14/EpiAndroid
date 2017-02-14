package epiandroid.app.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

/**
 * Created by bouca-_d on 21/01/2016.
 */

public class ImageAdapter extends BaseAdapter {
    private Context context;
    private Integer[] pics;

    public ImageAdapter(Context context, Integer[] images) {
        this.context = context;
        this.pics = images;
    }

    @Override
    public int getCount() {
        return pics.length;
    }

    @Override
    public Object getItem(int arg0) {
        return arg0;
    }

    @Override
    public long getItemId(int arg0) {
        return arg0;
    }

    @Override
    public View getView(int arg0, View arg1, ViewGroup arg2) {
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(pics[arg0]);
        return imageView;
    }
}