package com.ufrpe.android.recifedoalto;


import android.content.Intent;
import android.media.Image;
import android.os.Parcelable;

import com.google.android.gms.maps.model.LatLng;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 19/05/2017.
 */

public class Local implements Serializable{

    private int  mImageMap, mAddress, mIconList, mImageMapSelec;
    private ArrayList<InfoImage> mInfoImages;
    private LatLng mPosition;
    private Category mCategory;



    public Local( ArrayList<InfoImage> images, int imageMap, LatLng position, int address){
        mPosition = position;
        mInfoImages = images;
        mImageMap = imageMap;
        mAddress = address;


    }

    public LatLng getPosition() {
        return mPosition;
    }

    public void setPosition(LatLng position) {
        mPosition = position;
    }

    public ArrayList<InfoImage> getInfoImages() {
        return mInfoImages;
    }

    public void setInfoImages(ArrayList<InfoImage> infoImages) {
        mInfoImages = infoImages;
    }

    public int getImageMap() {
        return mImageMap;
    }


    public void setImageMap(int imageMap) {
        mImageMap = imageMap;
    }

    public int getAddress() {
        return mAddress;
    }

    public void setAddress(int address) {
        mAddress = address;
    }

    public int getIconList() {
        return mIconList;
    }

    public void setIconList(int iconList) {
        mIconList = iconList;
    }

    public int getImageMapSelec() {
        return mImageMapSelec;
    }

    public void setImageMapSelec(int imageMapSelec) {
        mImageMapSelec = imageMapSelec;
    }

    public Category getCategory() {
        return mCategory;
    }

    public void setCategory(Category category) {
        mCategory = category;
    }
}
