package com.ufrpe.android.recifedoalto;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.MarkerOptions;
import com.vstechlab.easyfonts.EasyFonts;

import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 27/06/2017.
 */

public class InfoPagerFragment extends BaseFragmentMenu implements OnMapReadyCallback {

    private ViewPager mViewPager;
    private InfoPagerAdapter mAdapter;
    private TextView mDescription;
    private ArrayList<InfoImage> mInfoImages;
    private TextView mName;
    private CollapsingToolbarLayout mCollapsingToolbarLayout;
    private GoogleMap mMap;
    private TextView mAddress;

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
        FragmentManager fm = getFragmentManager();
        mInfoImages = (ArrayList<InfoImage>) this.getActivity().getIntent().getSerializableExtra("images");
        mAdapter = new InfoPagerAdapter(fm,mInfoImages);
        mAddress=(TextView)view.findViewById(R.id.info_address);

        String title = getString(mInfoImages.get(mAdapter.getPosition()).getTitle());
        String description = getString(mInfoImages.get(mAdapter.getPosition()).getDescription());
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar);
        mName =(TextView)view.findViewById(R.id.info_name);
        mName.setText(title);
        Toolbar toolbar = (Toolbar) view.findViewById(R.id.toolbar_info);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        mCollapsingToolbarLayout = (CollapsingToolbarLayout) view.findViewById(R.id.collapsing_toolbar_info);
        mDescription.setText(description);
        setTypeFaces();
        mViewPager.setAdapter(mAdapter);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().onBackPressed();
            }
        });
        SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.info_map);
        mapFragment.getMapAsync(this);
    }

    private void setTypeFaces() {
        mAddress.setTypeface(EasyFonts.robotoLight(getActivity().getApplicationContext()));
        mName.setTypeface(EasyFonts.robotoLight(getActivity().getApplicationContext()));
        mDescription.setTypeface(EasyFonts.robotoLight(getActivity().getApplicationContext()));
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap=googleMap;
      Local local= LocalSession.get().getLocal();
      if(getString(local.getAddress()).equals("")){
          mAddress.setText(getString(R.string.address_not_set));
      }else{
          mAddress.setText(local.getAddress());
      }

        int title = local.getInfoImages().get(0).getTitle();
        int address = local.getAddress();
        mMap.addMarker(new MarkerOptions().snippet(getString(address)).position(local.getPosition()).title(getString(title)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(local.getPosition(), 13));
    }
}
