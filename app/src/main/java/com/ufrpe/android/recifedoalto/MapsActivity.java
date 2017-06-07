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
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback{

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
        final ArrayList<Local> locals = localLab.getLocals();

        // Add a marker in Sydney and move the camera
        LatLng local = new LatLng(-8.082626,-34.891044);
        int title;
        for (int i = 0; i <locals.size() ; i++) {
            local = locals.get(i).getPosition();
            title = locals.get(i).getInfoImages().get(0).getTitle();
            mMap.addMarker(new MarkerOptions().position(local).title(getString(title)));

        }

        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
            @Override
            public boolean onMarkerClick(Marker marker) {
                for(int i=0; i<locals.size(); i++){
                    if(marker.getTitle().equals(getString(locals.get(i).getInfoImages().get(0).getTitle()))){
                        Intent intent = new Intent(MapsActivity.this,ImageActivity.class);
                        intent.putExtra("image",locals.get(i).getImageMap());
                        startActivity(intent);
                    }
                }

                return true;
            }
        });


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(local,13  ));
        mMap.setMinZoomPreference(13);
        mMap.setMaxZoomPreference(15);

    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context,MapsActivity.class);
        return intent;
    }


}
