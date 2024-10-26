package com.example.note;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayList<String> arraywork;
    ArrayAdapter<String>  arrAdapter;
    EditText edtWork, edtHour, edtMin;
    TextView txtDate;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        edtWork = findViewById(R.id.edtwork);
        edtHour = findViewById(R.id.edthour);
        edtMin  = findViewById(R.id.edtmi);
        btnAdd = findViewById(R.id.btnadd);
        lv= findViewById(R.id.lvnote);
        txtDate = findViewById(R.id.txtdate);

    //K su dung du lieu co dinh
    // vi du lieu cua Listview duoc cap nhat trong qua trinh chay
    //KHai bao mang ArrayList kieu String rong
        arraywork = new ArrayList<>();
    //Khai bao ArrayAdapter, dua mang du lieu vao ArrayAdapter
        arrAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arraywork);
    //Dua Adapter co du lieu len Listview
        lv.setAdapter(arrAdapter);
    //Lay ngay gio he thong
        Date currentDate = Calendar.getInstance().getTime();
    //Format theo dinh dang dd/mm/yy
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("dd/MM/yy");
    // Hien thi len TextView
        txtDate.setText("Hom nay: "+simpleDateFormat.format(currentDate));
    //handle event
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //Neu 1 trong 3 Edit Text k co noi dung thi hien len thong bao bang hop thoai Dialog
                if(edtWork.getText().toString().equals("") || edtHour.getText().toString().equals("") || edtMin.getText().toString().equals("")){
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Info missing");
                    builder.setMessage("Please enter all information of the work");
                    builder.setPositiveButton("Continute", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            builder.show();
                        }
                    });
                }
            // Lay noi dung cong viec va thoi gian ra tu Edit Text va dua vao mang arraywork, cap nhat lai Adapter
                else {
                    String str = edtWork.getText().toString()+" - "+edtHour.getText().toString()+":"+edtMin.getText().toString();
                    //De them du lieu cho ListView, chung ta can 2 buoc:
                    //Cap nhat them du lieu cho mang
                    arraywork.add(str);  //Xoa: arraywork.remove(i);
                    //Cap nhat lai Adapter
                    arrAdapter.notifyDataSetChanged();
                    edtWork.setText("");
                    edtHour.setText("");
                    edtMin.setText("");
                }
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    arraywork.remove(i);
                    arrAdapter.notifyDataSetChanged();
            }
        });

    }
}