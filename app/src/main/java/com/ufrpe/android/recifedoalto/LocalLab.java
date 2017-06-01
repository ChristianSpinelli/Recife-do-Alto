package com.ufrpe.android.recifedoalto;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;


/**
 * Created by Christian Spinelli on 24/05/2017.
 */

public class LocalLab {

    private static LocalLab sLocalLab;
    private ArrayList<Local> mLocals;
    private ArrayList<Area> mAreas;

    public LocalLab(){
        mLocals = new ArrayList<Local>();
        mAreas = new ArrayList<Area>();
        Area area1 = new Area(R.string.area_title,R.drawable.riomar);
        Local local1 = new Local(R.string.local1_title,R.string.local1_description,
                R.drawable.img_local1,R.drawable.img_map1,new LatLng(-8.082839,-34.891022));
        Local local2 = new Local(R.string.local2_title,R.string.local2_description,
                R.drawable.forte_das_cinco_pontas,R.drawable.img_map1,new LatLng(-8.071743,-34.880880));
        area1.getLocals().add(local1);
        area1.getLocals().add(local2);
        mLocals.add(local1);
        mLocals.add(local2);
        mAreas.add(area1);


    }

    public static LocalLab get(){
        if (sLocalLab == null){
            sLocalLab = new LocalLab();
        }
        return sLocalLab;
    }

    public ArrayList<Local> getLocals() {
        return mLocals;
    }

    public ArrayList<Area> getAreas() {
        return mAreas;
    }
}
