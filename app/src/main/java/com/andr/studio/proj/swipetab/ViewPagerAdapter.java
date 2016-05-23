package com.andr.studio.proj.swipetab;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;

import com.andr.studio.proj.swipetab.tabs.Tab1;
import com.andr.studio.proj.swipetab.tabs.Tab2;

/**
 * Created by CIPL310 on 9/15/2015.
 */
public class ViewPagerAdapter extends FragmentPagerAdapter {

    FragmentManager fm;
    CharSequence[] titles;
    int num_tabs;

    public ViewPagerAdapter(FragmentManager fm,CharSequence[]titles,int Numboftabs)
    {
        super(fm);
        this.fm=fm;
        this.titles=titles;
        this.num_tabs=Numboftabs;
    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new Tab1();

            case 1:
                return new Tab2();
        }
        return null;
    }

    @Override
    public int getCount() {
        return num_tabs;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
