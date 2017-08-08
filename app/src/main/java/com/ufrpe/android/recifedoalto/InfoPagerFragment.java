package com.ufrpe.android.recifedoalto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
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
    private TextView mTitle, mDescription, mRoute;
    private ArrayList<InfoImage> mInfoImages;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.activity_pager_info,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mViewPager = (ViewPager) view.findViewById(R.id.pager_info);
        mTitle = (TextView) view.findViewById(R.id.info_title);
        mDescription = (TextView) view.findViewById(R.id.info_description);
        mRoute = (TextView) view.findViewById(R.id.info_route);


        FragmentManager fm = getFragmentManager();
        mInfoImages = (ArrayList<InfoImage>) this.getActivity().getIntent().getSerializableExtra("images");
        mAdapter = new InfoPagerAdapter(fm,mInfoImages);

        String title = getString(mInfoImages.get(mAdapter.getPosition()).getTitle());
        String description = getString(mInfoImages.get(mAdapter.getPosition()).getDescription());

        mTitle.setText(title);
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
}
