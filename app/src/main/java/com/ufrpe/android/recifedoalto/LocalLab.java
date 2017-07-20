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

        //criação do local ponte paulo guerra
        InfoImage infoImage1_1 = new InfoImage(R.drawable.img_local1,R.string.local1_title,R.string.local1_description,0);
        InfoImage infoImage1_2 = new InfoImage(R.drawable.img_local1_2,R.string.local1_title,R.string.local1_description,0);
        ArrayList<InfoImage> infoImages1 = new ArrayList<InfoImage>();
        infoImages1.add(infoImage1_1);
        infoImages1.add(infoImage1_2);
        Local local1 = new Local(infoImages1,R.drawable.img_map1,new LatLng(-8.081665,-34.890282),R.string.local1_address);

        //criação do local forte das cinco pontas
        InfoImage infoImage2_1 = new InfoImage(R.drawable.img_local2,R.string.local2_title,R.string.local2_description,1);
        InfoImage infoImage2_2 = new InfoImage(R.drawable.img_local2_2,R.string.local2_title,R.string.local2_description,1);
        ArrayList<InfoImage> infoImages2 = new ArrayList<InfoImage>();
        infoImages2.add(infoImage2_1);
        infoImages2.add(infoImage2_2);
        Local local2 = new Local(infoImages2,R.drawable.forte_das_cinco_pontas,new LatLng(-8.071743,-34.880880),R.string.local2_address);

        //criação do local rio capibaribe
        InfoImage infoImage3_1 = new InfoImage(R.drawable.mirante_paco,R.string.local3_title,R.string.local3_description,0);
        ArrayList<InfoImage> infoImages3 = new ArrayList<>();
        infoImages3.add(infoImage3_1);
        Local local3 = new Local(infoImages3,R.drawable.paco_local1,new LatLng(-8.064789,-34.874896),R.string.local3_address);

        mLocals.add(local1);
        mLocals.add(local2);
        mLocals.add(local3);


        Area area1 = new Area(R.string.area_title,R.drawable.riomar,new LatLng(-8.085790, -34.895140));
        area1.getLocals().add(local1);
        area1.getLocals().add(local2);

        Area area2 = new Area(R.string.area2_tittle,R.drawable.mirante_paco,new LatLng(-8.064825,-34.873804));
        area2.getLocals().add(local3);


        mAreas.add(area1);
        mAreas.add(area2);


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
