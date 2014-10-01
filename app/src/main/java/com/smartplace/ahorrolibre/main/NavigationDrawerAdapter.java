package com.smartplace.ahorrolibre.main;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.makeramen.RoundedImageView;
import com.smartplace.ahorrolibre.R;

import java.util.ArrayList;

/**
 * Created by Roberto on 23/07/2014.
 */
public class NavigationDrawerAdapter extends BaseAdapter {
    private ArrayList mArrayList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public NavigationDrawerAdapter(Context context, ArrayList arrayList) {
        mArrayList = arrayList;
        mLayoutInflater = LayoutInflater.from(context);
        mContext =context;
    }

    @Override
    public int getCount() {
        return mArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return mArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        final Holder holder;

        if (convertView == null) {
            convertView = mLayoutInflater.inflate(R.layout.list_item_drawer, null);
            holder = new Holder();
            holder.drawerImage = (RoundedImageView)convertView.findViewById(R.id.image_drawer_item);
            holder.drawerName = (TextView) convertView.findViewById(R.id.name_drawer_item);
            convertView.setTag(holder);
        }else {
            holder = (Holder) convertView.getTag();
        }
        final NavigationDrawerItem navItem = (NavigationDrawerItem) mArrayList.get(position);
        holder.drawerImage.setImageDrawable(navItem.getIcon());
        holder.drawerName.setText(navItem.getName());

        Typeface titleFont= Typeface.createFromAsset(mContext.getAssets(), "fonts/OpenSansLight.ttf");
        holder.drawerName.setTypeface(titleFont);
        return convertView;
    }
    static class Holder {
        RoundedImageView drawerImage;
        TextView drawerName;
    }
}
