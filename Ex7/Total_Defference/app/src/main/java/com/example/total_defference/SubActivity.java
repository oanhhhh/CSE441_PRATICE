package com.example.total_defference;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SubActivity extends AppCompatActivity {
    EditText edtAA, edtBB;
    Button btnTong, btnHieu;
    Intent intent;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        edtAA = findViewById(R.id.edtaa);
        edtBB = findViewById(R.id.edtbb);
        btnTong = findViewById(R.id.btntong);
        btnHieu = findViewById(R.id.btnhieu);

        //Nhan intent
        intent = getIntent();
        //Lay du lieu tu intent
        int a = intent.getIntExtra("soa",0);
        int b = intent.getIntExtra("sob",0);
        edtAA.setText(a+"");
        edtBB.setText(b+"");

        btnTong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = a + b;
                intent.putExtra("kq",sum);
                setResult(2,intent);
                finish();
            }
        });

        btnHieu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sub = a - b;
                intent.putExtra("kq",sub);
                setResult(3,intent);
                finish();
            }
        });
    }
}
