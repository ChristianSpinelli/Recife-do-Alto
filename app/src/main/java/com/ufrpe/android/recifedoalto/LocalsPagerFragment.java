package com.ufrpe.android.recifedoalto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.Log;
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
        View view = inflater.inflate(R.layout.activity_pager,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {

        mViewPager = (ViewPager) view.findViewById(R.id.pager);
        FragmentManager fm = getFragmentManager();
        LocalLab localLab = LocalLab.get();

        ArrayList<Area> areas = localLab.getAreas();
        ArrayList<Local> locals = new ArrayList<Local>();
        ArrayList<Local> auxLocals  = new ArrayList<Local>();

        Intent intent = this.getActivity().getIntent();
        String title = intent.getStringExtra("title");

        for (int i = 0; i <areas.size() ; i++) {
           auxLocals = areas.get(i).getLocals();
            for (int j = 0; j < auxLocals.size(); j++) {
                if(getString(auxLocals.get(j).getInfoImages().get(0).getTitle()).equals(title)){
                    locals = areas.get(i).getLocals();
                    break;
                }
            }

        }

        mAdapter = new LocalsPagerAdapter(fm,locals,this.getActivity());
        mViewPager.setAdapter(mAdapter);

        int position = intent.getIntExtra("position",0);

        mViewPager.setCurrentItem(position);
    }
}
