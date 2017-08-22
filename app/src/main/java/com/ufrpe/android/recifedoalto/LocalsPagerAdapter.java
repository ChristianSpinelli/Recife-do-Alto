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

    private ArrayList<Local> mLocals;
    private Activity mActivity;

    public LocalsPagerAdapter(FragmentManager fm, ArrayList<Local> locals, Activity activity) {
        super(fm);
        mLocals = locals;
        mActivity = activity;
    }

    @Override
    public Fragment getItem(int position) {
        return new ImageFragment(mLocals.get(position).getImageMapSelec());
    }

    @Override
    public int getCount() {
        return mLocals.size();
    }
}
