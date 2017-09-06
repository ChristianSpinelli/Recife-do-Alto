package com.ufrpe.android.recifedoalto;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;

/**
 * Created by Christian Spinelli on 05/09/2017.
 */

public class ImageFragmentActivity extends BaseFragmentActivity {


    @Override
    protected Fragment createFragment() {
        return new ImageFragment(getIntent().getIntExtra("image",0));
    }

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context,ImageFragmentActivity.class);
        return intent;
    }
}
