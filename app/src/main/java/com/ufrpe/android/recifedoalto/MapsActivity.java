package com.ufrpe.android.recifedoalto;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
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
        int position = getIntent().getIntExtra("position", -1);
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
                        int address = local.getAddress();
                        mMap.addMarker(new MarkerOptions().snippet(getString(address)).position(local.getPosition()).title(getString(title)));
                        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(local.getPosition(), 13));
                    }
                    break;
                }
            }


        }
        else if(position != -1) {
            final Local local = locals.get(position);

            final LatLng localPosition = local.getPosition();
            int address = local.getAddress();
            int title = local.getInfoImages().get(0).getTitle();
            //verificando se o local possui icone, se não tiver deixa o default do google
            if(local.getIcon() != 0){
                Marker marker= mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(local.getIcon()))
                        .snippet(getString(address)).position(localPosition).title(getString(title)));
                marker.showInfoWindow();

            }else{
               Marker marker = mMap.addMarker(new MarkerOptions()
                        .snippet(getString(address)).position(localPosition).title(getString(title)));
                marker.showInfoWindow();
            }

            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(localPosition, 13));
        }else{
            //colocando todos os locais no mapa
            for (int i = 0; i <locals.size() ; i++) {
                Local local = locals.get(i);
                //verificando se o local possui icone, se não tiver deixa o default do google
                if(local.getIcon() != 0){
                    mMap.addMarker(new MarkerOptions().snippet(getString(local.getAddress()))
                            .icon(BitmapDescriptorFactory.fromResource(local.getIcon()))
                            .position(local.getPosition()).title(getString(local.getInfoImages().get(0).getTitle())));
                }else{
                    mMap.addMarker(new MarkerOptions().snippet(getString(local.getAddress()))
                            .position(local.getPosition()).title(getString(local.getInfoImages().get(0).getTitle())));
                }

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(local.getPosition(), 13));
            }
            //colocando todas as areas no mapa
            for (int i = 0; i <areas.size() ; i++) {
                Area area = areas.get(i);
                if(area.getIcon() !=0){
                    mMap.addMarker(new MarkerOptions().position(area.getPosition())
                            .icon(BitmapDescriptorFactory.fromResource(area.getIcon())).title(getString(area.getTitle())));
                }else{
                    mMap.addMarker(new MarkerOptions().position(area.getPosition())
                           .title(getString(area.getTitle())));
                }

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(area.getPosition(), 13));
            }
        }
        mMap.setMinZoomPreference(11);
        mMap.setMaxZoomPreference(15);

    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context,MapsActivity.class);
        return intent;
    }


}
