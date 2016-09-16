package com.smileman.toshiba.simplegolfz;

import android.app.Fragment;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by toshiba on 2016/04/29.
 */
public class ProductFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.product_fragment,container,false);

        return view;
    }

    public void setCourse(Course course){
        View view = getView();

        ImageView imageView = (ImageView)view.findViewById(R.id.image);


        Drawable icon = getResources().getDrawable(course.getImageId());
        imageView.setImageDrawable(icon);

    }

    @Override
    public void onPause() {
        super.onPause();
    }
}
