package com.example.call_sms;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.Manifest;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CallPhoneActivity extends AppCompatActivity {
    EditText edtCallPhone;
    ImageButton btnCall;
    Button btnBack1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_call_phone);

    edtCallPhone = findViewById(R.id.edtcallphone);
    btnCall = findViewById(R.id.btncall);
    btnBack1 = findViewById(R.id.btnback1);

    btnCall.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intentCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+edtCallPhone.getText().toString())  );
            //Yeu cau nguoi dung dong y quyen truy cap vao tinh nang goi dien
            if(ActivityCompat.checkSelfPermission(CallPhoneActivity.this,Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
                ActivityCompat.requestPermissions(CallPhoneActivity.this, new String[]{Manifest.permission.CALL_PHONE},1);
                return;
            }
            startActivity(intentCall);
        }
    });


    btnBack1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    });
    }
}