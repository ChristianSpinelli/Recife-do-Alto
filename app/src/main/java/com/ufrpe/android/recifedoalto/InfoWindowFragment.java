package com.ufrpe.android.recifedoalto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 02/06/2017.
 */

public class InfoWindowFragment extends Fragment {

    private RecyclerView mInfoList;
    private InfoWindowAdapter mInfoAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_info_window,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mInfoList = (RecyclerView) this.getActivity().findViewById(R.id.info_list);
        Intent intent = this.getActivity().getIntent();
        ArrayList<InfoImage> infoImages = (ArrayList<InfoImage>) intent.getSerializableExtra("images");



        mLayoutManager = new LinearLayoutManager(this.getActivity(),LinearLayoutManager.HORIZONTAL,true);
        mInfoList.setLayoutManager(mLayoutManager);

        mInfoAdapter = new InfoWindowAdapter(this.getActivity(),infoImages);
        mInfoList.setAdapter(mInfoAdapter);

    }
}
