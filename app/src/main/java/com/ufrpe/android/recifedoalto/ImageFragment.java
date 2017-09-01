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

                    float heigth = mImgLocal.getHeight();//1704
                    float width = mImgLocal.getWidth();//1080

                    if(mImage == R.drawable.img_map1_selec){
                        Local local;
                        if((event.getY()>= (heigth*0.7335) && event.getY() <= (heigth*0.7511)) ||
                                (event.getX()>=(width*0.5925) && event.getX()<=(width*0.7962)) &&
                                        (event.getY()>=(heigth*0.3286) && event.getY()<=(heigth*0.7511))){
                            local = LocalLab.get().getLocals().get(0);
                            openInfoActivity(local);

                        }


                    }if(mImage == R.drawable.forte_das_cinco_pontas_selec){
                        Local local;
                        if( (event.getX()>=(width*0.2870) && event.getX()<=(width*0.7314)) &&
                                (event.getY()>=(heigth*0.2464) && event.getY()<=(heigth*0.5516) ) ){
                            local = LocalLab.get().getLocals().get(1);
                            openInfoActivity(local);
                        }

                    }if(mImage == R.drawable.mirante_paco_selec){
                        Local local;
                        if((event.getX()>=(width*0.0416) && event.getX()<=(width*0.8981))
                                &&(event.getY()>=(heigth*0.4577) && event.getY()<=(heigth*0.8861))){
                            local = LocalLab.get().getLocals().get(2);
                            openInfoActivity(local);
                        }

                    }

                    if(mImage == R.drawable.shopping_riomar_select){
                        Local local;
                        local = LocalLab.get().getLocals().get(3);
                        openInfoActivity(local);
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
