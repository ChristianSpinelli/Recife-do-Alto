package com.ufrpe.android.recifedoalto;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by Christian Spinelli on 01/06/2017.
 */

public class MenuLocalsFragmentActivity extends BaseFragmentActivity {



    @Override
    protected Fragment createFragment() {
        return new MenuLocalsFragment();
    }


    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context,MenuLocalsFragmentActivity.class);
        return intent;
    }


}
