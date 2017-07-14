package com.ufrpe.android.recifedoalto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.pm.ActivityInfoCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 27/06/2017.
 */

public class InfoFragment extends Fragment {

    private ImageView mImageView;
    private int mPosition;
    private ArrayList<InfoImage> mInfoImages;

    public InfoFragment(int position){
        mPosition = position;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view,Bundle savedInstanceState) {


        mImageView = (ImageView) view.findViewById(R.id.info_image);


        Intent intent = getActivity().getIntent();
        mInfoImages = (ArrayList<InfoImage>) intent.getSerializableExtra("images");



        mImageView.setImageResource(mInfoImages.get(mPosition).getImage());





    }
}
