package com.ufrpe.android.recifedoalto;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;


/**
 * Created by Christian Spinelli on 24/05/2017.
 */

public class LocalLab {

    private static LocalLab sLocalLab;
    private ArrayList<Local> mLocals;

    public LocalLab(){
        mLocals = new ArrayList<>();
        mLocals.add(new Local(R.string.local1_title,R.string.local1_description,
                R.drawable.img_local1,R.drawable.riomar,new LatLng(-8.082626,-34.891044)));
        mLocals.add(new Local(R.string.local2_title,R.string.local2_description,
                R.drawable.forte_das_cinco_pontas,R.drawable.riomar,new LatLng(-8.071743,-34.880880)));
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


}
