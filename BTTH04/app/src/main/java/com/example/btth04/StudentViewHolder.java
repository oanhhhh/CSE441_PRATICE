package com.example.btth04;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    TextView txtName, txtMSSV, txtClass, txtScore;
    Button btnEdit, btnDelete;

    public StudentViewHolder(@NonNull View itemView) {
        super(itemView);
        txtName = itemView.findViewById(R.id.txtName);
        txtMSSV = itemView.findViewById(R.id.txtMSSV);
        txtClass = itemView.findViewById(R.id.txtClass);
        txtScore = itemView.findViewById(R.id.txtScore);
        btnEdit = itemView.findViewById(R.id.btnEdit);
        btnDelete = itemView.findViewById(R.id.btnDelete);
    }
}