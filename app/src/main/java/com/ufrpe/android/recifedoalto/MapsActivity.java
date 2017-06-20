package com.ufrpe.android.recifedoalto;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


import java.util.ArrayList;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LocalLab localLab = LocalLab.get();
        ArrayList<Local> locals = localLab.getLocals();
        ArrayList<Area> areas = localLab.getAreas();
        int position = getIntent().getIntExtra("position", 0);
        int areaBundle=getIntent().getIntExtra("areas",0);
        String areaTitle=getIntent().getStringExtra("areaTitleMenu");
        LatLng recife= new LatLng(-8.059451, -34.886507);
        if(areaBundle==1){
            for (Area area:localLab.getAreas()) {
                mMap.addMarker(new MarkerOptions().position(area.getPosition()));
            }
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(recife,11));

        }
        else if(areaTitle!=null){

            for (int i = 0; i < areas.size() ; i++) {
                if (areaTitle.equals(getString(areas.get(i).getTitle()))) {
                    for (Local local : areas.get(i).getLocals()) {
                        int title = local.getInfoImages().get(0).getTitle();
                        mMap.addMarker(new MarkerOptions().position(local.getPosition()).title(getString(title)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(local.getPosition(), 13));
                    }
                    break;
                }
            }


        }
        else {
            final Local local = locals.get(position);

            final LatLng localPosition = local.getPosition();
            int title = local.getInfoImages().get(0).getTitle();
            mMap.addMarker(new MarkerOptions().position(localPosition).title(getString(title)));
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(localPosition, 13));
        }
        mMap.setMinZoomPreference(11);
        mMap.setMaxZoomPreference(15);

    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context,MapsActivity.class);
        return intent;
    }


}
