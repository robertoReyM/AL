package com.smartplace.ahorrolibre.savings;

import android.content.Context;
import android.graphics.Typeface;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.smartplace.ahorrolibre.R;

import java.util.ArrayList;

/**
 * Created by Roberto on 13/08/2014.
 */
public class SavingsListAdapter extends BaseAdapter {
    /**
     * Objects to reference xml
     */
    public ArrayList mArrayList;
    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public SavingsListAdapter(Context context, ArrayList arrayList) {
        //save references to local variables
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
        return Long.valueOf(((SavingsItem) mArrayList.get(i)).getId());
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        final Holder holder;
        if(convertView==null){
            holder= new Holder();
            convertView = mLayoutInflater.inflate(R.layout.list_item_saving, null);
            holder.savingName = (TextView)convertView.findViewById(R.id.name_saving);
            holder.headerAdmin = (TextView)convertView.findViewById(R.id.header_admin);
            holder.adminUser = (TextView)convertView.findViewById(R.id.txt_name_admin);
            holder.startDate = (TextView)convertView.findViewById(R.id.txt_start_date);
            holder.headerStartDate = (TextView)convertView.findViewById(R.id.header_start_date);
            holder.endDate = (TextView)convertView.findViewById(R.id.txt_end_date);
            holder.headerEndDate = (TextView)convertView.findViewById(R.id.header_end_date);
            holder.deliveryDate = (TextView)convertView.findViewById(R.id.txt_delivery_date);
            holder.headerDelivery = (TextView)convertView.findViewById(R.id.header_delivery);
            holder.missingDays = (TextView)convertView.findViewById(R.id.txt_missing_days);
            holder.headerMissingDays = (TextView)convertView.findViewById(R.id.header_missing_days);
            convertView.setTag(holder);


        }else{
            holder = (Holder)convertView.getTag();
        }
        final SavingsItem savingsItem = (SavingsItem)mArrayList.get(position);

        Typeface titleFont= Typeface.createFromAsset(mContext.getAssets(), "fonts/OpenSans-Bold.ttf");
        holder.savingName.setTypeface(titleFont);
        titleFont= Typeface.createFromAsset(mContext.getAssets(), "fonts/OpenSansLight.ttf");
        holder.headerAdmin.setTypeface(titleFont);
        holder.adminUser.setTypeface(titleFont);
        holder.startDate.setTypeface(titleFont);
        holder.headerStartDate.setTypeface(titleFont);
        holder.endDate.setTypeface(titleFont);
        holder.headerEndDate.setTypeface(titleFont);
        holder.deliveryDate.setTypeface(titleFont);
        holder.headerDelivery.setTypeface(titleFont);
        holder.missingDays.setTypeface(titleFont);
        holder.headerMissingDays.setTypeface(titleFont);


        holder.savingName.setText(savingsItem.getName());
        holder.adminUser.setText(savingsItem.getAdminUser());
        holder.startDate.setText(savingsItem.getStartDate());
        holder.endDate.setText(savingsItem.getEndDate());
        holder.deliveryDate.setText(savingsItem.getDeliveryDate());
        holder.missingDays.setText(savingsItem.getMissingDays());
        return convertView;
    }

    static class Holder {


        TextView savingName;
        TextView headerAdmin;
        TextView adminUser;
        TextView headerStartDate;
        TextView startDate;
        TextView headerEndDate;
        TextView endDate;
        TextView headerDelivery;
        TextView deliveryDate;
        TextView headerMissingDays;
        TextView missingDays;
    }
}
