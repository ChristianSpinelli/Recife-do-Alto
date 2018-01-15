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

public class ImageFragment extends Fragment {

    private ImageView mImgLocal;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        View view = inflater.inflate(R.layout.activity_image,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        final int mImage = getActivity().getIntent().getIntExtra("image",0);

        mImgLocal = (ImageView) view.findViewById(R.id.img_local);
        mImgLocal.setImageResource(mImage);
        mImgLocal.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(event.getAction() == MotionEvent.ACTION_DOWN) {

                    float heigth = mImgLocal.getHeight();//1674
                    float width = mImgLocal.getWidth();//2000


                    if (mImage == R.drawable.mirante_riomar_map) {
                        Local local;
                            if ((event.getX() >= (width*0.8106) && event.getX() < (width*0.8368))
                                    && (event.getY() >= (heigth*0.3643) && event.getY() < (heigth*0.4749)) ) {
                                local = LocalLab.get().getLocals().get(0);
                                openInfoActivity(local);

                            }if((event.getX()>=(width*0.6080) && event.getX()<(width*0.6367))
                                && (event.getY()>= (heigth*0.3225) && event.getY()<(heigth*0.4181))){
                                local = LocalLab.get().getLocals().get(1);
                                openInfoActivity(local);
                            }

                    }if(mImage == R.drawable.mirante_catamara_map){
                       Local local;
                        if( (event.getX()>=(width*0.8656) && event.getX()<(width*0.8763))
                                && (event.getY()>= (heigth*0.2568) && event.getY()<(heigth*0.3643) ) ){
                            local = LocalLab.get().getLocals().get(3);
                            openInfoActivity(local);

                        }if( (event.getX()>=(width*0.8355) && event.getX()<(width*0.8463))
                                && (event.getY()>=(heigth*0.2986) && event.getY()<(heigth*0.4062)) ){
                            local = LocalLab.get().getLocals().get(0);
                            openInfoActivity(local);
                        }

                    }if(mImage == R.drawable.mirante_paco_map){
                        Local local;
                        if( (event.getX()>=(width*0.4133) && event.getX()<(width*0.4297))
                                && (event.getY()>=(heigth*0.5017) && event.getY()<(heigth*0.6033)) ){
                            local = LocalLab.get().getLocals().get(2);
                            openInfoActivity(local);
                        }
                    }

                    Log.d("Position", event.getX()+ " " + event.getY());
                    Log.d("Position",mImgLocal.getWidth()+ " " +  mImgLocal.getHeight());
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
