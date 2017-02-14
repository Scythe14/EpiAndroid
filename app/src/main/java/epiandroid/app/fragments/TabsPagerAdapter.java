package epiandroid.app.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import epiandroid.app.R;
import epiandroid.app.models.infos.UserInfo;

public class TabsPagerAdapter extends FragmentStatePagerAdapter {
    int                 fragments_nb;
    private UserInfo    info;
    Context context;

    public TabsPagerAdapter(FragmentManager fm, int nbTabs, UserInfo info, Context context) {
        super(fm);
        fragments_nb = nbTabs;
        this.info = info;
        this.context = context;
    }

    @Override
    public Fragment getItem(int index) {
        switch (index) {
            case 0:
                if (ProfileFragment.default_user == null)
                    ProfileFragment.default_user = info.getInfos().getLogin();
                return new ProfileFragment();
            case 1:
                return new PlanningFragment();
            case 2:
                return new HomeFragment();
            case 3:
                return new AdministrationFragment();
            case 4:
                Fragment fragment;
                Bundle args = new Bundle();
                args.putSerializable(context.getString(R.string.serial_info), info); //TODO, no magic string
                fragment = new ModuleFragment();
                fragment.setArguments(args);
                return fragment;
        }
        return new ProfileFragment();
    }

    @Override
    public int getCount() {
        return fragments_nb;
    }
}
