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

        InfoImage infoImage1_1 = new InfoImage(R.drawable.img_local1,R.string.local1_title,R.string.local1_description);
        InfoImage infoImage1_2 = new InfoImage(R.drawable.img_local1_2,R.string.local1_title,R.string.local1_description2);
        ArrayList<InfoImage> infoImages1 = new ArrayList<InfoImage>();
        infoImages1.add(infoImage1_1);
        infoImages1.add(infoImage1_2);
        Local local1 = new Local(infoImages1,R.drawable.img_map1,new LatLng(-8.082839,-34.891022));

        InfoImage infoImage2_1 = new InfoImage(R.drawable.img_local2,R.string.local2_title,R.string.local2_description);
        InfoImage infoImage2_2 = new InfoImage(R.drawable.img_local2_2,R.string.local2_title,R.string.local2_description2);
        ArrayList<InfoImage> infoImages2 = new ArrayList<InfoImage>();
        infoImages2.add(infoImage2_1);
        infoImages2.add(infoImage2_2);
        Local local2 = new Local(infoImages2,R.drawable.forte_das_cinco_pontas,new LatLng(-8.071743,-34.880880));

        mLocals.add(local1);
        mLocals.add(local2);


        Area area1 = new Area(R.string.area_title,R.drawable.riomar);
        area1.getLocals().add(local1);
        area1.getLocals().add(local2);


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
