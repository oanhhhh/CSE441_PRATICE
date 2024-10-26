package com.example.customgridview;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class ImageAdapter extends ArrayAdapter<Image> {
    Activity context;
    ArrayList<Image> myArray = null;
    int LayoutId;

//    Constructor nay dung de khoi tao cac gia tri tu ManiAcitity truyen vao
//    @param context: la Activity tu Main
//    @param layoutId; La layout custom do ta tao (listitem.xml)
//    @param arr: Danh sach doi tuong truyen tu Main

    public ImageAdapter(Activity context, int LayoutId, ArrayList<Image> arr){
        super(context,LayoutId,arr);
        this.context = context;
        this.LayoutId = LayoutId;
        this.myArray = arr;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        convertView = inflater.inflate(LayoutId,null);
        final  Image myimage = myArray.get(position);
        // Dong lenh lay ImageView ra de hien thi hinh anh
        final ImageView imgitem = (ImageView)convertView.findViewById(R.id.imageView1);
        imgitem.setImageResource(myimage.getImg());
        //dong lenh lay TextView ra de hien thi ten Anh
        final TextView myname = (TextView)convertView.findViewById(R.id.textView1);
        myname.setText(myimage.getName());
        return convertView;
    }
}
