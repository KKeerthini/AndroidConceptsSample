package com.andr.studio.proj.swipetab.tabs;

/**
 * Created by CIPL310 on 9/15/2015.
 */

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andr.studio.proj.swipetab.R;
import com.andr.studio.proj.swipetab.RecyclerAdapter;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tab1 extends Fragment {

    Context context;
    RecyclerView mRecyclerView;
    RecyclerView.LayoutManager mLayoutManager;
    RecyclerView.Adapter mAdapter;
    String jsonResponse;
    List<String> listitems = new ArrayList<String>();
    String url_2 = "https://ajax.googleapis.com/ajax/services/feed/find?v=1.0&q=Official%20Google%20Blogs";

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       /* HttpReq req2 = new HttpReq(context, new AsyncInterface() {
            @Override
            public void ontaskcompleted(Integer result) {
                result = 0;
            }
        }, url_2, 2);
        req2.execute();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                jsonResponse = SingletonClaz.getInstance().JSONResponse;
                Log.d("JSOn in TAB 1--------->", jsonResponse);

                if (jsonResponse != null) {
                    fetch_JSON(jsonResponse);
                }
            }
        }, 500);*/


        View v = inflater.inflate(R.layout.fragment_tab1, container, false);
        mRecyclerView = (RecyclerView) v.findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(context);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
       /* listitems.add("Row 1");
        listitems.add("Row 2");
        listitems.add("Row 3");*/
        mAdapter = new RecyclerAdapter(listitems, context);
        mRecyclerView.setAdapter(mAdapter);
        return v;
    }

    public void fetch_JSON(String response) {

        try {

            JSONObject jsonObj = new JSONObject(response);
            JSONArray jArray_user = jsonObj.optJSONArray("user");
            for (int i = 0; i < jArray_user.length(); i++) {
                JSONObject json_param = jArray_user.getJSONObject(i);
                String id = json_param.getString("id");
                String name = json_param.getString("name");
                String email = json_param.getString("email");
                listitems.add(id);
                listitems.add(name);
                listitems.add(email);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
