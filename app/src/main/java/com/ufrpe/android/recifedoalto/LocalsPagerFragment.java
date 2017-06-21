package com.ufrpe.android.recifedoalto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 21/06/2017.
 */

public class LocalsPagerFragment extends Fragment {

    private ViewPager mViewPager;
    private LocalsPagerAdapter mAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_locals_pager,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {

        mViewPager = (ViewPager) view.findViewById(R.id.locals_pager);
        FragmentManager fm = getFragmentManager();
        ArrayList<Local> locals = LocalLab.get().getLocals();
        mAdapter = new LocalsPagerAdapter(fm,locals,this.getActivity());
        mViewPager.setAdapter(mAdapter);

        Intent intent = this.getActivity().getIntent();
        int position = intent.getIntExtra("position",0);

        mViewPager.setCurrentItem(position);
    }
}
