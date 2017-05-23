package com.ufrpe.android.recifedoalto;


import com.google.android.gms.maps.model.LatLng;

/**
 * Created by Christian Spinelli on 19/05/2017.
 */

public class Local {

    private int mTitle, mDescription, mImage;
    private LatLng mPosition;

    public Local(int title, int description, int image, LatLng position){
        mTitle = title;
        mPosition = position;
        mDescription = description;
        mImage = image;
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

    public int getDescription() {
        return mDescription;
    }

    public void setDescription(int description) {
        mDescription = description;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = image;
    }
}
