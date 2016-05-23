package com.andr.studio.proj.swipetab;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by CIPL310 on 9/15/2015.
 */

public class RecyclerItem extends RecyclerView.ViewHolder {
    private final TextView mItemTextView;

    public RecyclerItem(final View parent, TextView itemTextView) {
        super(parent);
        mItemTextView = itemTextView;
    }
    public static RecyclerItem newInstance(View parent) {
        TextView itemTextView = (TextView) parent.findViewById(R.id.text_no);
        return new RecyclerItem(parent, itemTextView);
    }
    public void setItemText(CharSequence text) {
        mItemTextView.setText(text);
    }

}