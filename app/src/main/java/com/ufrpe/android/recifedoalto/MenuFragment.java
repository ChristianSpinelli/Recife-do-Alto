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
 * Created by Christian Spinelli on 31/05/2017.
 */

public class MenuFragment extends Fragment {

    private GridView mMenuGrid;
    private MenuAdapter mMenuAdapter;
    private ArrayList<Area> mAreas = new ArrayList<Area>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_menu,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mMenuGrid = (GridView) view.findViewById(R.id.menu_grid);
        LocalLab localLab = LocalLab.get();
        mAreas = localLab.getAreas();

        mMenuAdapter = new MenuAdapter(mAreas,this.getActivity());
        mMenuGrid.setAdapter(mMenuAdapter);

        mMenuGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = MenuLocalsFragmentActivity.newIntent(getActivity());
                intent.putExtra("area",mAreas.get(position).getTitle());
                startActivity(intent);
            }
        });

    }
}
