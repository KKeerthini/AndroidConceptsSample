package com.andr.studio.proj.swipetab.sensor;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.widget.TextView;

import com.andr.studio.proj.swipetab.R;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by CIPL0310 on 12/28/2015.
 */
public class SensorDetectActivity extends Activity {
    TextView sensorTextView;
    SensorManager sensorManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aa_activityholder);
        sensorTextView=(TextView)findViewById(R.id.sensorText);
        sensorManager=(SensorManager)getSystemService(SENSOR_SERVICE);
         List<Sensor> sensorsList=sensorManager.getSensorList(Sensor.TYPE_ALL);
        for(int i=0;i<sensorsList.size();i++)
        {
            sensorTextView.setText(sensorsList.get(i).getType()+"\t"+ sensorsList.get(i).getVersion()+"\t"+sensorsList.get(i).getVendor());
        }
    }
}
