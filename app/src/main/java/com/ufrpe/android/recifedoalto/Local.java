package com.ufrpe.android.recifedoalto;


import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Christian Spinelli on 19/05/2017.
 */

public class Local {

    private int mTitle;
    private LatLng mPosition;

    public Local(int title, LatLng position){
        mTitle = title;
        mPosition = position;
    }

    public int getTitle() {
        return mTitle;
    }

    public void setTitle(int title) {
        mTitle = title;
    }

    public LatLng getPosition() {
        return mPosition;
    }

    public void setPosition(LatLng position) {
        mPosition = position;
    }
}
