package com.example.project_cal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtKQ;
    Button btncong, btntru, btnnhan, btnchia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtKQ = findViewById(R.id.edtKq);
        btncong = findViewById(R.id.btncong);
        btnchia = findViewById(R.id.btnchia);
        btntru  = findViewById(R.id.btntru);
        btnnhan = findViewById(R.id.btnnhan);

        btncong.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt("0"+edtA.getText());
                int b = Integer.parseInt("0"+edtB.getText());
                edtKQ.setText("a + b = "+(a+b));
            }
        });

        btntru.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt("0"+edtA.getText());
                int b = Integer.parseInt("0"+edtB.getText());
                edtKQ.setText("a - b = "+(a-b));
            }
        });

        btnnhan.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt("0"+edtA.getText());
                int b = Integer.parseInt("0"+edtB.getText());
                edtKQ.setText("a * b = "+(a*b));
            }
        });

        btnchia.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                int a = Integer.parseInt("0"+edtA.getText());
                int b = Integer.parseInt("0"+edtB.getText());
                edtKQ.setText("a : b = "+(a/b));
            }
        });

    }
}4