package com.andr.studio.proj.swipetab.db;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.andr.studio.proj.swipetab.R;

/**
 * Created by CIPL310 on 9/28/2015.
 */
public class ProfileNameActivity extends Activity {
    TextView name_text;
    LinearLayout linearLayout;
    String name;

    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_name);LinearLayout
                linearlayout = (LinearLayout) findViewById(R.id.linearlayout);
        name_text=(TextView)findViewById(R.id.text_view);
        db=new DatabaseHelper(ProfileNameActivity.this);
        AppModel app=new AppModel();
        app=db.fetch_Name();
        name=app.getName_model()+app.getDate_model()+app.getMonth_model()+app.getYear_model();

        Log.d("name in class", name);
        name_text.setText(name);

    }
}
