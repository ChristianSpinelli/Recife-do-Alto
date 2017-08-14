package com.ufrpe.android.recifedoalto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 01/06/2017.
 */

public class MenuLocalsFragment extends BaseFragmentMenu{

    private RecyclerView mMenuLocalsGrid;
    private MenuLocalsAdapter mMenuLocalsAdapter;
    private ArrayList<Local> mLocals;
    private RecyclerView.LayoutManager mLayoutManager;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private ImageView mImageToolbarLocals;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.activity_locals_menu,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {
        mMenuLocalsGrid = (RecyclerView) view.findViewById(R.id.menu_locals_grid);

        LocalLab localLab = LocalLab.get();
        Intent intent = this.getActivity().getIntent();
        ArrayList<Area> areas = localLab.getAreas();
        int toolbarImage=R.drawable.riomar;
        String areaTitle =getString(intent.getIntExtra("area",0));
        for (int i = 0; i < areas.size() ; i++) {
            if(areaTitle.equals(getString(areas.get(i).getTitle()))){
                mLocals = areas.get(i).getLocals();
                toolbarImage = areas.get(i).getImg();
                break;
            }
        }

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_locals);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar_locals);
        mCollapsingToolbarLayout.setTitle(areaTitle);


        toolbarTextAppernce();

        mImageToolbarLocals = (ImageView) view.findViewById(R.id.toolbar_locals_image);
        mImageToolbarLocals.setImageResource(toolbarImage);


        mLayoutManager = new LinearLayoutManager(this.getActivity(),LinearLayoutManager.VERTICAL,false);
        mMenuLocalsGrid.setLayoutManager(mLayoutManager);

        mMenuLocalsAdapter = new MenuLocalsAdapter(mLocals,this.getActivity());
        mMenuLocalsGrid.setAdapter(mMenuLocalsAdapter);




    }

    private void toolbarTextAppernce() {
        mCollapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        mCollapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
    }


}
