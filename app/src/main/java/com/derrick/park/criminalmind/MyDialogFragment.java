package com.derrick.park.criminalmind;

import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;


/**
 * Created by AKI on 2017-07-12.
 */
public class MyDialogFragment extends DialogFragment {
    private ImageView mZoomedImageView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_my_dialog, container, false);
        getDialog().setTitle("Simple Dialog");
        byte[] byteArray = getArguments().getByteArray("key");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        mZoomedImageView = (ImageView) rootView.findViewById(R.id.image);
        mZoomedImageView.setImageBitmap(bmp);



        return rootView;
    }
}


