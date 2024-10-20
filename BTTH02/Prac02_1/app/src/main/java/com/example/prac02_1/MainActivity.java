package com.example.prac02_1;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    TextView txtNoResult;
    TextView txtMess;
    private EditText edtID, edtName, edtBD, edtSalary;
    private StaffViewModel staffViewModel;
    private StaffAdapter staffAdapter;
    private RecyclerView rcv;
    Button btnAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        txtNoResult = findViewById(R.id.txtNoresult);
        txtMess = findViewById(R.id.txtMess);
        edtID = findViewById(R.id.edtID);
        edtName = findViewById(R.id.edtName);
        edtBD = findViewById(R.id.edtBD);
        edtSalary = findViewById(R.id.edtSalary);
        btnAdd = findViewById(R.id.btnAdd);
        rcv = findViewById(R.id.rcv);


        rcv.setLayoutManager(new LinearLayoutManager(this));

        staffViewModel = new ViewModelProvider(this).get(StaffViewModel.class);
        staffViewModel.getStaffList().observe(this, new Observer<List<Staff>>() {
            @Override
            public void onChanged(List<Staff> staff) {

                staffAdapter = new StaffAdapter(staff);
                rcv.setAdapter(staffAdapter);
                //updateUI(staff);
            }
        });
//        staffViewModel.getStaffList().observe(this, staff -> {
//            staffAdapter.notifyDataSetChanged();
//        });

        staffViewModel.message().observe(this, message -> {
            txtMess.setText(message);
        });
        TextWatcher inputWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                staffViewModel.checkInput(
                        edtID.getText().toString(),
                        edtName.getText().toString(),
                        edtBD.getText().toString(),
                        edtSalary.getText().toString()
                );
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int after) {
                staffViewModel.checkInput(
                    edtID.getText().toString(),
                    edtName.getText().toString(),
                    edtBD.getText().toString(),
                    edtSalary.getText().toString()
                );
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };

        edtID.addTextChangedListener(inputWatcher);
        edtName.addTextChangedListener(inputWatcher);
        edtBD.addTextChangedListener(inputWatcher);
        edtSalary.addTextChangedListener(inputWatcher);


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id = edtID.getText().toString();
                String name = edtName.getText().toString();
                String bd= edtBD.getText().toString();
                String salary= edtSalary.getText().toString();

//                if(!id.isEmpty() && !name.isEmpty() && !bd.isEmpty() && !salary.isEmpty()){
//                    Staff staff = new Staff(id, name, bd, salary);
//                    staffViewModel.addStaff(staff);
//                }
                Staff staff = new Staff(id, name, bd, salary);
                staffViewModel.addStaff(staff);


            }
        });

    }

//    private void updateUI(List<Staff> staff) {
//        if(staff.isEmpty()){
//            txtNoResult.setVisibility(View.VISIBLE);
//            rcv.setVisibility(View.GONE);
//        }
//        else {
//            txtNoResult.setVisibility(View.GONE);
//            rcv.setVisibility(View.VISIBLE);
//        }
//    }

}