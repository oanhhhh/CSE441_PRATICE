package com.example.phonelist;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        tv = findViewById(R.id.tv);
        // Khoi tao du lieu cho mang arr( data sourceZ)
        final String arr[] = {"Iphone 7", "Samsung Galaxy S7", "Nokia Lumia 730", "Sony Xperia XZ","HTC One E9"};
        // Khai bao Adapter va gan Data sourve va ArrayAdapter
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,arr);
        // Khai bao List view va dua Adapter va List View
        ListView lv1 = findViewById(R.id.lv1);
        lv1.setAdapter(adapter);
        // Viet su kien khi Click vao mot dong su kien ListView
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int i, long arg3){
                tv.setText("Vi tri "+i+" : "+arr[i]);
            }
        });

    }
}