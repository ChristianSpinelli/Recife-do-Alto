package com.ufrpe.android.recifedoalto;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


import java.util.ArrayList;


public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    private static String sCategory;
    private static int mMenuItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_maps);
        this.setSupportActionBar(toolbar);
        ActionBar actionBar = this.getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



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
            if(local.getCategory().getIcon() != 0){
                Marker marker= mMap.addMarker(new MarkerOptions().icon(BitmapDescriptorFactory.fromResource(local.getCategory().getIcon()))
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
                if(sCategory==null || sCategory==getString(R.string.all) ){
                    mMap.addMarker(new MarkerOptions().snippet(getString(local.getAddress()))
                            .icon(BitmapDescriptorFactory.fromResource(local.getCategory().getIcon()))
                            .position(local.getPosition()).title(getString(local.getInfoImages().get(0).getTitle())));

                }else if(sCategory==getString(local.getCategory().getTitle())) {
                    mMap.addMarker(new MarkerOptions().snippet(getString(local.getAddress()))
                            .icon(BitmapDescriptorFactory.fromResource(local.getCategory().getIcon()))
                            .position(local.getPosition()).title(getString(local.getInfoImages().get(0).getTitle())));
                }

                mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(local.getPosition(), 13));
            }
            //colocando todas as areas no mapa
            for (int i = 0; i <areas.size() ; i++) {
                Area area = areas.get(i);

                if(sCategory==null || sCategory==getString(R.string.all)){
                    mMap.addMarker(new MarkerOptions().position(area.getPosition())
                            .icon(BitmapDescriptorFactory.fromResource(area.getCategory().getIcon())).title(getString(area.getTitle())));
                }else if (sCategory==getString(area.getCategory().getTitle())){
                    mMap.addMarker(new MarkerOptions().position(area.getPosition())
                            .icon(BitmapDescriptorFactory.fromResource(area.getCategory().getIcon())).title(getString(area.getTitle())));
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.category_menu, menu);
        menu.getItem(mMenuItem).setChecked(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.category_shopping:
                sCategory = getString(R.string.shopping);
                item.setChecked(true);
                startActivity(getIntent());
                mMenuItem=1;
                return true;
            case R.id.category_bridge:
                sCategory= getString(R.string.bridge);
                item.setChecked(true);
                mMenuItem=2;
                startActivity(getIntent());
                return true;
            case R.id.category_museum:
                sCategory=getString(R.string.museum);
                item.setChecked(true);
                mMenuItem=3;
                startActivity(getIntent());
                return true;
            case R.id.category_river:
                sCategory=getString(R.string.river);
                item.setChecked(true);
                mMenuItem=4;
                startActivity(getIntent());
                return true;
            case R.id.category_all:
                sCategory=getString(R.string.all);
                item.setChecked(true);
                mMenuItem=0;
                startActivity(getIntent());
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


}
