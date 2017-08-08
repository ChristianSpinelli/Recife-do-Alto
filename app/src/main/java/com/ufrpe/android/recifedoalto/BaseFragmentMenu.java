package com.ufrpe.android.recifedoalto;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Christian Spinelli on 13/07/2017.
 */

public abstract class BaseFragmentMenu extends Fragment {

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu, menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.map_menu:
                Intent intent = MapsActivity.newIntent(this.getActivity());
                startActivity(intent);
                return true;
            case R.id.locals_menu:
                intent = ExpandableLocalsListActivity.newIntent(this.getActivity());
                startActivity(intent);
                return true;
        }
        return onOptionsItemSelected(item);
    }
}
