package com.example.simpcameraapp;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import android.Manifest;
import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.content.PackageManagerCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {
    private static final int CAMERA_PERMISSON_CODE = 100;
    private static final int CAMERA_REQUETS_CODE = 101;
    ImageView imgCamera;
    ImageButton btnTakeCapture;
    //Button btnTakeCapture;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        btnTakeCapture = findViewById(R.id.btnTakeCapture);
        imgCamera = findViewById(R.id.imageView);

        btnTakeCapture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkPermissionAndOnCamera();
            }
        });
    }

    private void checkPermissionAndOnCamera() {
        // Kiem ra quyen try cap camera
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            // Neu chua co quyen, yeu cau quyen truy cap
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA}, CAMERA_PERMISSON_CODE);
        } else {
            //Neu da co quyen, mo ung dung Camera
            openCamera();
        }
    }

    private void openCamera() {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUETS_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResult) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResult);
        if (requestCode == CAMERA_PERMISSON_CODE) {
            if (grantResult.length > 0 && grantResult[0] == PackageManager.PERMISSION_GRANTED) {
                //Nguoi dung da cap quyen, mo Camera
                openCamera();
            } else {
                //Nguoi dung u choi cap quyen, hien thi thong bao
                Toast.makeText(this, "Ung dung can quyen truy cap Camera de chup anh.", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == CAMERA_REQUETS_CODE && resultCode == RESULT_OK){
            //Nhan ket qua chup anh ve hien thi
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            imgCamera.setImageBitmap(imageBitmap);
        }
    }

}