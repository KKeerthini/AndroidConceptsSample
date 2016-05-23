package com.andr.studio.proj.swipetab.tabs;

/**
 * Created by CIPL310 on 9/15/2015.
 */
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.andr.studio.proj.swipetab.ExpandableListAdapter;
import com.andr.studio.proj.swipetab.R;
import com.andr.studio.proj.swipetab.SingletonClaz;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

public class Tab2 extends Fragment {
    ExpandableListAdapter expandableListAdapter;
    ExpandableListView expListView;
    List<String> listDataHeader;
    HashMap<String, List<String>> listDataChild;
    String jsonResponse2;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        jsonResponse2= SingletonClaz.getInstance().JSONResponse2;
        if(jsonResponse2!=null)
        {
            fetch_JSON2(jsonResponse2);
        }
        View v = inflater.inflate(R.layout.fragment_tab2, container, false);
       // expListView=(ExpandableListView)v.findViewById(R.id.expand_view);

      //  expandableListAdapter = new ExpandableListAdapter(getActivity(), listDataHeader, listDataChild);

        // setting list adapter
      //  expListView.setAdapter(expandableListAdapter);



        return v;
    }

    public void fetch_JSON2(String response)
    {
        try {
            JSONObject jsonObject = new JSONObject(response);
            JSONObject jobject=jsonObject.optJSONObject("options");


                String responseData=jobject.optString("responseData");
                String responseDetails=jobject.optString("responseDetails");
                String responseStatus=jobject.optString("responseStatus");
                Log.d("google response",responseData + responseDetails+responseStatus);


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
