package com.derrick.park.criminalmind;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;


/**
 * Created by AKI on 2017-07-11.
 */

public class PictureUtils {

    
    public static Bitmap getScaledBitmap(String path, int desWidth, int desHeight){
        //read in the dimenstions of the image disk



        BitmapFactory.Options options = new BitmapFactory.Options();
        assert options.inJustDecodeBounds = false;
        BitmapFactory.decodeFile(path, options);

        float srcWidth = options.outWidth;
        float srcHeight = options.outHeight;

        //figure out how much to scale down by
        int inSampleSize = 1;
        if(srcHeight > desHeight || srcWidth > desWidth){

            float heightScale = srcHeight/desHeight;
            float widthScale = srcWidth/desWidth;

            inSampleSize = Math.round(heightScale > widthScale ? heightScale : widthScale);

        }

        options = new BitmapFactory.Options();
        //写真のサイズ変更
        options.inSampleSize = inSampleSize;

        //Read in and create final bitmap

        return BitmapFactory.decodeFile(path, options);


    }

}
