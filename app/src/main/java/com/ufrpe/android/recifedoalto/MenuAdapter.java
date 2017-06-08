package com.ufrpe.android.recifedoalto;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


/**
 * Created by Christian Spinelli on 31/05/2017.
 */

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {

    private final ArrayList<Area> mAreas;
    private final Activity mActivity;

    public MenuAdapter(ArrayList<Area> menuImages, Activity activity) {
        mAreas = menuImages;
        mActivity = activity;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View mView;
        public int mPosition;
        public ViewHolder(View v) {
            super(v);
            mView = v;
        }
    }


    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mActivity.getLayoutInflater().inflate(R.layout.fragment_menu,parent,false);

        ViewHolder vh = new ViewHolder(view);

        return vh;
    }

    @Override
    public void onBindViewHolder(final MenuAdapter.ViewHolder holder, int position) {
        holder.mPosition = position;
        int image = mAreas.get(position).getImg();
        String title = mActivity.getString(mAreas.get(position).getTitle());

        ImageView img = (ImageView) holder.mView.findViewById(R.id.menu_img);
        img.setImageResource(image);

        TextView titleView = (TextView) holder.mView.findViewById(R.id.menu_title);
        titleView.setText(title);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = MenuLocalsFragmentActivity.newIntent(mActivity);
                intent.putExtra("area",mAreas.get(holder.mPosition).getTitle());
                Log.d("POSITION MENU IMAGE: ",""+holder.mPosition);
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
        return mAreas.size();
    }

}
