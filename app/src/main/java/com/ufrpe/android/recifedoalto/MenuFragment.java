package com.ufrpe.android.recifedoalto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 31/05/2017.
 */

public class MenuFragment extends Fragment {

    private RecyclerView mMenuRecyclerView;
    private MenuAdapter mMenuAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Area> mAreas = new ArrayList<Area>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_menu,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mMenuRecyclerView = (RecyclerView) view.findViewById(R.id.menu_grid);
        LocalLab localLab = LocalLab.get();
        mAreas = localLab.getAreas();

        mLayoutManager = new LinearLayoutManager(this.getActivity(),LinearLayoutManager.VERTICAL,false);
        mMenuRecyclerView.setLayoutManager(mLayoutManager);

        mMenuAdapter = new MenuAdapter(mAreas,this.getActivity());
        mMenuRecyclerView.setAdapter(mMenuAdapter);


    }
}
