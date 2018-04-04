package com.ufrpe.android.recifedoalto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.github.chrisbanes.photoview.OnPhotoTapListener;
import com.github.chrisbanes.photoview.PhotoView;


/**
 * Created by Christian Spinelli on 12/06/2017.
 */

public class ImageFragment extends Fragment {

    private PhotoView mImgLocal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.activity_image,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        final int mImage = getActivity().getIntent().getIntExtra("image",0);
        mImgLocal = (PhotoView) view.findViewById(R.id.img_local);
        mImgLocal.setImageResource(mImage);
        mImgLocal.setOnPhotoTapListener(new OnPhotoTapListener() {
            @Override
            public void onPhotoTap(ImageView view, float x, float y) {
                float heigth = mImgLocal.getHeight();//1674
                float width = mImgLocal.getWidth();//3824
                float relativeHeight=y*heigth;
                float relativeWidth=x*width;

                if (mImage == R.drawable.mirante_riomar_map) {
                    Local local;
                     //1
                    if((relativeWidth>=(width*0.8263) && relativeWidth<(width*0.8577))
                            && (relativeHeight>= (heigth*0.1672) && relativeHeight<(heigth*0.2777))){
                        local = LocalLab.get().getLocals().get(0);
                        openInfoActivity(local);
                    }
                    //2
                    if((relativeWidth>=(width*0.7949) && relativeWidth<(width*0.8263))
                            && (relativeHeight>= (heigth*0.3464) && relativeHeight<(heigth*0.4540))){
                        local = LocalLab.get().getLocals().get(21);
                        openInfoActivity(local);
                    }
                    //3
                    if((relativeWidth>=(width*0.7126) && relativeWidth<(width*0.7426))
                            && (relativeHeight>= (heigth*0.3882) && relativeHeight<(heigth*0.4958))){
                        local = LocalLab.get().getLocals().get(27);
                        openInfoActivity(local);
                    }
                    //4
                    if((relativeWidth>=(width*0.6537) && relativeWidth<(width*0.6825))
                            && (relativeHeight>= (heigth*0.3273) && relativeHeight<(heigth*0.4348))){
                        local = LocalLab.get().getLocals().get(22);
                        openInfoActivity(local);
                    }
                    //5
                    if((relativeWidth>=(width*0.6106) && relativeWidth<(width*0.6380))
                            && (relativeHeight>= (heigth*0.3285) && relativeHeight<(heigth*0.4360))){
                        local = LocalLab.get().getLocals().get(23);
                        openInfoActivity(local);
                    }
                    //6
                    if((relativeWidth>=(width*0.6001) && relativeWidth<(width*0.6283))
                            && (relativeHeight>= (heigth*0.4629) && relativeHeight<(heigth*0.5704))){
                        local = LocalLab.get().getLocals().get(24);
                        openInfoActivity(local);
                    }
                    //7
                    if((relativeWidth>=(width*0.6328) && relativeWidth<(width*0.6603))
                            && (relativeHeight>= (heigth*0.4241) && relativeHeight<(heigth*0.5316))){
                        local = LocalLab.get().getLocals().get(25);
                        openInfoActivity(local);
                    }
                    //8
                    if((relativeWidth>=(width*0.5774) && relativeWidth<(width*0.6066))
                            && (relativeHeight>= (heigth*0.3584) && relativeHeight<(heigth*0.4659))){
                        local = LocalLab.get().getLocals().get(26);
                        openInfoActivity(local);
                    }


                }if(mImage == R.drawable.mirante_catamara_map){
                    Local local;
                    //1
                    if( (relativeWidth>=(width*0.7282) && relativeWidth<(width*0.7531))
                            && (relativeHeight>= (heigth*0.2508) && relativeHeight<(heigth*0.3614) ) ){
                        local = LocalLab.get().getLocals().get(3);
                        openInfoActivity(local);
                    //2
                    }if( relativeWidth>=(width*0.6665) && relativeWidth<(width*0.6903)
                            && (relativeHeight>=(heigth*0.2986) && relativeHeight<(heigth*0.4091))){
                        local = LocalLab.get().getLocals().get(0);
                        openInfoActivity(local);
                    }

                }if(mImage == R.drawable.mirante_paco_map){
                    Local local;
                    //1
                    if( (relativeWidth>=(width*0.4040) &&relativeWidth<(width*0.4249))
                            && (relativeHeight>=(heigth*0.5077) && relativeHeight<(heigth*0.6182)) ){
                        local = LocalLab.get().getLocals().get(2);
                        openInfoActivity(local);
                    }
                    //2
                    if( (relativeWidth>=(width*0.0588) &&relativeWidth<(width*0.0810))
                            && (relativeHeight>=(heigth*0.2060) && relativeHeight<(heigth*0.3166)) ){
                        local = LocalLab.get().getLocals().get(4);
                        openInfoActivity(local);
                    }

                    //3
                    if( (relativeWidth>=(width*0.0065) &&relativeWidth<(width*0.0287))
                            && (relativeHeight>=(heigth*0.2120) && relativeHeight<(heigth*0.3225)) ){
                        local = LocalLab.get().getLocals().get(10);
                        openInfoActivity(local);
                    }

                    //4
                    if( (relativeWidth>=(width*0.3765) &&relativeWidth<(width*0.3961))
                            && (relativeHeight>=(heigth*0.0716) && relativeHeight<(heigth*0.1792)) ){
                        local = LocalLab.get().getLocals().get(11);
                        openInfoActivity(local);
                    }

                    //5
                    if( (relativeWidth>=(width*0.3896) &&relativeWidth<(width*0.4105))
                            && (relativeHeight>=(heigth*0.1702) && relativeHeight<(heigth*0.2777)) ){
                        local = LocalLab.get().getLocals().get(12);
                        openInfoActivity(local);
                    }

                    //6
                    if( (relativeWidth>=(width*0.4327) &&relativeWidth<(width*0.4537))
                            && (relativeHeight>=(heigth*0.0268) && relativeHeight<(heigth*0.1373)) ){
                        local = LocalLab.get().getLocals().get(8);
                        openInfoActivity(local);
                    }

                    //7
                    if( (relativeWidth>=(width*0.4641) &&relativeWidth<(width*0.4850))
                            && (relativeHeight>=(heigth*0.0448) && relativeHeight<(heigth*0.1553)) ){
                        local = LocalLab.get().getLocals().get(13);
                        openInfoActivity(local);
                    }

                    //8
                    if( (relativeWidth>=(width*0.4746) &&relativeWidth<(width*0.4929))
                            && (relativeHeight>=(heigth*0.1702) && relativeHeight<(heigth*0.2747)) ){
                        local = LocalLab.get().getLocals().get(14);
                        openInfoActivity(local);
                    }

                    //9
                    if( (relativeWidth>=(width*0.4864) &&relativeWidth<(width*0.5060))
                            && (relativeHeight>=(heigth*0.3255) && relativeHeight<(heigth*0.4360)) ){
                        local = LocalLab.get().getLocals().get(7);
                        openInfoActivity(local);
                    }

                    //10
                    if( (relativeWidth>=(width*0.4981) &&relativeWidth<(width*0.5177))
                            && (relativeHeight>=(heigth*0.1911) && relativeHeight<(heigth*0.2986)) ){
                        local = LocalLab.get().getLocals().get(9);
                        openInfoActivity(local);
                    }

                    //11
                    if( (relativeWidth>=(width*0.5086) &&relativeWidth<(width*0.5282))
                            && (relativeHeight>=(heigth*0.0776) && relativeHeight<(heigth*0.1821)) ){
                        local = LocalLab.get().getLocals().get(15);
                        openInfoActivity(local);
                    }

                    //12
                    if( (relativeWidth>=(width*0.5910) &&relativeWidth<(width*0.6132))
                            && (relativeHeight>=(heigth*0.0776) && relativeHeight<(heigth*0.1821)) ){
                        local = LocalLab.get().getLocals().get(16);
                        openInfoActivity(local);
                    }

                    //13
                    if( (relativeWidth>=(width*0.6956) &&relativeWidth<(width*0.7152))
                            && (relativeHeight>=(heigth*0.1851) && relativeHeight<(heigth*0.2956)) ){
                        local = LocalLab.get().getLocals().get(17);
                        openInfoActivity(local);
                    }

                    //14
                    if( (relativeWidth>=(width*0.7322) &&relativeWidth<(width*0.7531))
                            && (relativeHeight>=(heigth*0.2927) && relativeHeight<(heigth*0.4032)) ){
                        local = LocalLab.get().getLocals().get(5);
                        openInfoActivity(local);
                    }

                    //15
                    if( (relativeWidth>=(width*0.7792) &&relativeWidth<(width*0.7975))
                            && (relativeHeight>=(heigth*0.1344) && relativeHeight<(heigth*0.2419)) ){
                        local = LocalLab.get().getLocals().get(18);
                        openInfoActivity(local);
                    }

                    //16
                    if( (relativeWidth>=(width*0.8028) &&relativeWidth<(width*0.8224))
                            && (relativeHeight>=(heigth*0.0955) && relativeHeight<(heigth*0.2001)) ){
                        local = LocalLab.get().getLocals().get(19);
                        openInfoActivity(local);
                    }

                    //17
                    if( (relativeWidth>=(width*0.8786) &&relativeWidth<(width*0.8982))
                            && (relativeHeight>=(heigth*0.2150) && relativeHeight<(heigth*0.3195)) ){
                        local = LocalLab.get().getLocals().get(20);
                        openInfoActivity(local);
                    }


                    //18
                    if( (relativeWidth>=(width*0.9388) &&relativeWidth<(width*0.9597))
                            && (relativeHeight>=(heigth*0.2867) && relativeHeight<(heigth*0.3972)) ){
                        local = LocalLab.get().getLocals().get(6);
                        openInfoActivity(local);
                    }
                }

                Log.d("Position", relativeWidth+ " " + relativeHeight);
                Log.d("Position",mImgLocal.getWidth()+ " " +  mImgLocal.getHeight());
            }
        });


    }
    private void openInfoActivity(Local local){
        Intent intent = InfoPagerActivity.newIntent(this.getActivity());
        intent.putExtra("images",local.getInfoImages());
        startActivity(intent);
    }

}
