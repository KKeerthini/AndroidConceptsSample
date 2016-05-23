package com.andr.studio.proj.swipetab;

/**
 * Created by CIPL310 on 9/21/2015.
 */

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;

import com.andr.studio.proj.swipetab.interfaces.TriggerWithString;


public class SwipeGestureListener extends  GestureDetector.SimpleOnGestureListener {
    private int swipe_Min_Distance = 50;
    private int swipe_Max_Distance = 550;
    private int swipe_Min_Velocity = 50;
    Context mContext;
    TriggerWithString trigger;

    public SwipeGestureListener(Context context, TriggerWithString trig) {
        // TODO Auto-generated constructor stub
        mContext = context;
        trigger = trig;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        final float xDistance = Math.abs(e1.getX() - e2.getX());
        final float yDistance = Math.abs(e1.getY() - e2.getY());

        if (xDistance > this.swipe_Max_Distance
                || yDistance > this.swipe_Max_Distance)
            return false;

        velocityX = Math.abs(velocityX);
        velocityY = Math.abs(velocityY);
        boolean result = false;

        if (velocityX > this.swipe_Min_Velocity
                && xDistance > this.swipe_Min_Distance) {
            if (e1.getX() > e2.getX()) {
                // right to left
                trigger.initTrigger(true, "");
            } else {
                // left to right
            }
            result = true;
        } else if (velocityY > this.swipe_Min_Velocity
                && yDistance > this.swipe_Min_Distance) {
            if (e1.getY() > e2.getY()) {

                // bottom to up

            } else {
                // up to bottom

            }
            result = true;
        }
        return result;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        // TODO Auto-generated method stub
        super.onLongPress(e);
        trigger.initTrigger(true, "longPress");
    }
}

