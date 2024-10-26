package com.example.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edtten, edtchieucao, edtcannang , edtBMI, edtChuanDoan;
    Button btnBMI;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtten = findViewById(R.id.edtten);
        edtchieucao = findViewById(R.id.edtchieucao);
        edtcannang = findViewById(R.id.edtcannang);
        btnBMI = findViewById(R.id.btnBMI);
        edtBMI = findViewById(R.id.edtBMI);
        edtChuanDoan = findViewById(R.id.edtChuanDoan);

        btnBMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double H=Double.parseDouble(edtchieucao.getText()+"");
                double W=Double.parseDouble(edtcannang.getText()+"");
                double BMI=W/Math.pow(H,2);
                String chandoan="";
                if(BMI<18){
                    chandoan="Ban gay";
                }
                else if (BMI<=24.9) {
                    chandoan="Ban binh thuong";
                }
                else if (BMI<=29.9) {
                    chandoan="Ban beo phi do 1";
                }
                else if (BMI<=34.9) {
                    chandoan="Ban beo phi do 2";
                }
                else {
                    chandoan="Ban bao phi do 3";
                }
                DecimalFormat dcf = new DecimalFormat("#.0");
                edtBMI.setText(dcf.format(BMI));
                edtChuanDoan.setText(chandoan);
            }});


    }
}