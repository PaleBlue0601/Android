package com.example.kanmeitu.util;

import android.app.Activity;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.kanmeitu.R;

public class ImageUtil {
    public static void show(Activity activity, ImageView imageview, String url){
        RequestOptions options = getCommonRequestOptions();
        Glide.with(activity).load(url).apply(options).into(imageview);
    }

    private static RequestOptions getCommonRequestOptions() {
        RequestOptions options = new RequestOptions();
//        加载占位图
        options.placeholder(R.drawable.item_image);
//        加载错误图
        options.error(R.drawable.error);
        options.centerCrop();

//        测试，禁用所以缓存
//        options.diskCacheStrategy(DiskCacheStrategy.NONE);

        return options;
    }
}
