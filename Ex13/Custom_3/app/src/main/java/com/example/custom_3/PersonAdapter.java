package com.example.custom_3;

import android.app.Activity;
import android.content.Context;
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

public class PersonAdapter extends ArrayAdapter<Person> {
    Activity context;
    int idLayout;
    ArrayList<Person> mPerson;

    public  PersonAdapter(Activity context, int idLayout, ArrayList<Person> mPerson){
        super(context,idLayout,mPerson);
        this.context = context;
        this.idLayout = idLayout;
        this.mPerson = mPerson;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater myInflactor = context.getLayoutInflater();
        convertView = myInflactor.inflate(idLayout, null);
        Person myperson = mPerson.get(position);

        TextView tvname = convertView.findViewById(R.id.tvname);
        TextView tvnum = convertView.findViewById(R.id.tvnum);

        tvname.setText(myperson.getId()+"-"+myperson.getName());
        tvnum.setText(myperson.getNumberphone());

        return convertView;
    }
}
