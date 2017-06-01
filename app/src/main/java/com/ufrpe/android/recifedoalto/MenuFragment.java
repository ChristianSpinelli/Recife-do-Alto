package com.ufrpe.android.recifedoalto;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 31/05/2017.
 */

public class MenuFragment extends Fragment {

    private ListView mMenuList;
    private MenuAdapter mMenuAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_menu,container,false);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        mMenuList = (ListView) view.findViewById(R.id.menu_list);
        ArrayList<Integer> menuImages = new ArrayList<Integer>();
        menuImages.add(R.drawable.riomar);
        menuImages.add(R.drawable.img_local1);

        mMenuAdapter = new MenuAdapter(menuImages,this.getActivity());
        mMenuList.setAdapter(mMenuAdapter);


    }
}
