package com.example.gridview;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    // Dung mang 1 chieu hoac Array List de luu mot so du lieu
    String arr[] = {"Ipad","Iphone","New Ipad","SamSung","Nokia","Sony Ericson","LG","Q-Mobile","HTC","Blackberry","G Phone","FPT - Phone", "HK Phone"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Doi tuong nay dung de hien thi phan tu duoc chon trong Grid View
        final TextView selection = (TextView) findViewById(R.id.selection);
        final GridView gv = (GridView) findViewById(R.id.gridView1);
        //Gan datasource vao ArrayAdapter
        ArrayAdapter<String>da = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                arr
        );
        //ganDatasource vao va GridView
        gv.setAdapter(da);
        //Thiet lap su kien cho GridView
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                selection.setText(arr[i]);
            }
        });
    }
}