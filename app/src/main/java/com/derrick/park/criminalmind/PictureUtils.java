package com.derrick.park.criminalmind;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

/**
 * Created by AKI on 2017-07-11.
 */

public class PictureUtils {


    public static Bitmap getScaleBitmap(String path, Activity activity){
        Point size = new Point();
        activity.getWindowManager().getDefaultDisplay().getSize(size);

        return getScaledBitmap(path, size.x, size.y);


    }
    public static Bitmap getScaledBitmap(String path, int destWidth, int desHeight){
        //read in the dimenstions of the image disk
        BitmapFactory.Options options = new BitmapFactory.Options();
        assert options.inJustDecodeBounds = false;
        BitmapFactory.decodeFile(path, options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;

        //figure out how much to scale down by
        int inSampleSize = 1;
        if(srcHeight > desHeight || srcWidth > destWidth){

            float heightScale = srcHeight/desHeight;
            float widthScale = srcWidth/destWidth;

            inSampleSize = Math.round(heightScale > widthScale ? heightScale : widthScale);

        }

        options = new BitmapFactory.Options();
        //写真のサイズ変更
        options.inSampleSize = inSampleSize;

        //Read in and create final bitmap

        return BitmapFactory.decodeFile(path, options);


    }

}
