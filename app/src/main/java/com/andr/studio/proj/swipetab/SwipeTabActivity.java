package com.andr.studio.proj.swipetab;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.andr.studio.proj.swipetab.interfaces.AsyncInterface;

public class SwipeTabActivity extends AppCompatActivity  {
    Context context;
    Toolbar toolbar;
    ViewPager pager;
    ViewPagerAdapter adapter;
    SlidingLayoutBar tabs;
    CharSequence Titles[] = { "Tab1", "Tab2"};
    int Numboftabs = 2;
    String url_1="http://api.learn2crack.com/android/json/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HttpReq req = new HttpReq(context, new AsyncInterface() {
            @Override
            public void ontaskcompleted(Integer result) {
                result = 0;

            }
        },url_1,1);
        req.execute();
        setContentView(R.layout.activity_swipe_tab);

        // Creating The Toolbar and setting it as the Toolbar for the activity

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setIcon(R.mipmap.ic_launcher);

        // Creating The ViewPagerAdapter and Passing Fragment Manager, Titles
        // fot the Tabs and Number Of Tabs.
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), Titles,
                Numboftabs);

        // Assigning ViewPager View and setting the adapter
        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(adapter);


        // Assiging the Sliding Tab Layout View
        tabs = (SlidingLayoutBar) findViewById(R.id.tabs);
        tabs.setDistributeEvenly(true);

        // Setting Custom Color for the Scroll bar indicator of the Tab View
        tabs.setCustomTabColorizer(new SlidingLayoutBar.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {

                return R.color.colorAccent;
            }
        });

        // Setting the ViewPager For the SlidingTabsLayout
        tabs.setViewPager(pager);

    }


}


