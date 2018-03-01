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
                    if ((relativeWidth>= (width*0.6027) && relativeWidth < (width*0.6328))
                            && (relativeHeight >= (heigth*0.3285) && relativeHeight < (heigth*0.4390)) ) {
                        local = LocalLab.get().getLocals().get(1);
                        openInfoActivity(local);

                    }if((relativeWidth>=(width*0.8054) && relativeWidth<(width*0.8355))
                            && (relativeHeight>= (heigth*0.3673) && relativeHeight<(heigth*0.4778))){
                        local = LocalLab.get().getLocals().get(0);
                        openInfoActivity(local);
                    }

                }if(mImage == R.drawable.mirante_catamara_map){
                    Local local;
                    if( (relativeWidth>=(width*0.7282) && relativeWidth<(width*0.7531))
                            && (relativeHeight>= (heigth*0.2508) && relativeHeight<(heigth*0.3614) ) ){
                        local = LocalLab.get().getLocals().get(3);
                        openInfoActivity(local);

                    }if( relativeWidth>=(width*0.6665) && relativeWidth<(width*0.6903)
                            && (relativeHeight>=(heigth*0.2986) && relativeHeight<(heigth*0.4091))){
                        local = LocalLab.get().getLocals().get(0);
                        openInfoActivity(local);
                    }

                }if(mImage == R.drawable.mirante_paco_map){
                    Local local;
                    if( (relativeWidth>=(width*0.4040) &&relativeWidth<(width*0.4249))
                            && (relativeHeight>=(heigth*0.5077) && relativeHeight<(heigth*0.6182)) ){
                        local = LocalLab.get().getLocals().get(2);
                        openInfoActivity(local);
                    }

                    if( (relativeWidth>=(width*0.0588) &&relativeWidth<(width*0.0810))
                            && (relativeHeight>=(heigth*0.2060) && relativeHeight<(heigth*0.3166)) ){
                        local = LocalLab.get().getLocals().get(4);
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
