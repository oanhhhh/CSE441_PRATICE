package com.example.ex3;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edtFar, edtCel;
    Button btnFar, btnCel, btnClear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtFar = findViewById(R.id.edtFar);
        edtCel = findViewById(R.id.edtCel);
        btnFar  = findViewById(R.id.btnFar);
        btnCel = findViewById(R.id.btnCel);
        btnClear = findViewById(R.id.btnClear);

        btnFar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtCel.equals("")) {
                    // Hiển thị thông báo lỗi
                    Toast.makeText(MainActivity.this, "Please enter a value.", Toast.LENGTH_SHORT).show();
                }
                DecimalFormat dcf = new DecimalFormat("#.00");
                String doC = edtCel.getText()+"";

                double C = Double.parseDouble(doC);
                edtFar.setText(dcf.format(+C*1.8+32));
            }
        });
        btnCel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtCel.equals("")) {
                    // Hiển thị thông báo lỗi
                    Toast.makeText(MainActivity.this, "Please enter a value.", Toast.LENGTH_SHORT).show();// Dừng lại nếu rỗng
                }
                DecimalFormat dcc = new DecimalFormat("#.00");
                String doF = edtFar.getText()+"";

                double F = Double.parseDouble(doF);
                edtCel.setText(dcc.format(+(F-32)/1.8));
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtFar.setText("");
                edtCel.setText("");
            }
        });
        }
    }
