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

/**
 * Created by Christian Spinelli on 12/06/2017.
 */

public class ImageFragment extends BaseFragmentMenu {

    private ImageView mImgLocal;
    private final int mImage;

    public ImageFragment(int image) {
        mImage = image;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.activity_image,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        mImgLocal = (ImageView) view.findViewById(R.id.img_local);
        mImgLocal.setImageResource(mImage);
        mImgLocal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    if(mImage == R.drawable.riomar) {
                        Local local;
                        if ((event.getY() >= 1120 && event.getY() <= 1180) ||
                                (event.getX() >= 1530 && event.getX() <= 1730 &&
                                        (event.getY() >= 560 && event.getY() <= 1180))) {
                            local = LocalLab.get().getLocals().get(0);
                            openInfoActivity(local);

                        }
                        if ((event.getX() >= 470 && event.getX() <= 540) && (event.getY() <= 1060 && event.getY() >= 1020)) {
                            local = LocalLab.get().getLocals().get(1);
                            openInfoActivity(local);

                        }

                    }if(mImage == R.drawable.img_map1){
                        Local local;
                        if((event.getY()>=1250 && event.getY() <= 1280) ||
                                (event.getX()>=640 && event.getX()<=860) &&
                                        (event.getY()>=560 && event.getY()<=1280)){
                            local = LocalLab.get().getLocals().get(0);
                            openInfoActivity(local);

                        }


                    }if(mImage == R.drawable.forte_das_cinco_pontas){
                        Local local;
                        if( (event.getX()>=310 && event.getX()<=790) &&
                                (event.getY()>=420 && event.getY()<=940 ) ){
                            local = LocalLab.get().getLocals().get(1);
                            openInfoActivity(local);
                        }

                    }if(mImage == R.drawable.mirante_paco){
                        Local local;
                        if((event.getX()>=45 && event.getX()<=970) &&(event.getY()>=780 && event.getY()<=1510)){
                            local = LocalLab.get().getLocals().get(2);
                            openInfoActivity(local);
                        }
                    }
                    Log.d("Position",event.getX()+" "+event.getY());
                }

                return true;
            }
        });

    }

    private void openInfoActivity(Local local){
        Intent intent = InfoPagerActivity.newIntent(this.getActivity());
        intent.putExtra("images",local.getInfoImages());
        startActivity(intent);
    }

}
