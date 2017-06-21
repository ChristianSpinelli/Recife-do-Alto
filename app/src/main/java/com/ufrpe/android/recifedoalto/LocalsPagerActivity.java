package com.ufrpe.android.recifedoalto;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 12/06/2017.
 */

public class LocalsPagerActivity extends BaseFragmentActivity {


    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context,LocalsPagerActivity.class);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new LocalsPagerFragment();
    }
}
