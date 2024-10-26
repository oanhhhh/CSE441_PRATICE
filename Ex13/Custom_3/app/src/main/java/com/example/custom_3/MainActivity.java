package com.example.custom_3;

import android.os.Bundle;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String id[] = {"1","2","3","4"};
    String name[] = {"Nguyễn Văn Name","Trần Văn Tú","Nguyễn Thị Lan","Nguyễn Kim Ngân"};
    String numberphone[] = {"1234567890","0345181111","0344116342","0879156599","0974933132","0395251009"};

    ArrayList<Person> mPerson;
    PersonAdapter personAdapter;
    ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = findViewById(R.id.lv);
        mPerson = new ArrayList<>();
        for(int i=0;i<id.length;i++){
            mPerson.add(new Person(id[i],name[i],numberphone[i]));
        }
        personAdapter = new PersonAdapter(this,R.layout.activity_item,mPerson);
        lv.setAdapter(personAdapter);

    }
}