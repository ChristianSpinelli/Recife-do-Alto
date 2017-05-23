package com.ufrpe.android.recifedoalto;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InfoWindowActivity extends AppCompatActivity {

    private TextView mTxtTitle, mTxtDescription;
    private ImageView mImgLocal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_window);

        mTxtTitle = (TextView) findViewById(R.id.txt_info_title);
        mTxtDescription = (TextView) findViewById(R.id.txt_info_description);
        mImgLocal = (ImageView) findViewById(R.id.img_info);

        int title = getIntent().getIntExtra("title",R.string.local1_title);
        int description = getIntent().getIntExtra("description",R.string.local1_description);
        int image = getIntent().getIntExtra("image",R.drawable.img_local1);

        mTxtTitle.setText(getString(title));
        mTxtDescription.setText(getString(description));
        mImgLocal.setImageResource(image);
    }
}
