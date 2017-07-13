package com.derrick.park.criminalmind;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.io.File;


/**
 * Created by AKI on 2017-07-12.
 */
public class MyDialogFragment extends DialogFragment {
    private ImageView mZoomedImageView;
    private File mPhotoFile;

    public static MyDialogFragment newInstance(File photoFile){
        MyDialogFragment dialogFragment = new MyDialogFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable("key", photoFile);
                dialogFragment.setArguments(bundle);

        return dialogFragment;

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mPhotoFile = (File) getArguments().getSerializable("key");
        View rootView = inflater.inflate(R.layout.fragment_my_dialog, container, false);
        Bitmap bmp = BitmapFactory.decodeFile(mPhotoFile.getAbsolutePath());
        mZoomedImageView = (ImageView) rootView.findViewById(R.id.image);
        mZoomedImageView.setImageBitmap(bmp);



        return rootView;
    }
}


