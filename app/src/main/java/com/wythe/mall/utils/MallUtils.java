package com.wythe.mall.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

/**
 * Created by wythe on 2016/7/10.
 */
public class MallUtils {
    private static int   IMAGE_MAX_WIDTH  = 480;
    private static int   IMAGE_MAX_HEIGHT = 960;

    public static void setImageSrc(ImageView imageView, String imagePath) {
        BitmapFactory.Options option = new BitmapFactory.Options();
        option.inSampleSize = getImageScale(imagePath);
        Bitmap bm = BitmapFactory.decodeFile(imagePath, option);
        imageView.setImageBitmap(bm);
    }

    public static void setImageSrc(ImageView imageView, Bitmap bm) {
        BitmapFactory.Options option = new BitmapFactory.Options();
        option.inSampleSize = 1;
        imageView.setImageBitmap(bm);
    }

    /**
     * scale image to fixed height and weight
     *
     * @param imagePath
     * @return
     */
    private static int getImageScale(String imagePath) {
        BitmapFactory.Options option = new BitmapFactory.Options();
        // set inJustDecodeBounds to true, allowing the caller to query the bitmap info without having to allocate the
        // memory for its pixels.
        option.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(imagePath, option);

        int scale = 1;
        while (option.outWidth / scale >= IMAGE_MAX_WIDTH || option.outHeight / scale >= IMAGE_MAX_HEIGHT) {
            scale *= 2;
        }
        return scale;
    }
}
