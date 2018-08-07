package com.ufrpe.android.recifedoalto;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
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

import com.vstechlab.easyfonts.EasyFonts;

import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 31/05/2017.
 */

public class MenuFragment extends BaseFragmentMenu {

    private RecyclerView mMenuRecyclerView;
    private MenuAdapter mMenuAdapter;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Area> mAreas = new ArrayList<Area>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.activity_menu,container,false);
        return view;
    }
    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.main_toolbar_menu, menu);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(false); // disable the button
            actionBar.setDisplayHomeAsUpEnabled(false); // remove the left caret
            actionBar.setDisplayShowHomeEnabled(false); // remove the icon
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.map_menu:
                Intent intent = MapsActivity.newIntent(this.getActivity());
                startActivity(intent);
                return true;
            case R.id.locals_menu:
                intent = ExpandableLocalsListActivity.newIntent(this.getActivity());
                startActivity(intent);
                return true;
            case R.id.about_menu:
                intent=AboutActivity.newIntent(this.getActivity());
                startActivity(intent);
                return true;
        }

        return onOptionsItemSelected(item);
    }
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mMenuRecyclerView = (RecyclerView) view.findViewById(R.id.menu_grid);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        mCollapsingToolbarLayout.setTitle(getResources().getString(R.string.app_name));
        mCollapsingToolbarLayout.setCollapsedTitleTypeface(EasyFonts.robotoLight(getActivity().getApplicationContext()));


        toolbarTextAppernce();


        LocalLab localLab = LocalLab.get();
        mAreas = localLab.getAreas();

        mLayoutManager = new LinearLayoutManager(this.getActivity(),LinearLayoutManager.VERTICAL,false);
        mMenuRecyclerView.setLayoutManager(mLayoutManager);

        mMenuAdapter = new MenuAdapter(mAreas,this.getActivity());
        mMenuRecyclerView.setAdapter(mMenuAdapter);
    }

    private void toolbarTextAppernce() {
        mCollapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        mCollapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
    }


}
