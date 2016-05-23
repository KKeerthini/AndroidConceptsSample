package com.andr.studio.proj.swipetab.textcolorchange;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import com.andr.studio.proj.swipetab.R;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;

/**
 * Created by CIPL0310 on 4/29/2016.
 */
public class TextColorChangeActivity extends Activity {
    TextView tv1;
    MoPubInterstitial mInterstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aa_activityholder);

        tv1 = (TextView) findViewById(R.id.sensorText);
       /* mInterstitial = new MoPubInterstitial(this, "ea3d257a035a44ac964db28dfebb1e88");
        mInterstitial.setInterstitialAdListener(this);
        mInterstitial.load();*/

        final Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int i = 0;

            public void run() {
                if (i == 0) {
                    tv1.setTextColor(Color.BLUE);
                }
                if (i == 1) {
                    tv1.setTextColor(Color.RED);
                }
                if (i == 2) {
                    tv1.setTextColor(Color.YELLOW);
                }
                i++;
                if (i > 3) {
                    i = 0;
                }
                handler.postDelayed(this, 50);  //for interval...
            }
        };
        handler.postDelayed(runnable, 2000); //for initial delay..*/
    }


}
