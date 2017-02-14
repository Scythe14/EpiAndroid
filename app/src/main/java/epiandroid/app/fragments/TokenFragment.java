package epiandroid.app.fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.EditText;
import epiandroid.app.R;
import epiandroid.app.activities.HomeActivity;
import epiandroid.app.models.infos.board.Module;

import java.lang.reflect.InvocationTargetException;

public class TokenFragment extends DialogFragment {
    private Object obj;
    private int index;

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder b = new AlertDialog.Builder(getActivity())
                .setTitle(getActivity().getString(R.string.token_title))
                .setPositiveButton(getActivity().getString(R.string.positive),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Fragment f = ((HomeActivity)getActivity()).getAdapter().getItem(index);
                                EditText et = (EditText) getDialog().findViewById(R.id.token_edit_box);

                                try {
                                    f.getClass().getDeclaredMethod(getTag(), Module.class, String.class)
                                            .invoke(f, obj, et.getText().toString());

                                } catch (IllegalAccessException e) {
                                    e.printStackTrace();
                                } catch (InvocationTargetException e) {
                                    e.printStackTrace();
                                } catch (NoSuchMethodException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                )
                .setNegativeButton(getActivity().getString(R.string.quit),
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.dismiss();
                            }
                        }
                );
        index = getArguments().getInt(getActivity().getString(R.string.tab_index));
        obj = getArguments().getSerializable(getActivity().getString(R.string.activity_instance));
        View view = getActivity().getLayoutInflater().inflate(R.layout.token_dialog, null, false);
        b.setView(view);
        return b.create();
    }
}
