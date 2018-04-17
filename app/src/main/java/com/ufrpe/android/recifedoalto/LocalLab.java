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

        //criação Fórum Thomaz de Aquino
        InfoImage infoImage9_1 = new InfoImage(R.drawable.img_local9_1,R.string.local9_title,R.string.local9_description,8);
        ArrayList<InfoImage> infoImages9 = new ArrayList<>();
        infoImages9.add(infoImage9_1);
        Local local9 = new Local(infoImages9, new LatLng(-8.065696, -34.876523),R.string.local9_address);
        local9.setCategory(Category.HISTORICAL_MONUMENT);
        local9.setIconList(R.drawable.ic_historical_monument);

        //criação Praça 17
        InfoImage infoImage10_1 = new InfoImage(R.drawable.img_local10_1,R.string.local10_title,R.string.local10_description,9);
        ArrayList<InfoImage> infoImages10 = new ArrayList<>();
        infoImages10.add(infoImage10_1);
        Local local10 = new Local(infoImages10, new LatLng(-8.065248, -34.876521),R.string.local10_address);
        local10.setCategory(Category.SQUARE);
        local10.setIconList(R.drawable.ic_square);

        //Obelisco da restauração
        InfoImage infoImage11_1 = new InfoImage(R.drawable.img_local11_1,R.string.local11_title, R.string.local11_description,10);
        ArrayList<InfoImage> infoImages11 = new ArrayList<>();
        infoImages11.add(infoImage11_1);
        Local local11 = new Local(infoImages11, new LatLng(-8.066174, -34.873922),R.string.local11_address);
        local11.setCategory(Category.HISTORICAL_MONUMENT);
        local11.setIconList(R.drawable.ic_historical_monument);

        // Igreja de nossa senhora do livramento
        InfoImage infoImage12_1 = new InfoImage(R.drawable.img_local12_1,R.string.local12_title, R.string.local12_description,11);
        ArrayList<InfoImage> infoImages12 = new ArrayList<>();
        infoImages12.add(infoImage12_1);
        Local local12 = new Local(infoImages12, new LatLng(-8.067039, -34.878098),R.string.local12_address);
        local12.setCategory(Category.CHURCH);
        local12.setIconList(R.drawable.ic_church);

        //Igreja de são pedro dos clérigos
        InfoImage infoImage13_1 = new InfoImage(R.drawable.img_local13_1,R.string.local13_title,R.string.local13_description,12);
        ArrayList<InfoImage> infoImages13 = new ArrayList<>();
        infoImages13.add(infoImage13_1);
        Local local13 = new Local(infoImages13, new LatLng(-8.067396, -34.879248),R.string.local13_address);
        local13.setCategory(Category.CHURCH);
        local13.setIconList(R.drawable.ic_church);

        //Igreja do divino espirito santo
        InfoImage infoImage14_1 = new InfoImage(R.drawable.img_local14_1,R.string.local14_title,R.string.local14_description,13);
        ArrayList<InfoImage> infoImages14 = new ArrayList<>();
        infoImages14.add(infoImage14_1);
        Local local14 = new Local(infoImages14, new LatLng(-8.065704, -34.876918),R.string.local14_address);
        local14.setCategory(Category.CHURCH);
        local14.setIconList(R.drawable.ic_church);

        //Basílica de Nª Srª do Carmo
        InfoImage infoImage15_1 = new InfoImage(R.drawable.img_local15_1,R.string.local15_title,R.string.local15_description,14);
        ArrayList<InfoImage> infoImages15 = new ArrayList<>();
        infoImages15.add(infoImage15_1);
        Local local15 = new Local(infoImages15, new LatLng(-8.066009, -34.879900),R.string.local15_address);
        local15.setCategory(Category.CHURCH);
        local15.setIconList(R.drawable.ic_church);

        //Igreja de Nossa Senhora do Rosário dos Homens Pretos
        InfoImage infoImage16_1 = new InfoImage(R.drawable.img_local16_1,R.string.local16_title,R.string.local16_description,15);
        ArrayList<InfoImage> infoImages16 = new ArrayList<>();
        infoImages16.add(infoImage16_1);
        Local local16 = new Local(infoImages16, new LatLng(-8.065396, -34.877866),R.string.local16_address);
        local16.setCategory(Category.CHURCH);
        local16.setIconList(R.drawable.ic_church);

        //Igreja Matriz do Santíssimo Sacramento de Santo Antônio
        InfoImage infoImage17_1 = new InfoImage(R.drawable.img_local17_1,R.string.local17_title,R.string.local17_description,16);
        ArrayList<InfoImage> infoImages17 = new ArrayList<>();
        infoImages17.add(infoImage17_1);
        Local local17 = new Local(infoImages17, new LatLng(-8.064240, -34.878803),R.string.local17_address);
        local17.setCategory(Category.CHURCH);
        local17.setIconList(R.drawable.ic_church);

        //Arquivo Público
        InfoImage infoImage18_1 = new InfoImage(R.drawable.img_local18_1,R.string.local18_title,R.string.local18_description,17);
        ArrayList<InfoImage> infoImages18 = new ArrayList<>();
        infoImages18.add(infoImage18_1);
        Local local18 = new Local(infoImages18, new LatLng(-8.063694, -34.876669),R.string.local18_address);
        local18.setCategory(Category.HISTORICAL_MONUMENT);
        local18.setIconList(R.drawable.ic_historical_monument);

        //Convento Franciscano
        InfoImage infoImage19_1 = new InfoImage(R.drawable.img_local19_1,R.string.local19_title,R.string.local19_description,18);
        ArrayList<InfoImage> infoImages19 = new ArrayList<>();
        infoImages19.add(infoImage19_1);
        Local local19 = new Local(infoImages19, new LatLng(-8.062049, -34.877342),R.string.local19_address);
        local19.setCategory(Category.CHURCH);
        local19.setIconList(R.drawable.ic_church);

        //Palácio da Justiça
        InfoImage infoImage20_1 = new InfoImage(R.drawable.img_local20_1,R.string.local20_title,R.string.local20_description,19);
        ArrayList<InfoImage> infoImages20 = new ArrayList<>();
        infoImages20.add(infoImage20_1);
        Local local20 = new Local(infoImages20, new LatLng(-8.061671, -34.877610),R.string.local20_address);
        local20.setCategory(Category.HISTORICAL_MONUMENT);
        local20.setIconList(R.drawable.ic_historical_monument);

        //Palácio do Campo das Princesas
        InfoImage infoImage21_1 = new InfoImage(R.drawable.img_local21_1,R.string.local21_title,R.string.local21_description,20);
        ArrayList<InfoImage> infoImages21 = new ArrayList<>();
        infoImages21.add(infoImage21_1);
        Local local21 = new Local(infoImages21, new LatLng(-8.060049, -34.877494),R.string.local21_address);
        local21.setCategory(Category.HISTORICAL_MONUMENT);
        local21.setIconList(R.drawable.ic_historical_monument);

        //Brasilia Teimosa
        InfoImage infoImage22_1 = new InfoImage(R.drawable.img_local22_1,R.string.local22_title,R.string.local22_description,21);
        ArrayList<InfoImage> infoImages22 = new ArrayList<>();
        infoImages22.add(infoImage22_1);
        Local local22 = new Local(infoImages22, new LatLng(-8.086039, -34.878503),R.string.local22_address);
        local22.setCategory(Category.HISTORICAL_MONUMENT);
        local22.setIconList(R.drawable.ic_historical_monument);

        //Coluna de cristal
        InfoImage infoImage23_1 = new InfoImage(R.drawable.img_local23_1,R.string.local23_title,R.string.local23_description,22);
        ArrayList<InfoImage> infoImages23 = new ArrayList<>();
        infoImages23.add(infoImage23_1);
        Local local23 = new Local(infoImages23, new LatLng(-8.063935, -34.869188),R.string.local23_address);
        local23.setCategory(Category.HISTORICAL_MONUMENT);
        local23.setIconList(R.drawable.ic_historical_monument);

        //Basilica da Penha
        InfoImage infoImage24_1 = new InfoImage(R.drawable.img_local24_1,R.string.local24_title,R.string.local24_description,23);
        ArrayList<InfoImage> infoImages24 = new ArrayList<>();
        infoImages24.add(infoImage24_1);
        Local local24 = new Local(infoImages24, new LatLng(-8.068863, -34.878721),R.string.local24_address);
        local24.setCategory(Category.CHURCH);
        local24.setIconList(R.drawable.ic_church);

        //Igreja Mateiz de São José
        InfoImage infoImage25_1 = new InfoImage(R.drawable.img_local25_1,R.string.local25_title,R.string.local25_description,24);
        ArrayList<InfoImage> infoImages25 = new ArrayList<>();
        infoImages25.add(infoImage25_1);
        Local local25 = new Local(infoImages25, new LatLng(-8.072316, -34.882262),R.string.local25_address);
        local25.setCategory(Category.CHURCH);
        local25.setIconList(R.drawable.ic_church);

        //Cais José Estelita
        InfoImage infoImage26_1 = new InfoImage(R.drawable.img_local26_1,R.string.local26_title,R.string.local26_description,25);
        ArrayList<InfoImage> infoImages26 = new ArrayList<>();
        infoImages26.add(infoImage26_1);
        Local local26 = new Local(infoImages26, new LatLng(-8.076262, -34.890300),R.string.local26_address);
        local26.setCategory(Category.HISTORICAL_MONUMENT);
        local26.setIconList(R.drawable.ic_historical_monument);

        //Cabanga Iate Clube
        InfoImage infoImage27_1 = new InfoImage(R.drawable.img_local27_1,R.string.local27_title,R.string.local27_description,26);
        ArrayList<InfoImage> infoImages27 = new ArrayList<>();
        infoImages27.add(infoImage27_1);
        Local local27 = new Local(infoImages27, new LatLng(-8.079697, -34.894609),R.string.local27_address);
        local27.setCategory(Category.BOAT_TOUR);
        local27.setIconList(R.drawable.ic_river);

        //Ponte do Pina
        InfoImage infoImage28_1 = new InfoImage(R.drawable.img_local28_1,R.string.local28_title,R.string.local28_description,27);
        ArrayList<InfoImage> infoImages28 = new ArrayList<>();
        infoImages28.add(infoImage28_1);
        Local local28 = new Local(infoImages28, new LatLng(-8.083055, -34.890552),R.string.local28_address);
        local28.setCategory(Category.BRIDGE);
        local28.setIconList(R.drawable.ic_bridge);

        //Bacia do Pina
        InfoImage infoImage29_1 = new InfoImage(R.drawable.img_local29_1,R.string.local29_title,R.string.local29_description,28);
        ArrayList<InfoImage> infoImages29 = new ArrayList<>();
        infoImages29.add(infoImage29_1);
        Local local29 = new Local(infoImages29, new LatLng(-8.082037, -34.887282),R.string.local29_address);
        local29.setCategory(Category.HISTORICAL_MONUMENT);
        local29.setIconList(R.drawable.ic_historical_monument);

        //Colinas de Olinda
        InfoImage infoImage30_1 = new InfoImage(R.drawable.img_local30_1,R.string.local30_title,R.string.local30_description,29);
        ArrayList<InfoImage> infoImages30 = new ArrayList<>();
        infoImages30.add(infoImage30_1);
        Local local30 = new Local(infoImages30, new LatLng(-8.013572, -34.849864),R.string.local30_address);
        local30.setCategory(Category.HISTORICAL_MONUMENT);
        local30.setIconList(R.drawable.ic_historical_monument);

        //Porto Digital
        InfoImage infoImage31_1 = new InfoImage(R.drawable.img_local31_1,R.string.local31_title,R.string.local31_description,30);
        ArrayList<InfoImage> infoImages31 = new ArrayList<>();
        infoImages31.add(infoImage31_1);
        Local local31 = new Local(infoImages31, new LatLng(-8.063111, -34.873968),R.string.local31_address);
        local31.setCategory(Category.HISTORICAL_MONUMENT);
        local31.setIconList(R.drawable.ic_historical_monument);

        //Casa da Cultura
        InfoImage infoImage32_1 = new InfoImage(R.drawable.img_local32_1,R.string.local32_title,R.string.local32_description,31);
        ArrayList<InfoImage> infoImages32 = new ArrayList<>();
        infoImages32.add(infoImage32_1);
        Local local32 = new Local(infoImages32, new LatLng(-8.066103, -34.883294),R.string.local32_address);
        local32.setCategory(Category.HISTORICAL_MONUMENT);
        local32.setIconList(R.drawable.ic_historical_monument);

        //Hospital Pedro 2
        InfoImage infoImage33_1 = new InfoImage(R.drawable.img_local33_1,R.string.local33_title,R.string.local33_description,32);
        ArrayList<InfoImage> infoImages33 = new ArrayList<>();
        infoImages33.add(infoImage33_1);
        Local local33 = new Local(infoImages33, new LatLng(-8.067388, -34.890559),R.string.local33_address);
        local33.setCategory(Category.HISTORICAL_MONUMENT);
        local33.setIconList(R.drawable.ic_historical_monument);

        //Hotel Central
        InfoImage infoImage34_1 = new InfoImage(R.drawable.img_local34_1,R.string.local34_title,R.string.local34_description,33);
        ArrayList<InfoImage> infoImages34 = new ArrayList<>();
        infoImages34.add(infoImage34_1);
        Local local34 = new Local(infoImages34, new LatLng(-8.061139, -34.887570),R.string.local34_address);
        local34.setCategory(Category.HISTORICAL_MONUMENT);
        local34.setIconList(R.drawable.ic_historical_monument);

        //Forum do Recife
        InfoImage infoImage35_1 = new InfoImage(R.drawable.img_local35_1,R.string.local35_title,R.string.local35_description,34);
        ArrayList<InfoImage> infoImages35 = new ArrayList<>();
        infoImages35.add(infoImage35_1);
        Local local35 = new Local(infoImages35, new LatLng(-8.070366, -34.894705),R.string.local35_address);
        local35.setCategory(Category.HISTORICAL_MONUMENT);
        local35.setIconList(R.drawable.ic_historical_monument);

        //estádio do sport
        InfoImage infoImage36_1 = new InfoImage(R.drawable.img_local36_1,R.string.local36_title,R.string.local36_description,35);
        ArrayList<InfoImage> infoImages36 = new ArrayList<>();
        infoImages36.add(infoImage36_1);
        Local local36 = new Local(infoImages36, new LatLng(-8.062927, -34.902896),R.string.local36_address);
        local36.setCategory(Category.HISTORICAL_MONUMENT);
        local36.setIconList(R.drawable.ic_historical_monument);

        //Arrecifes
        InfoImage infoImage37_1 = new InfoImage(R.drawable.img_local37_1,R.string.local37_title,R.string.local37_description,36);
        ArrayList<InfoImage> infoImages37 = new ArrayList<>();
        infoImages37.add(infoImage37_1);
        Local local37 = new Local(infoImages37, new LatLng(-8.071496, -34.872359),R.string.local37_address);
        local37.setCategory(Category.HISTORICAL_MONUMENT);
        local37.setIconList(R.drawable.ic_historical_monument);

        //Iate Clube Pernambuco
        InfoImage infoImage38_1 = new InfoImage(R.drawable.img_local38_1,R.string.local38_title,R.string.local38_description,37);
        ArrayList<InfoImage> infoImages38 = new ArrayList<>();
        infoImages38.add(infoImage38_1);
        Local local38 = new Local(infoImages38, new LatLng(-8.079446, -34.876818),R.string.local38_address);
        local38.setCategory(Category.HISTORICAL_MONUMENT);
        local38.setIconList(R.drawable.ic_historical_monument);

        //Empresarial JCPM
        InfoImage infoImage39_1 = new InfoImage(R.drawable.img_local39_1,R.string.local39_title,R.string.local39_description,38);
        ArrayList<InfoImage> infoImages39 = new ArrayList<>();
        infoImages39.add(infoImage39_1);
        Local local39 = new Local(infoImages39, new LatLng(-8.08946,-34.881987),R.string.local39_address);
        local39.setCategory(Category.HISTORICAL_MONUMENT);
        local39.setIconList(R.drawable.ic_historical_monument);

        //Bairro do Pina
        InfoImage infoImage40_1 = new InfoImage(R.drawable.img_local40_1,R.string.local40_title,R.string.local40_description,39);
        ArrayList<InfoImage> infoImages40 = new ArrayList<>();
        infoImages40.add(infoImage40_1);
        Local local40 = new Local(infoImages40, new LatLng(-8.0966106,-34.9116294),R.string.local40_address);
        local40.setCategory(Category.HISTORICAL_MONUMENT);
        local40.setIconList(R.drawable.ic_historical_monument);

        //Bairro de Boa Viagem
        InfoImage infoImage41_1 = new InfoImage(R.drawable.img_local41_1,R.string.local41_title,R.string.local41_description,40);
        ArrayList<InfoImage> infoImages41 = new ArrayList<>();
        infoImages41.add(infoImage41_1);
        Local local41 = new Local(infoImages41, new LatLng(-8.1269376,-34.918234),R.string.local41_address);
        local41.setCategory(Category.HISTORICAL_MONUMENT);
        local41.setIconList(R.drawable.ic_historical_monument);

        //Clube Catamara
        InfoImage infoImage42_1 = new InfoImage(R.drawable.img_local42_1,R.string.local42_title,R.string.local42_description,41);
        ArrayList<InfoImage> infoImages42 = new ArrayList<>();
        infoImages42.add(infoImage42_1);
        Local local42 = new Local(infoImages42, new LatLng(-8.072739,-34.879792),R.string.local42_address);
        local42.setCategory(Category.HISTORICAL_MONUMENT);
        local42.setIconList(R.drawable.ic_historical_monument);



        mLocals.add(local1);
        mLocals.add(local2);
        mLocals.add(local3);
        mLocals.add(local4);
        mLocals.add(local5);
        mLocals.add(local6);
        mLocals.add(local7);
        mLocals.add(local8);
        mLocals.add(local9);
        mLocals.add(local10);
        mLocals.add(local11);
        mLocals.add(local12);
        mLocals.add(local13);
        mLocals.add(local14);
        mLocals.add(local15);
        mLocals.add(local16);
        mLocals.add(local17);
        mLocals.add(local18);
        mLocals.add(local19);
        mLocals.add(local20);
        mLocals.add(local21);
        mLocals.add(local22);
        mLocals.add(local23);
        mLocals.add(local24);
        mLocals.add(local25);
        mLocals.add(local26);
        mLocals.add(local27);
        mLocals.add(local28);
        mLocals.add(local29);
        mLocals.add(local30);
        mLocals.add(local31);
        mLocals.add(local32);
        mLocals.add(local33);
        mLocals.add(local34);
        mLocals.add(local35);
        mLocals.add(local36);
        mLocals.add(local37);
        mLocals.add(local38);
        mLocals.add(local39);
        mLocals.add(local40);
        mLocals.add(local41);
        mLocals.add(local42);

        //criação do mirante do shopping riomar
        Area area1 = new Area(R.string.area_title,R.drawable.riomar,new LatLng(-8.085790, -34.895140));
        area1.getLocals().add(local1);//1
        area1.getLocals().add(local22);//2
        area1.getLocals().add(local28);//3
        area1.getLocals().add(local23);//4
        area1.getLocals().add(local24);//5
        area1.getLocals().add(local25);//6
        area1.getLocals().add(local26);//7
        area1.getLocals().add(local27);//8
        area1.getLocals().add(local29);//9
        area1.getLocals().add(local30);//10
        area1.getLocals().add(local31);//11
        area1.getLocals().add(local32);//12
        area1.getLocals().add(local33);//13
        area1.getLocals().add(local34);//14
        area1.getLocals().add(local35);//15
        area1.getLocals().add(local36);//16
        area1.setImgMap(R.drawable.mirante_riomar_map);
        area1.setCategory(Category.SHOPPING);
        area1.setInsertArea(false);

        //criação do mirante paço alfândega
        Area area2 = new Area(R.string.area2_tittle,R.drawable.mirante_paco,new LatLng(-8.064825,-34.873804));
        area2.getLocals().add(local3);//1
        area2.getLocals().add(local5);//2
        area2.getLocals().add(local11);//3
        area2.getLocals().add(local12);//4
        area2.getLocals().add(local13);//5
        area2.getLocals().add(local9);//6
        area2.getLocals().add(local14);//7
        area2.getLocals().add(local15);//8
        area2.getLocals().add(local8);//9
        area2.getLocals().add(local10);//10
        area2.getLocals().add(local16);//11
        area2.getLocals().add(local17);//12
        area2.getLocals().add(local18);//13
        area2.getLocals().add(local6);//14
        area2.getLocals().add(local19);//15
        area2.getLocals().add(local20);///16
        area2.getLocals().add(local21);//17
        area2.getLocals().add(local7);//18
        area2.setImgMap(R.drawable.mirante_paco_map);
        area2.setCategory(Category.SHOPPING);

        //criação do mirante catamarã
        Area area3 = new Area(R.string.area3_title,R.drawable.mirante_catamara,new LatLng(-8.0741111,-34.8844026));
        area3.getLocals().add(local37);//1
        area3.getLocals().add(local38);//2
        area3.getLocals().add(local22);//3
        area3.getLocals().add(local39);//4
        area3.getLocals().add(local40);//5
        area3.getLocals().add(local41);//6
        area3.getLocals().add(local29);//7
        area3.getLocals().add(local1);//8
        area3.getLocals().add(local4);//9
        area3.getLocals().add(local42);//10
        area3.getLocals().add(local27);//11
        area3.setImgMap(R.drawable.mirante_catamara_map);
        area3.setCategory(Category.BOAT_TOUR);
        area3.setInsertArea(false);


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
