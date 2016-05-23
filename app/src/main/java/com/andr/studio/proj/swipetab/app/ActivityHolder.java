package com.andr.studio.proj.swipetab.app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;

import com.andr.studio.proj.swipetab.R;
import com.andr.studio.proj.swipetab.tabs.Tab1;

/**
 * Created by CIPL310 on 11/26/2015.
 */
public class ActivityHolder extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout relativeLayout=(RelativeLayout)findViewById(R.id.relativeL);
        Tab1 tab=new Tab1();
        getSupportFragmentManager().beginTransaction().add(R.id.relativeL,tab);
    }


}
