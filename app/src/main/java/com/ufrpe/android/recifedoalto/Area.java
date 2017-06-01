package com.ufrpe.android.recifedoalto;

import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 01/06/2017.
 */

public class Area {

    private int mTitle, mImg;
    private ArrayList<Local> mLocals;

    public Area(int title, int img){
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
}