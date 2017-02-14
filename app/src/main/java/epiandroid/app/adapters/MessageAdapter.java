package epiandroid.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import epiandroid.app.R;
import epiandroid.app.helpers.Helper;
import epiandroid.app.models.infos.History;
import epiandroid.app.network.NetworkManager;

public class MessageAdapter extends BaseAdapter {
    private Context context;
    private History[] histories;
    private static LayoutInflater inflater = null;
    private NetworkManager nm = NetworkManager.instance;

    public MessageAdapter(Context context, History[] histories) {
        this.context = context;
        this.histories = histories;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        if (histories == null)
            return 0;
        return histories.length;
    }

    @Override
    public Object getItem(int i) {
        if (histories == null)
            return null;
        return histories[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View contentView = view;

        if (contentView == null) {
            contentView = inflater.inflate(R.layout.message_item, null);
            LinearLayout message_item = (LinearLayout) contentView.findViewById(R.id.message_item);
            if (histories[i].getUser().getPicture() != null) {
                ImageView imgv = (ImageView) message_item.findViewById(R.id.message_item_picture);
                new Helper.DownloadImage(imgv).execute(histories[i].getUser().getPicture());
            }
            LinearLayout mitl = (LinearLayout) contentView.findViewById(R.id.message_item_text_layout);
            TextView message_item_text_title = (TextView) mitl.findViewById(R.id.message_item_text_title);
            TextView message_item_text_desc = (TextView) mitl.findViewById(R.id.message_item_text_desc);
            TextView message_item_text_date = (TextView) mitl.findViewById(R.id.message_item_text_date);
            message_item_text_title.setText(histories[i].getTitle());
            message_item_text_desc.setText(histories[i].getContent());
            message_item_text_date.setText(histories[i].getDate());
        }
        return contentView;
    }
}
