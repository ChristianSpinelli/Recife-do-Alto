package com.ufrpe.android.recifedoalto;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by Christian Spinelli on 27/06/2017.
 */

public class InfoPagerActivity extends BaseFragmentActivity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context,InfoPagerActivity.class);
        return intent;
    }


    @Override
    protected Fragment createFragment() {
        return new InfoPagerFragment();
    }
}
