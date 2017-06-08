package com.ufrpe.android.recifedoalto;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Christian Spinelli on 01/06/2017.
 */

public class MenuLocalsAdapter extends RecyclerView.Adapter<MenuLocalsAdapter.ViewHolder> {

    private final Activity mActivity;
    private final ArrayList<Local> mLocals;

    public MenuLocalsAdapter( ArrayList<Local> locals, Activity activity) {
        mActivity = activity;
        mLocals = locals;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View mView;
        public int mPostion;
        public ViewHolder(View v) {
            super(v);
            mView = v;
        }
    }


    @Override
    public MenuLocalsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mActivity.getLayoutInflater().inflate(R.layout.fragment_locals_menu,parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(final MenuLocalsAdapter.ViewHolder holder, int position) {
        holder.mPostion=position;

        int image = mLocals.get(position).getImageMap();
        String title = mActivity.getString(mLocals.get(position).getInfoImages().get(0).getTitle());

        ImageView img = (ImageView) holder.mView.findViewById(R.id.locals_menu_img);
        img.setImageResource(image);

        TextView titleView = (TextView) holder.mView.findViewById(R.id.menu_locals_title);
        titleView.setText(title);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = ImageActivity.newIntent(mActivity);
                intent.putExtra("image",mLocals.get(holder.mPostion).getImageMap());
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
        return mLocals.size();
    }

}
