package com.example.btth04;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddStudentActivity extends AppCompatActivity {
    private EditText edtName, edtMSSV, edtClass, edtScore;
    private Button btnAdd;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        edtName = findViewById(R.id.edtName);
        edtMSSV = findViewById(R.id.edtMSSV);
        edtClass = findViewById(R.id.edtClass);
        edtScore = findViewById(R.id.edtScore);
        btnAdd = findViewById(R.id.btnAdd);
        databaseReference = FirebaseDatabase.getInstance().getReference("sinhvien");

        btnAdd.setOnClickListener(v -> addStudent());
    }

    private void addStudent() {
        String hoten = edtName.getText().toString();
        String mssv = edtMSSV.getText().toString();
        String lop = edtClass.getText().toString();
        double diem;

        if (hoten.isEmpty() || mssv.isEmpty() || lop.isEmpty() || edtScore.getText().toString().isEmpty()) {
            Toast.makeText(this, "Vui lòng điền đầy đủ thông tin", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            diem = Double.parseDouble(edtScore.getText().toString());
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Điểm phải là số", Toast.LENGTH_SHORT).show();
            return;
        }

        Student student = new Student(hoten, mssv, lop, diem);
        databaseReference.child(mssv).setValue(student)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        Toast.makeText(this, "Thêm sinh viên thành công", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(this, "Thêm sinh viên thất bại", Toast.LENGTH_SHORT).show();
                    }
                });
    }
}