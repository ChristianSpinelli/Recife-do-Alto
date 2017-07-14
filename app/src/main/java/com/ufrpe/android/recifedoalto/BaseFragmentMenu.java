package com.ufrpe.android.recifedoalto;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

/**
 * Created by Christian Spinelli on 13/07/2017.
 */

public abstract class BaseFragmentMenu extends Fragment {
    protected abstract Intent createIntent();

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu, menu);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.map_menu:
                Intent intent = createIntent();
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