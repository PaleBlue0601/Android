package com.example.kanmeitu.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.kanmeitu.R;
import com.example.kanmeitu.util.Constants;
import com.example.kanmeitu.util.ImageUtil;
import com.github.chrisbanes.photoview.PhotoView;

public class ImageDatailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_datail);

        PhotoView pv = (PhotoView) findViewById(R.id.pv);

        String url = getIntent().getStringExtra(Constants.ID);
        ImageUtil.show(this, pv, url);
    }
}
