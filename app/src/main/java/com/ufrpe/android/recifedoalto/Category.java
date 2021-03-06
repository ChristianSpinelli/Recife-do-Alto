package com.ufrpe.android.recifedoalto;

import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 28/08/2017.
 */

public enum Category {

    SHOPPING(R.string.shopping,R.drawable.shopping_icon),
    BRIDGE(R.string.bridge,R.drawable.bridge_icon),
    MUSEUM(R.string.museum,R.drawable.museum_war_icon),
    RIVER(R.string.river,R.drawable.river_icon),
    BOAT_TOUR(R.string.boat_tour,R.drawable.boat_tour_icon),
    HISTORICAL_MONUMENT(R.string.historical_monument,R.drawable.historical_monument_icon),
    SQUARE(R.string.square,R.drawable.square_icon),
    CHURCH(R.string.church,R.drawable.church_icon);

    public int mTitle, mIcon, mId;

    private Category(int title, int icon){
        mTitle = title;
        mIcon = icon;

    }

    public int getTitle() {
        return mTitle;
    }

    public int getIcon() {
        return mIcon;
    }
}
