package com.andr.studio.proj.swipetab.circle;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by CIPL310 on 9/30/2015.
 */
public class CircleActivity extends AppCompatActivity {
    private static Paint p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(new SampleView(this));
    }

    private static class SampleView extends View {

        // CONSTRUCTOR
        public SampleView(Context context) {
            super(context);
            setFocusable(true);

        }

        @Override
        protected void onDraw(Canvas canvas) {

            canvas.drawColor(Color.WHITE);

            p = new Paint();
            // smooths
            //p[i].setAntiAlias(true);
            p.setColor(Color.RED);
            p.setStyle(Paint.Style.STROKE);
            p.setStrokeWidth(7.5f);
            // opacity
            //p.setAlpha(0x80); //
            canvas.drawCircle(50, 50, 30, p);
        }

    }

}


