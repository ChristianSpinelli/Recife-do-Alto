package com.ufrpe.android.recifedoalto;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;


public class InfoWindowFragmentActivity extends BaseFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return new InfoWindowFragment();
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context,InfoWindowFragmentActivity.class);
        return intent;
    }
}

