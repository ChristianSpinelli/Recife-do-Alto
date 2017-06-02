package com.ufrpe.android.recifedoalto;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
        setContentView(R.layout.activity_container);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment == null){
            fragment = new InfoWindowFragment();
            fm.beginTransaction().add(R.id.fragment_container, fragment).commit();
        }


    }
}
