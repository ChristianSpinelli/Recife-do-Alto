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
 * Created by Christian Spinelli on 01/06/2017.
 */

public class MenuLocalsFragment extends Fragment {

    private RecyclerView mMenuLocalsGrid;
    private MenuLocalsAdapter mMenuLocalsAdapter;
    private ArrayList<Local> mLocals;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_locals_menu,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
       mMenuLocalsGrid = (RecyclerView) view.findViewById(R.id.menu_locals_grid);

        LocalLab localLab = LocalLab.get();
        Intent intent = this.getActivity().getIntent();
        ArrayList<Area> areas = localLab.getAreas();
        String areaTitle =getString(intent.getIntExtra("area",0));
        for (int i = 0; i < areas.size() ; i++) {
            if(areaTitle.equals(getString(areas.get(i).getTitle()))){
                mLocals = areas.get(i).getLocals();
                break;
            }
        }

        mLayoutManager = new LinearLayoutManager(this.getActivity(),LinearLayoutManager.VERTICAL,false);
        mMenuLocalsGrid.setLayoutManager(mLayoutManager);

        mMenuLocalsAdapter = new MenuLocalsAdapter(mLocals,this.getActivity());
        mMenuLocalsGrid.setAdapter(mMenuLocalsAdapter);


    }

}
