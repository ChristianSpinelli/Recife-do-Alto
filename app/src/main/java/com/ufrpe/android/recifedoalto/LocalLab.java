package com.ufrpe.android.recifedoalto;

import com.google.android.gms.ads.identifier.AdvertisingIdClient;
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
        Local local1 = new Local(infoImages1,new LatLng(-8.081665, -34.890282),R.string.local1_address);
        local1.setCategory(Category.BRIDGE);
        local1.setIconList(R.drawable.ic_bridge);


        //criação do local forte das cinco pontas
        InfoImage infoImage2_1 = new InfoImage(R.drawable.img_local2,R.string.local2_title,R.string.local2_description,1);
        InfoImage infoImage2_2 = new InfoImage(R.drawable.img_local2_2,R.string.local2_title,R.string.local2_description,1);
        ArrayList<InfoImage> infoImages2 = new ArrayList<InfoImage>();
        infoImages2.add(infoImage2_1);
        infoImages2.add(infoImage2_2);
        Local local2 = new Local(infoImages2,new LatLng(-8.071743,-34.880880),R.string.local2_address);
        local2.setCategory(Category.MUSEUM);
        local2.setIconList(R.drawable.ic_museum);


        //criação do local rio capibaribe
        InfoImage infoImage3_1 = new InfoImage(R.drawable.paco_local1,R.string.local3_title,R.string.local3_description,2);
        ArrayList<InfoImage> infoImages3 = new ArrayList<>();
        infoImages3.add(infoImage3_1);
        Local local3 = new Local(infoImages3,new LatLng(-8.064789,-34.874896),R.string.local3_address);
        local3.setCategory(Category.RIVER);
        local3.setIconList(R.drawable.ic_river);


        //criação do local shopping riomar
        InfoImage infoImage4_1 = new InfoImage(R.drawable.img_local4_1,R.string.local4_title,R.string.local4_description,3);
        ArrayList<InfoImage> infoImages4 = new ArrayList<>();
        infoImages4.add(infoImage4_1);
        Local local4 = new Local(infoImages4,new LatLng(-8.085790,-34.895140),R.string.local4_address);
        local4.setCategory(Category.SHOPPING);
        local4.setIconList(R.drawable.ic_shopping);

        //criação do local Antiga Ponte Giratória
        InfoImage infoImage5_1 = new InfoImage(R.drawable.img_local5_1,R.string.local5_title,R.string.local5_description,4);
        ArrayList<InfoImage> infoImages5 = new ArrayList<>();
        infoImages5.add(infoImage5_1);
        Local local5 = new Local(infoImages5, new LatLng(-8.067146, -34.873874),R.string.local5_address);
        local5.setCategory(Category.BRIDGE);
        local5.setIconList(R.drawable.ic_bridge);

        //criação do local Ponte Maurício de Nassau
        InfoImage infoImage6_1 = new InfoImage(R.drawable.img_local6_1,R.string.local6_title,R.string.local6_description,5);
        ArrayList<InfoImage> infoImages6 = new ArrayList<>();
        infoImages6.add(infoImage6_1);
        Local local6 = new Local(infoImages6, new LatLng(-8.063925, -34.875415),R.string.local6_address);
        local6.setCategory(Category.BRIDGE);
        local6.setIconList(R.drawable.ic_bridge);

        //criação Ponte Buarque de Macedo
        InfoImage infoImage7_1 = new InfoImage(R.drawable.img_local7_1,R.string.local7_title,R.string.local7_description,6);
        ArrayList<InfoImage> infoImages7 = new ArrayList<>();
        infoImages7.add(infoImage7_1);
        Local local7 = new Local(infoImages7, new LatLng(-8.061825, -34.875846),R.string.local7_address);
        local7.setCategory(Category.BRIDGE);
        local7.setIconList(R.drawable.ic_bridge);

        //criação Cais do Imperador
        InfoImage infoImage8_1 = new InfoImage(R.drawable.img_local8_1,R.string.local8_title,R.string.local8_description,7);
        ArrayList<InfoImage> infoImages8 = new ArrayList<>();
        infoImages8.add(infoImage8_1);
        Local local8 = new Local(infoImages8, new LatLng(-8.065100, -34.876103),R.string.local8_address);
        local8.setCategory(Category.HISTORICAL_MONUMENT);
        local8.setIconList(R.drawable.ic_historical_monument);


        mLocals.add(local1);
        mLocals.add(local2);
        mLocals.add(local3);
        mLocals.add(local4);
        mLocals.add(local5);
        mLocals.add(local6);
        mLocals.add(local7);
        mLocals.add(local8);

        //criação do mirante do shopping riomar
        Area area1 = new Area(R.string.area_title,R.drawable.riomar,new LatLng(-8.085790, -34.895140));
        area1.getLocals().add(local2);//1
        area1.getLocals().add(local1);//2
        area1.setImgMap(R.drawable.mirante_riomar_map);
        area1.setCategory(Category.SHOPPING);
        area1.setInsertArea(false);

        //criação do mirante paço alfândega
        Area area2 = new Area(R.string.area2_tittle,R.drawable.mirante_paco,new LatLng(-8.064825,-34.873804));
        area2.getLocals().add(local3);//1
        area2.getLocals().add(local5);//2
        area2.getLocals().add(local8);//9
        area2.getLocals().add(local6);//14
        area2.getLocals().add(local7);//18
        area2.setImgMap(R.drawable.mirante_paco_map);
        area2.setCategory(Category.SHOPPING);

        //criação do mirante catamarã
        Area area3 = new Area(R.string.area3_title,R.drawable.mirante_catamara,new LatLng(-8.0741111,-34.8844026));
        area3.getLocals().add(local4);//1
        area3.getLocals().add(local1);//2
        area3.setImgMap(R.drawable.mirante_catamara_map);
        area3.setCategory(Category.BOAT_TOUR);


        mAreas.add(area1);
        mAreas.add(area2);
        mAreas.add(area3);


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
