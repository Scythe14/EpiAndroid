package epiandroid.app.fragments;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

/**
 * Created by bouca-_d on 25/01/2016.
 */


public class TabListener implements TabLayout.OnTabSelectedListener {

    private ViewPager viewPager;

    public TabListener(ViewPager vp) {
        viewPager = vp;
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        viewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
