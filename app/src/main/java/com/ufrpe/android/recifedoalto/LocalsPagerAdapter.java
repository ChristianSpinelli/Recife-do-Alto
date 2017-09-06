package com.ufrpe.android.recifedoalto;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 12/06/2017.
 */

public class LocalsPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Area> mAreas;
    private Activity mActivity;

    public LocalsPagerAdapter(FragmentManager fm, ArrayList<Area> areas, Activity activity) {
        super(fm);
        mAreas = areas;
        mActivity = activity;
    }

    @Override
    public Fragment getItem(int position) {
        return new ImageFragment();
    }

    @Override
    public int getCount() {
        return mAreas.size();
    }
}
