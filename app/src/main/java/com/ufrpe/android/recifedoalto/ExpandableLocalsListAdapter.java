package com.ufrpe.android.recifedoalto;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.vstechlab.easyfonts.EasyFonts;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Christian Spinelli on 13/07/2017.
 */

public class ExpandableLocalsListAdapter extends BaseExpandableListAdapter {
    private Activity mActivity;
    private ArrayList<Area> mAreas;


    public ExpandableLocalsListAdapter(Activity activity, ArrayList<Area> areas){
        mActivity = activity;
        mAreas = areas;
    }

    @Override
    public int getGroupCount() {
        return mAreas.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mAreas.get(groupPosition).getLocals().size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mAreas.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mAreas.get(groupPosition).getLocals().get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater inflater = mActivity.getLayoutInflater();
        if(convertView == null){
            convertView = inflater.inflate(R.layout.fragment_locals_item,parent,false);
        }

        String itemText = mActivity.getString(mAreas.get(groupPosition).getTitle());
        TextView textView = (TextView) convertView.findViewById(R.id.locals_item);
        textView.setTypeface(EasyFonts.robotoLight(mActivity.getApplicationContext()));
        textView.setText(itemText);


        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater inflater = mActivity.getLayoutInflater();
        if(convertView == null){
            convertView = inflater.inflate(R.layout.fragment_locals_subitem,parent,false);
        }

        final String subItemText = mActivity.getString(mAreas.get(groupPosition).getLocals()
                .get(childPosition).getInfoImages().get(0).getTitle());

        final int subItemIcon = mAreas.get(groupPosition).getLocals().get(childPosition).getIconList();

        final int localPosition = mAreas.get(groupPosition).getLocals()
                .get(childPosition).getInfoImages().get(0).getLocalPosition();

        final Local local = mAreas.get(groupPosition).getLocals().get(childPosition);

        final TextView textView = (TextView) convertView.findViewById(R.id.locals_subitem);

        final ImageView imageView = (ImageView) convertView.findViewById(R.id.subitem_icon);

        imageView.setImageResource(subItemIcon);

        textView.setText(subItemText);
        textView.setTypeface(EasyFonts.robotoLight(mActivity.getApplicationContext()));
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = InfoPagerActivity.newIntent(mActivity);
                intent.putExtra("images",local.getInfoImages());
                LocalSession.get().setLocal(local);
                mActivity.startActivity(intent);
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
