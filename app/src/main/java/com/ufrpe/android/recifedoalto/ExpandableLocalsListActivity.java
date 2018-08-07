package com.ufrpe.android.recifedoalto;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.MenuItem;

/**
 * Created by Christian Spinelli on 13/07/2017.
 */

public class ExpandableLocalsListActivity extends BaseFragmentActivity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context,ExpandableLocalsListActivity.class);
        return intent;
    }

    @Override
    protected Fragment createFragment() {
        return new ExpandableLocalsListFragment();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
