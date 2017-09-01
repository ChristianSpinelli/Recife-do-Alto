package com.ufrpe.android.recifedoalto;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 01/06/2017.
 */

public class Area {

    private int mTitle, mImg;
    private ArrayList<Local> mLocals;
    private Category mCategory;
    private boolean mInsertArea;

    public LatLng getPosition() {
        return mPosition;
    }

    private LatLng mPosition;

    public Area(int title, int img,LatLng position){
        mPosition=position;
        mTitle = title;
        mImg = img;
        mLocals = new ArrayList<Local>();
        mInsertArea = true;
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

    public Category getCategory() {
        return mCategory;
    }

    public void setCategory(Category category) {
        mCategory = category;
    }

    public void setPosition(LatLng position) {
        mPosition = position;
    }

    public boolean isInsertArea() {
        return mInsertArea;
    }

    public void setInsertArea(boolean insertArea) {
        mInsertArea = insertArea;
    }
}
