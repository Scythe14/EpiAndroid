package epiandroid.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import epiandroid.app.R;
import epiandroid.app.models.infos.board.HomeInfo;

import java.util.List;

public class SectionItemAdapter extends BaseAdapter implements View.OnClickListener {
    protected Object[] section_data;
    protected Context context;
    protected LayoutInflater inflater = null;

    public SectionItemAdapter(Context context, List<Object> obj) {
        int i = 0;
        this.section_data = new Object[obj.size()];
        for (Object o: obj) {
            this.section_data[i] = o;
            ++i;
        }
        this.context = context;
        this.inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return section_data.length;
    }

    @Override
    public Object getItem(int position) {
        return section_data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null)
            view = inflater.inflate(R.layout.section_item, parent, false);
        RelativeLayout rl = (RelativeLayout) view.findViewById(R.id.section_item_id);
        TextView register = (TextView) rl.findViewById(R.id.registration);
        TextView id = (TextView) rl.findViewById(R.id.section_item_stock_id);
        id.setText(Integer.toString(position));
        ((HomeInfo)section_data[position]).setView(view, context);
        register.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        RelativeLayout rl = (RelativeLayout) view.getParent();
        TextView id = (TextView) rl.findViewById(R.id.section_item_stock_id);
        ((HomeInfo)section_data[Integer.parseInt(id.getText().toString())]).register(rl, context);
    }
}
