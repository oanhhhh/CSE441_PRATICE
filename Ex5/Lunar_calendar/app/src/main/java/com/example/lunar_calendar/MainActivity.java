package com.example.lunar_calendar;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btnConv;
    EditText edtSC, edtLC;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtSC = findViewById(R.id.edtSC);
        edtLC = findViewById(R.id.edtCL);
        btnConv = findViewById(R.id.btnConv);
        btnConv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String can="", chi="";
                int sc = Integer.parseInt(edtSC.getText().toString());
                switch (sc%10)
                {
                    case 0: can = "Canh";break;
                    case 1: can = "Tan";break;
                    case 2: can = "Nham";break;
                    case 3: can = "Quy";break;
                    case 4: can = "Giap";break;
                    case 5: can = "At";break;
                    case 6: can = "Binh";break;
                    case 7: can = "Dinh";break;
                    case 8: can = "Mau";break;
                    case 9: can = "Ki";break;
                }

                switch (sc%12)
                {
                    case 0: chi ="Than";break;
                    case 1: chi ="Dau";break;
                    case 2: chi ="Tuat";break;
                    case 3: chi ="Hoi";break;
                    case 4: chi ="Ti";break;
                    case 5: chi ="Suu";break;
                    case 6: chi ="Dan";break;
                    case 7: chi ="Mao";break;
                    case 8: chi ="Thin";break;
                    case 9: chi ="Ti.";break;
                    case 10: chi ="Ngo";break;
                    case 11: chi ="Mui";break;
                }
                edtLC.setText(can+" "+chi);
        }
        });
    }
}