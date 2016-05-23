package com.andr.studio.proj.swipetab;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.andr.studio.proj.swipetab.interfaces.TriggerWithString;

import java.util.List;

/**
 * Created by CIPL310 on 9/15/2015.
 */
public class  RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> mItemList;
    float x1,x2;
    float y1, y2;
    Context context;
    CardView card;
    RelativeLayout rel_lay;

    public RecyclerAdapter(List<String> itemList,Context context) {
        mItemList = itemList;
        this.context=context;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_listitem, parent, false);
       // card=(CardView)view.findViewById(R.id.card_view);
        rel_lay=(RelativeLayout)view.findViewById(R.id.relative_card);
        final GestureDetector gesturedetector = new GestureDetector(
                new SwipeGestureListener(context, new TriggerWithString() {

                    @Override
                    public void initTrigger(boolean Trigger, String string) {

                       /* if (Trigger) {
                            if (string.equals("")) {

                            } else {
                                Log.i("Long press", "true");
                            }
                        }*/
                    }
                }));
        rel_lay.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {
                gesturedetector.onTouchEvent(event);
                if (gesturedetector.onTouchEvent(event)) {
                    return true;
                }
                return false;
            }
        });

        return RecyclerItem.newInstance(view);

    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
        RecyclerItem holder = (RecyclerItem) viewHolder;
        String itemText = mItemList.get(position);
        holder.setItemText(itemText);
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }
}