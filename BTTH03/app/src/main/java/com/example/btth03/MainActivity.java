package com.example.btth03;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Student> students;
    private RecyclerView rcv;
    private StudentAdapter adapter;
    ArrayList<String> id = new ArrayList<>();
    ArrayList<String> firstName = new ArrayList<>();
    ArrayList<String> midName = new ArrayList<>();
    ArrayList<String> lastName = new ArrayList<>();
    ArrayList<String> gpa = new ArrayList<>();
    ArrayList<String> gender = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        rcv = findViewById(R.id.rcv);
        rcv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


        try{
            JSONObject obj = new JSONObject(parseJson());
            JSONArray studentArr = obj.getJSONArray("Students");

            for (int i=0; i<studentArr.length();i++) {
                JSONObject studentDetail = studentArr.getJSONObject(i);
                id.add(studentDetail.getString("id"));
                gpa.add(studentDetail.getString("gpa"));
                gender.add(studentDetail.getString("gender"));

                JSONObject fullName = studentDetail.getJSONObject("full name");
                firstName.add(fullName.getString("first"));
                midName.add(fullName.getString("mid"));
                lastName.add(fullName.getString("last"));
            }

//                    students.add(new Student(null,studentDetail.getString("id"),
//                            studentDetail.getString("fullname"),
//                            studentDetail.getString("fullname"),));
//                    )
        } catch (JSONException e) {
            e.printStackTrace();
        }

        StudentAdapter studentAdapter = new StudentAdapter(MainActivity.this, id, firstName,midName,lastName,gpa,gender);
        rcv.setAdapter(studentAdapter);

//        rcv =(RecyclerView) findViewById(R.id.rcv);
//        rcv.setLayoutManager(new LinearLayoutManager(this));
//
//        AssetManager  assetManager = getAssets();
//        students = parseJson(assetManager);
//
//        rcv.setAdapter(new StudentAdapter(students));
//        rcv.setHasFixedSize(true);
    }

    private String parseJson(){
        String json = null;
        try{
            InputStream in = getAssets().open("student.json");
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            in.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException e){
            e.printStackTrace();
            return null;
        }
        return json;

    }
}