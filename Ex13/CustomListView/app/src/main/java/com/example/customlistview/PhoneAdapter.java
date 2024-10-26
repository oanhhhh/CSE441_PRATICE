package com.example.customlistview;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class PhoneAdapter extends ArrayAdapter<Phone> {
    Activity context;
    int idlayout;
    ArrayList<Phone> mListPhone;

    public PhoneAdapter(Activity context,int idlayout, ArrayList<Phone> mListPhone) {
        super(context,idlayout, mListPhone);
        this.context = context;
        this.idlayout = idlayout;
        this.mListPhone = mListPhone;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater myInflactor = context.getLayoutInflater();
        convertView = myInflactor.inflate(idlayout,null);
        Phone myphone = mListPhone.get(position);

        // Ung voi moi thuoc tinh, ta thuc hien hai viec
            // Gan id
        ImageView imgphone = convertView.findViewById(R.id.imgphone);
        TextView txtnamephone = convertView.findViewById(R.id.txtnamephone);
        TextView txtpricephone = convertView.findViewById(R.id.txtpricephone);

            //Thiet lap du lieu
        imgphone.setImageResource(myphone.getImgphone());
        txtnamephone.setText(myphone.getNamephone());
        txtpricephone.setText("Gia ban: "+myphone.getPricephone());

        return convertView;
    }
}
