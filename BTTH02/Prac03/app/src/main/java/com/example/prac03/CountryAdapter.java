package com.example.prac03;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CountryAdapter extends RecyclerView.Adapter<CountryAdapter.CountryViewHolder> {
    //Nhan du lieu truyen tu ngoai vao
    private List<Country> countries;
    private Context context;


    //Constructer de truyen du lieu Adapter
    public CountryAdapter(List<Country> countries,Context context) {
        this.countries = countries;
        this.context = context;
    }
    //Tao ViewHolder moi khi can thiet
        @NonNull
        @Override
        public CountryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false);
            return new CountryViewHolder(itemView);
        }
    //Gan du lieu vao ViewHolder tai vi tri cu the
    @Override
    public void onBindViewHolder(@NonNull CountryViewHolder holder, int position) {
        Country country = countries.get(position);
        holder.imgFlag.setImageResource(country.getFlag());
        holder.txtName.setText(country.getCountryName());
        holder.txtCapital.setText(country.getCountryCapital());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context , CountryDetailActivity.class);
                intent.putExtra("flag",country.getFlag());
                intent.putExtra("country_name", country.getCountryName());
                intent.putExtra("country_capital", country.getCountryCapital());
                intent.putExtra("country_population", country.getCountryPopulation());
                intent.putExtra("country_area", country.getCountryArea());
                intent.putExtra("country_density", country.getCountryDensity());
                intent.putExtra("country_world_share", country.getGetCountryWorldShare());
                context.startActivity(intent);
            }
        });
    }

        @Override
        public int getItemCount() {
            return countries.size();
        }

    //Dinh nghia ViewHolder
    public static class CountryViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFlag;
        TextView txtName, txtCapital;

        public CountryViewHolder(View itemView) {
            super(itemView);
            imgFlag = itemView.findViewById(R.id.imgflag);
            txtName = itemView.findViewById(R.id.txtname);
            txtCapital = itemView.findViewById(R.id.txtcapital);
        }
    }
}




