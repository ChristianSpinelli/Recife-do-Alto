package com.ufrpe.android.recifedoalto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
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

    private GridView mMenuLocalsGrid;
    private MenuLocalsAdapter mMenuLocalsAdapter;
    private ArrayList<Local> mLocals;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_locals_menu,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
       mMenuLocalsGrid = (GridView) view.findViewById(R.id.menu_locals_grid);
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

        mMenuLocalsAdapter = new MenuLocalsAdapter(mLocals,this.getActivity());
        mMenuLocalsGrid.setAdapter(mMenuLocalsAdapter);

        mMenuLocalsGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MenuLocalsFragment.this.getActivity(),ImageActivity.class);
                intent.putExtra("image",mLocals.get(position).getImageMap());
                startActivity(intent);
            }
        });

    }
}
