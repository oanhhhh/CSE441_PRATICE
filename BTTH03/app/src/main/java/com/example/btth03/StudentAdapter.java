package com.example.btth03;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.MyViewHolder>{
    Context ctx;
    ArrayList<String> id ;
    ArrayList<String> firstName;
    ArrayList<String> midName;
    ArrayList<String> lastName;
    ArrayList<String> gpa;
    ArrayList<String> gender;

    public StudentAdapter(Context ctx, ArrayList<String> id, ArrayList<String> firstName, ArrayList<String> midName, ArrayList<String> lastName, ArrayList<String> gpa, ArrayList<String> gender) {
        this.ctx = ctx;
        this.id = id;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.gpa = gpa;
        this.gender = gender;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvID.setText(id.get(position));
        holder.tvName.setText(firstName.get(position)+midName.get(position)+lastName.get(position)+"");
        holder.tvGPA.setText(gpa.get(position));
        if(gender.get(position).equals("Nam")){
            holder.imgAvatar.setImageResource(R.drawable.ic_male);
        }
        else {
            holder.imgAvatar.setImageResource(R.drawable.ic_female);
        }

    }

    @Override
    public int getItemCount() {
        return id.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imgAvatar;
        TextView tvID, tvName, tvGPA;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.imgstd);
            tvID = itemView.findViewById(R.id.tvid);
            tvName = itemView.findViewById(R.id.tvname);
            tvGPA = itemView.findViewById(R.id.tvgpa);
        }
    }
}

//public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
//    private List<Student> studentList;
//
//    public StudentAdapter(List<Student> studentList){
//        this.studentList = studentList;
//    }
//
//    @NonNull
//    @Override
//    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
//        return new StudentViewHolder(itemView);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
//        Student currentItem = studentList.get(position);
//        //holder.imgAvatar.setImageResource(currentItem.getAvatar());
//        holder.tvID.setText(currentItem.getId());
//        holder.tvName.setText(currentItem.getFullname().getFirstName()+" "+currentItem.getFullname().getMidName()+" "+currentItem.getFullname().getLastName());
//        holder.tvGPA.setText(currentItem.getGpa());
//
//        //Set hinh anh gioi tinh
//        if(currentItem.getGender().equals("Nam")){
//            holder.imgAvatar.setImageResource(R.drawable.ic_launcher_foreground);
//        }
//        else {
//            holder.imgAvatar.setImageResource(R.drawable.ic_launcher_foreground);
//        }
//    }
//
//    @Override
//    public int getItemCount() {
//        return studentList.size();
//    }
//
//    public static class StudentViewHolder extends RecyclerView.ViewHolder{
//        ImageView imgAvatar;
//        TextView tvID, tvName, tvGPA;
//
//        public StudentViewHolder(@NonNull View itemView) {
//            super(itemView);
//            imgAvatar = itemView.findViewById(R.id.imgstd);
//            tvID = itemView.findViewById(R.id.tvid);
//            tvName = itemView.findViewById(R.id.tvname);
//            tvGPA = itemView.findViewById(R.id.tvgpa);
//        }
//    }
//}
