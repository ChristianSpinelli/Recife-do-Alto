package com.ufrpe.android.recifedoalto;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 01/06/2017.
 */

public class Area {

    private int mTitle, mImg, mIcon;
    private ArrayList<Local> mLocals;

    public LatLng getPosition() {
        return mPosition;
    }

    private LatLng mPosition;

    public Area(int title, int img,LatLng position){
        mPosition=position;
        mTitle = title;
        mImg = img;
        mLocals = new ArrayList<Local>();
    }

    public int getTitle() {
        return mTitle;
    }

    public void setTitle(int title) {
        mTitle = title;
    }

    public int getImg() {
        return mImg;
    }

    public void setImg(int img) {
        mImg = img;
    }

    public ArrayList<Local> getLocals() {
        return mLocals;
    }

    public void setLocals(ArrayList<Local> locals) {
        mLocals = locals;
    }

    public int getIcon() {
        return mIcon;
    }

    public void setIcon(int icon) {
        mIcon = icon;
    }
}
