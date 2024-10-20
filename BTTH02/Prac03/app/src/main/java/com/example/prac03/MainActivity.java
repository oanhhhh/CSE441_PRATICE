package com.example.prac03;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.prac03.Country;
import com.example.prac03.CountryAdapter;
import com.example.prac03.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Country> countries;
    private RecyclerView rcvcountries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        countries = new ArrayList<Country>();
        countries.add(new Country(R.drawable.china, "China", "Beijing", "1,411 million people", "9,596,961 Km²", "148 people/Km²", "18.47%"));
        countries.add(new Country(R.drawable.us, "United States", "Washington, D.C.", "331 million people", "9,525,067 Km²", "35 people/Km²", "4.27%"));
        countries.add(new Country(R.drawable.indonesia, "Indonesia", "Jakarta", "273 million people", "1,904,569 Km²", "143 people/Km²", "3.61%"));
        countries.add(new Country(R.drawable.pakistan, "Pakistan", "Islamabad", "225 million people", "881,913 Km²", "255 people/Km²", "2.78%"));
        countries.add(new Country(R.drawable.nigeria, "Nigeria", "Abuja", "206 million people", "923,768 Km²", "223 people/Km²", "2.60%"));
        countries.add(new Country(R.drawable.brazil, "Brazil", "Brasília", "213 million people", "8,515,767 Km²", "25 people/Km²", "4.92%"));
        countries.add(new Country(R.drawable.bangladesh, "Bangladesh", "Dhaka", "166 million people", "147,570 Km²", "1,126 people/Km²", "1.93%"));
        rcvcountries = (RecyclerView) findViewById(R.id.rcvcountries);
        rcvcountries.setAdapter(new CountryAdapter(countries,this));
        rcvcountries.setLayoutManager(new LinearLayoutManager(this));
        rcvcountries.setHasFixedSize(true);
    }
}