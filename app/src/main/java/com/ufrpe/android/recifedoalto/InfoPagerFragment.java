package com.ufrpe.android.recifedoalto;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 27/06/2017.
 */

public class InfoPagerFragment extends BaseFragmentMenu {

    private ViewPager mViewPager;
    private InfoPagerAdapter mAdapter;
    private TextView mDescription, mRoute;
    private ArrayList<InfoImage> mInfoImages;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.activity_pager_info,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mViewPager = (ViewPager) view.findViewById(R.id.pager_info);
        mDescription = (TextView) view.findViewById(R.id.info_description);
        mRoute = (TextView) view.findViewById(R.id.info_route);


        FragmentManager fm = getFragmentManager();
        mInfoImages = (ArrayList<InfoImage>) this.getActivity().getIntent().getSerializableExtra("images");
        mAdapter = new InfoPagerAdapter(fm,mInfoImages);

        String title = getString(mInfoImages.get(mAdapter.getPosition()).getTitle());
        String description = getString(mInfoImages.get(mAdapter.getPosition()).getDescription());

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);

        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_info);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        mCollapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar_info);
        mCollapsingToolbarLayout.setTitle(title);

        toolbarTextAppernce();

        mDescription.setText(description);

        mRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = MapsActivity.newIntent(getActivity());
                int localPosition = mInfoImages.get(mAdapter.getPosition()).getLocalPosition();
                intent.putExtra("position",localPosition);
                startActivity(intent);
            }
        });

        mViewPager.setAdapter(mAdapter);
    }

    private void toolbarTextAppernce() {
        mCollapsingToolbarLayout.setCollapsedTitleTextAppearance(R.style.collapsedappbar);
        mCollapsingToolbarLayout.setExpandedTitleTextAppearance(R.style.expandedappbar);
    }
}
