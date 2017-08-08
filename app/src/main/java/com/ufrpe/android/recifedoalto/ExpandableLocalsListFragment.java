package com.ufrpe.android.recifedoalto;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 13/07/2017.
 */

public class ExpandableLocalsListFragment extends BaseFragmentMenu {

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

        mListView = (ExpandableListView) view.findViewById(R.id.locals_list);
        LocalLab localLab = LocalLab.get();
        ArrayList<Area> areas = localLab.getAreas();
        mAdapter = new ExpandableLocalsListAdapter(this.getActivity(),areas);
        mListView.setAdapter(mAdapter);



    }
}
