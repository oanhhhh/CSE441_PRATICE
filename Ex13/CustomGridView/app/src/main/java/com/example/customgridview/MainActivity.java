package com.example.customgridview;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static String[] arrayName = {"Image 1","Image 2","Imgage 3","Image 4","Image 5","Image 6","Image 7","Image 8","Image 9","Image 10","Image 11","Image 12"};
    public static int[] imageName = {R.drawable.img1,R.drawable.img2,R.drawable.img3,R.drawable.img4,R.drawable.img5,R.drawable.img6,R.drawable.img7,R.drawable.img8,R.drawable.img9,R.drawable.img10,R.drawable.img11,R.drawable.img12};
    GridView gridViewDemo;
    //Su dung MyArrayAdapter thay the ArrayAdapter
    ImageAdapter adapterImage;
    ArrayList<Image> arrimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridViewDemo = (GridView) findViewById(R.id.grid1);
        arrimage = new ArrayList<Image>();
    // Khoi tao doi tuong adapter va gan Data source
        adapterImage = new ImageAdapter(MainActivity.this,R.layout.listitem,arrimage);
        gridViewDemo.setAdapter(adapterImage);

        //gan Adapter vao GridView
        //Duyet danh sach mang du lieu
        for(int i=0;i<imageName.length; i++){
            Image myimage = new Image();
            myimage.setImg(imageName[i]);
            myimage.setName(arrayName[i]);
            arrimage.add(myimage);

            adapterImage.notifyDataSetChanged();
        }
        gridViewDemo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent1 = new Intent(MainActivity.this, SubActivity.class);
                //Khai bao bundle va dua lieu vao Bundle, tham so i chua vi tri cua phan tu chung ta click trong gridview
                Bundle bundle = new Bundle();
                bundle.putInt("TITLE",i);
                intent1.putExtras(bundle);
                startActivity(intent1);


            }
        });
    }
}