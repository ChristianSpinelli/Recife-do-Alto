package com.ufrpe.android.recifedoalto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ExpandableListView;

import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 13/07/2017.
 */

public class ExpandableLocalsListFragment extends BaseFragmentMenu2 {

    private ExpandableLocalsListAdapter mAdapter;
    private ExpandableListView mListView;

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.activity_locals_expandable_list,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_list);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        actionBar.setTitle(getString(R.string.locals_items));

        mListView = (ExpandableListView) view.findViewById(R.id.locals_list);
        LocalLab localLab = LocalLab.get();
        final ArrayList<Area> areas = localLab.getAreas();
        mAdapter = new ExpandableLocalsListAdapter(this.getActivity(),areas);
        mListView.setAdapter(mAdapter);




    }
}
