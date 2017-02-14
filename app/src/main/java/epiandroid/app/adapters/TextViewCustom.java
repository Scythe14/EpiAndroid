package epiandroid.app.adapters;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created by bouca-_d on 28/01/2016.
 */

public class TextViewCustom extends TextView implements View.OnClickListener {

    private String reference;

    public TextViewCustom(Context context) {
        super(context);
        init();
    }

    public TextViewCustom(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
        reference = attrs.getAttributeValue(null, "ref");
    }

    public TextViewCustom(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        reference = attrs.getAttributeValue(Integer.parseInt("ref"));
        init();
    }

    private void init() {
        setOnClickListener(this);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public TextViewCustom(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onClick(View v) {
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(reference));
            v.getContext().startActivity(i);
    }
}
