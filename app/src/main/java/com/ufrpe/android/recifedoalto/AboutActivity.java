package com.ufrpe.android.recifedoalto;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.vstechlab.easyfonts.EasyFonts;

public class AboutActivity extends AppCompatActivity {
    private TextView prefectureInfo;
    private TextView devsInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setTitle(getString(R.string.about));
        prefectureInfo= (TextView)findViewById(R.id.prefecture_info);
        devsInfo=(TextView)findViewById(R.id.devs_info);
        setTypeFaces();
    }
    private void setTypeFaces(){
        prefectureInfo.setTypeface(EasyFonts.robotoLight(this));
        devsInfo.setTypeface(EasyFonts.robotoLight(this));
    }
    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context,AboutActivity.class);
        return intent;
    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

}
