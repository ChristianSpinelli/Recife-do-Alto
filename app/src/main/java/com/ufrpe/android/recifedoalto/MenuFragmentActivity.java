package com.ufrpe.android.recifedoalto;


import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

public class MenuFragmentActivity extends BaseFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new MenuFragment();
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context,MenuLocalsFragmentActivity.class);
        return intent;
    }
}
