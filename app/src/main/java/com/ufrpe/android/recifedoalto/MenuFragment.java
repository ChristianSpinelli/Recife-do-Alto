package com.ufrpe.android.recifedoalto;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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
        setHasOptionsMenu(true);
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

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu, menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.map_menu:
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                intent.putExtra("areas",1);
                startActivity(intent);
                return true;
        }
        return onOptionsItemSelected(item);
    }
}
