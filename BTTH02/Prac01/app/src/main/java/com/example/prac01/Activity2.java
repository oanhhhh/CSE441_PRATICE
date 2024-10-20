package com.example.prac01;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class Activity2 extends AppCompatActivity {
    EditText edtName, edtGPA;
    Button btnSub;

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Kiểm tra nếu nút quay lại được chọn
        if (item.getItemId() == android.R.id.home) {
            onBackPressed(); // Quay lại Activity trước đó
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity2);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        edtName =findViewById(R.id.edtName);
        edtGPA = findViewById(R.id.edtGPA);
        btnSub = findViewById(R.id.btnSub);
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String gpa = edtGPA.getText().toString();
                Intent resultIntent = new Intent();
                resultIntent.putExtra("name", name);
                resultIntent.putExtra("gpa",gpa);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }

}
