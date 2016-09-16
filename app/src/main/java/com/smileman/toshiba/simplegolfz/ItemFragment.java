package com.smileman.toshiba.simplegolfz;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;


public class ItemFragment extends ListFragment {

    private OnCourseItemClickListener onCourseItemClickListener;

    public interface OnCourseItemClickListener {
        public void onCourseItemClicked(int position);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    public void setOnCourseItemClickListener(OnCourseItemClickListener onCourseItemClickListener) {
        this.onCourseItemClickListener = onCourseItemClickListener;
    }


    public void onListItemClick(ListView l, View v, int position, long id) {
        if (onCourseItemClickListener != null) {
            onCourseItemClickListener.onCourseItemClicked(position);
        }
    }
}
