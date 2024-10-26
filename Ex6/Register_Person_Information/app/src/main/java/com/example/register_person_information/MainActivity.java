package com.example.register_person_information;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText edtTen, edtCMND, edtBosung;
    RadioButton radTc, radCd, radDh;
    CheckBox chkDocSach, chkDocBao, chkDocCoding;
    Button btnGuitt;
    RadioGroup group;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtTen = findViewById(R.id.edtTen);
        edtCMND = findViewById(R.id.edtCMND);
        edtBosung = findViewById(R.id.edtBosung);

        radTc = findViewById(R.id.radtc);
        radCd = findViewById(R.id.radcd);
        radDh = findViewById(R.id.raddh);
        chkDocBao = findViewById(R.id.chkdocbao);
        chkDocSach = findViewById(R.id.chkdocsach);
        chkDocCoding = findViewById(R.id.chkdoccoding);
        btnGuitt = findViewById(R.id.btnguitt);


        btnGuitt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                doShowInformation();
            }
        });

    }

    private void doShowInformation() {
    // Kiem ra ten hop le
        String ten = edtTen.getText().toString();
        ten=ten.trim();//Loai bo khoang trang dau va cuoi
        if(ten.length()<3){
            edtTen.requestFocus();
            edtTen.selectAll();//Chon toan bo van ban\
            Toast.makeText(this, " Tên phải >= ký tự ",Toast.LENGTH_LONG).show();
            return;
        }

    // Kiem tra CMND hop le
        String cmnd = edtCMND.getText().toString();
        cmnd=cmnd.trim();
        if(cmnd.length() != 9){
            edtCMND.requestFocus();
            edtCMND.selectAll();
            Toast.makeText(this,"CMND phải đúng 9 kí tự", Toast.LENGTH_LONG).show();
            return;
        }
    //Kiem tra bang cap
         String bang = "";
        group = findViewById(R.id.idgroup);
        int id=group.getCheckedRadioButtonId();//Tra ve ID cua
        if(id == -1){
            Toast.makeText(this, " Phải chọn bang cap",Toast.LENGTH_LONG).show();
            return;
        }
        RadioButton rad = findViewById(id);
        bang = rad.getText()+"";

    //Kiem tra so thích
        String sothich = "";
        if(chkDocBao.isChecked()){sothich+= chkDocBao.getText()+"\n";}
        if(chkDocSach.isChecked()){sothich+= chkDocSach.getText()+"\n";}
        if(chkDocCoding.isChecked()){sothich+= chkDocCoding.getText()+"\n";}
        String bosung=edtBosung.getText() +"";

        //Tao Diglog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(" Thông tin cá nhân");
        builder.setPositiveButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        String msg = ten+"\n";
        msg+= cmnd +"\n";
        msg+= bang + "\n";
        msg+= "__________________\n";
        msg+="Thông tin bổ sung:\n";
        msg+=bosung + "\n";
        msg+= "__________________\n";
        builder.setMessage(msg);
        builder.create().show();

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
        b.setTitle("Question");
        b.setMessage("Are you sure you want to exits?");
        b.setIcon(R.drawable.inform);
        b.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }});
        b.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        b.create().show();
    }
}