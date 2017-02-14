package epiandroid.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import epiandroid.app.R;
import epiandroid.app.helpers.Helper;
import epiandroid.app.models.user.Trombi;

public class TrombiAdapter extends BaseAdapter {
    private Trombi.Item items[];
    private Context context;
    private LayoutInflater inflater;

    public TrombiAdapter(Trombi.Item items[], Context context) {
        this.items = items;
        this.context = context;
        this.inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        if (items == null)
            return 0;
        return items.length;
    }

    @Override
    public Object getItem(int i) {
        if (items == null)
            return null;
        return items[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    public void addItems(Trombi.Item []its) {
        if (its == null)
            return ;
        int aLen = items.length;
        int bLen = its.length;
        Trombi.Item[] new_it = new Trombi.Item[aLen + bLen];
        System.arraycopy(items, 0, new_it, 0, aLen);
        System.arraycopy(its, 0, new_it, aLen, bLen);
        items = new_it;
        notifyDataSetChanged();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View contentView = view;

        if (contentView == null) {
            contentView = inflater.inflate(R.layout.trombi_item, null);
            ImageView img_view = (ImageView) contentView.findViewById(R.id.trombi_image);
            new Helper.DownloadImage(img_view).execute(items[i].getPicture());
        }
        TextView login = (TextView) contentView.findViewById(R.id.trombi_item_login);
        TextView name = (TextView) contentView.findViewById(R.id.trombi_item_name);

        name.setText(items[i].getNom() + " " + items[i].getPrenom());
        login.setText(items[i].getLogin());
        return contentView;
    }
}
