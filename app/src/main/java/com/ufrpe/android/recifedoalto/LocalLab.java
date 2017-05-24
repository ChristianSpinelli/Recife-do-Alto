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
