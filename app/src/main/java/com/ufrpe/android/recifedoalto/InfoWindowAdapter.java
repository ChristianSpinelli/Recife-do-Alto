package com.ufrpe.android.recifedoalto;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 02/06/2017.
 */

public class InfoWindowAdapter extends RecyclerView.Adapter<InfoWindowAdapter.ViewHolder> {
    private final Activity mActivity;
    private final ArrayList<InfoImage> mImages;


    public InfoWindowAdapter(Activity activity, ArrayList<InfoImage> images) {
        mActivity = activity;
        mImages = images;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View mView;
        public ViewHolder(View v) {
            super(v);
            mView = v;
        }
    }

    @Override
    public InfoWindowAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mActivity.getLayoutInflater().inflate(R.layout.fragment_info_window,parent,false);

        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(final InfoWindowAdapter.ViewHolder holder, int position) {
        int image = mImages.get(position).getImage();
        String description = mActivity.getString(mImages.get(position).getDescription());


        ImageView imageView = (ImageView) holder.mView.findViewById(R.id.img_info);
        TextView descriptionView = (TextView) holder.mView.findViewById(R.id.txt_info_description);
        TextView moreInfoView = (TextView) holder.mView.findViewById(R.id.txt_more_info);

        imageView.setImageResource(image);
        descriptionView.setText(description);

        moreInfoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = mImages.get(0).getLocalPosition();
                Intent intent = MapsActivity.newIntent(mActivity);
                intent.putExtra("position",position);
                mActivity.startActivity(intent);
            }
        });

    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }


}
