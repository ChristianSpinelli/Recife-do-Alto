package com.ufrpe.android.recifedoalto;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 27/06/2017.
 */

public class InfoPagerAdapter extends FragmentStatePagerAdapter {

    private ArrayList<InfoImage> mInfoImages;
    private int mPosition;


    public InfoPagerAdapter(FragmentManager fm, ArrayList<InfoImage> infoImages) {
        super(fm);
        mInfoImages = infoImages;
    }


    @Override
    public Fragment getItem(int position) {
        mPosition = position;
        return new InfoFragment(mPosition);
    }

    @Override
    public int getCount() {
        return mInfoImages.size();
    }

    public int getPosition() {
        return mPosition;
    }
}
