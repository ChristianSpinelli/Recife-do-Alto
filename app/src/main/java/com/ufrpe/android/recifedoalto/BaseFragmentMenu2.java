package com.ufrpe.android.recifedoalto;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Created by Christian Spinelli on 13/07/2017.
 */

public abstract class BaseFragmentMenu2 extends Fragment {

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu2, menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.map_menu:
                Intent intent = MapsActivity.newIntent(this.getActivity());
                startActivity(intent);
                return true;
            case R.id.observatory_menu:
                intent = MenuFragmentActivity.newIntent(this.getActivity());
                startActivity(intent);
                return true;
        }
        return onOptionsItemSelected(item);
    }
}
