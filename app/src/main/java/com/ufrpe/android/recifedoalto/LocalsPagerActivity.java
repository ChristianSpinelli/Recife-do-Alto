package com.ufrpe.android.recifedoalto;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 12/06/2017.
 */

public class LocalsPagerActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private LocalsPagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locals_pager);

        mViewPager = (ViewPager) findViewById(R.id.locals_pager);
        FragmentManager fm = getSupportFragmentManager();
        ArrayList<Local> locals = LocalLab.get().getLocals();
        mAdapter = new LocalsPagerAdapter(fm,locals,this);
        mViewPager.setAdapter(mAdapter);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position",0);

        mViewPager.setCurrentItem(position);


    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context,LocalsPagerActivity.class);
        return intent;
    }
}
