package com.ufrpe.android.recifedoalto;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Christian Spinelli on 01/06/2017.
 */

public class MenuLocalsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_locals_container);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.menu_locals_fragment_container);

        if(fragment == null){
            fragment = new MenuLocalsFragment();
            fm.beginTransaction().add(R.id.menu_locals_fragment_container, fragment).commit();
        }
    }
}
