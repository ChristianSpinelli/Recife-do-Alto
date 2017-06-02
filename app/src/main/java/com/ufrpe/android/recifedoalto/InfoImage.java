package com.ufrpe.android.recifedoalto;


import java.io.Serializable;

/**
 * Created by Christian Spinelli on 02/06/2017.
 */

public class InfoImage implements Serializable {

    private int mImage, mDescription, mTitle;

    public InfoImage(int image, int title, int description){
        mImage =image;
        mDescription = description;
        mTitle = title;
    }

    public int getImage() {
        return mImage;
    }

    public void setImage(int image) {
        mImage = image;
    }

    public int getDescription() {
        return mDescription;
    }

    public void setDescription(int description) {
        mDescription = description;
    }

    public int getTitle() {
        return mTitle;
    }

    public void setTitle(int title) {
        mTitle = title;
    }
}
