package com.example.prac03;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CountryDetailActivity extends AppCompatActivity {
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed(); // Quay lại Activity trước
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);

        // Khởi tạo Toolbar
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // Hiện nút quay lại
        getSupportActionBar().setTitle(""); // Đặt tiêu đề trống, sẽ cập nhật sau



        ImageView countryFlag = findViewById(R.id.ivCountryImage);
        TextView countryNameTextView = findViewById(R.id.tvCountryNameDetail);
        TextView capitalTextView = findViewById(R.id.tvCapitalDetail);
        TextView populationTextView = findViewById(R.id.tvPopulationDetail);
        TextView areaTextView = findViewById(R.id.tvAreaDetail);
        TextView densityTextView = findViewById(R.id.tvDensityDetail);
        TextView worldShareTextView = findViewById(R.id.tvWorldShareDetail);

        Intent intent = getIntent();
        String countryName = intent.getStringExtra("country_name");
        String countryCapital = intent.getStringExtra("country_capital");
        String countryPopulation = intent.getStringExtra("country_population");
        String countryArea = intent.getStringExtra("country_area");
        String countryDensity = intent.getStringExtra("country_density");
        String countryWorldShare = intent.getStringExtra("country_world_share");
        int countryImageResId = intent.getIntExtra("flag", 0);

        countryNameTextView.setText(countryName);
        capitalTextView.setText(countryCapital);
        populationTextView.setText(countryPopulation);
        areaTextView.setText(countryArea);
        densityTextView.setText(countryDensity);
        worldShareTextView.setText(countryWorldShare);
        countryFlag.setImageResource(countryImageResId);

        // Cập nhật tiêu đề của Toolbar
        getSupportActionBar().setTitle(countryName);
    }
}
