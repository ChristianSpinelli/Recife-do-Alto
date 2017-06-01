package com.ufrpe.android.recifedoalto;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_container);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.menu_fragment_container);

        if(fragment == null){
            fragment = new MenuFragment();
            fm.beginTransaction().add(R.id.menu_fragment_container, fragment).commit();
        }

    }

}
