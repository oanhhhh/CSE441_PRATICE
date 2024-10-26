package com.example.total_defference;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtA, edtB, edtKQ;
    Button btnYeuCau;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1 && resultCode == 2){
            int sum = data.getIntExtra("kq",0);
            edtKQ.setText("Tong 2 so la: "+sum);
        }
        if(requestCode == 1 && resultCode == 3){
            int sub = data.getIntExtra("kq",0);
            edtKQ.setText("Hieu 2 so la: "+sub);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        edtA = findViewById(R.id.edta);
        edtB = findViewById(R.id.edtb);
        edtKQ = findViewById(R.id.edtkq);
        btnYeuCau = findViewById(R.id.btnyeucau);

        btnYeuCau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SubActivity.class);
                int a = Integer.parseInt(edtA.getText()+"");
                int b = Integer.parseInt(edtB.getText()+"");
                intent.putExtra("soa",a);
                intent.putExtra("sob",b);
                startActivityForResult(intent,1);
            }
        });

    }
}