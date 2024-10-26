package com.example.customlistview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String namephone[] = {"Điện thoại Iphone 12", "Điện thoại Samsung S20", "Điện thoại VivoS1", "Điện thoại Bphone", "Điện thoại Oppo 5", "Điện thoại VSmart"};
    String pricephone[] = {"6000000","7000000","5000000","6000000","5000000","2000000","6000000","7000000","5000000","6000000","5000000","2000000"};
    int imgphone[] = {R.drawable.ip12, R.drawable.samsungs20, R.drawable.vivos1, R.drawable.bphone, R.drawable.oppo, R.drawable.vsmart};
    ArrayList<Phone> mListPhone; //Khai bao mang chinh
    PhoneAdapter phoneAdapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        mListPhone = new ArrayList<>();
        for (int i = 0; i<namephone.length;i++){
            mListPhone.add(new Phone(imgphone[i],namephone[i],pricephone[i]));
        }

        phoneAdapter = new PhoneAdapter(this,R.layout.layout_listview, mListPhone);
        lv.setAdapter(phoneAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Intent mintent = new Intent(MainActivity.this, SubActivity.class);
                mintent.putExtra("namephone",namephone[position]);
                startActivity(mintent);
            }
        });
    }
}