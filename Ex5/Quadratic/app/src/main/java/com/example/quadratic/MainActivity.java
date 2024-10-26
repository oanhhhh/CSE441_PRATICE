package com.example.quadratic;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView txtResult;
    EditText edtA, edtB, edtC;
    Button btnContinue, btnResult, btnExit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtA = findViewById(R.id.edtA);
        edtB = findViewById(R.id.edtB);
        edtC = findViewById(R.id.edtC);
        btnContinue = findViewById(R.id.btnContinue);
        btnResult = findViewById(R.id.btnResult);
        btnExit = findViewById(R.id.btnExit);
        txtResult = findViewById(R.id.txtResult);
        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtA.setText("");
                edtB.setText("");
                edtC.setText("");
                edtA.requestFocus();
            }

        });

        btnResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sA = edtA.getText()+"";
                String sB = edtB.getText()+"";
                String sC = edtC.getText()+"";
                int a = Integer.parseInt(sA);
                int b = Integer.parseInt(sB);
                int c = Integer.parseInt(sC);
                String  kq ="";
                DecimalFormat dcf = new DecimalFormat("0.00");
                if(a == 0){
                    if(b == 0){
                        if(c == 0){
                            kq = "PT vo so nghiem";
                        }
                        else {
                            kq = "PT vo nghiem";
                        }
                    }
                    else {
                        kq="PT co mot nghiem x="+dcf.format(-c/b);
                    }
                }
                else {
                    double delta=b*b-a*c;
                    if(delta<0){
                        kq = "PT vo nghiem";
                    } else if (delta==0) {
                        kq = "PT co nghiem kep x1=x2="+dcf.format(-b/(2*a));
                    }
                    else {
                        kq="PT co 2 nghiem phan biet: x1="+dcf.format((-b+Math.sqrt(delta))/(2*a)) + "; x2="+dcf.format((-b-Math.sqrt(delta))/(2*a));
                    }
                }
                txtResult.setText(kq);
            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}