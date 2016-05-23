package com.andr.studio.proj.swipetab.androidanim;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.andr.studio.proj.swipetab.R;

/**
 * Created by CIPL310 on 10/12/2015.
 */
public class AnimActivity extends AppCompatActivity {
    TextView text1;
    TextView text2;
    @Override
    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(R.layout.animation_textview);
          text2 = (TextView) findViewById(R.id.text2);
          text1 = (TextView) findViewById(R.id.text1);
        generate();


    }

    public void generate()
    {
        text1.setTextColor(Color.BLUE);
        text1.setHeight(60);
        text1.setWidth(30);
        text1.setBackgroundColor(Color.BLUE);

        text2Run();

    }
    public void text2Run()
    {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                text2.setBackgroundColor(Color.RED);
                text2.setTextColor(Color.RED);
                text2.setHeight(40);
                text2.setWidth(30);
            }
        },3000);
    }
}
