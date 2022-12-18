package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.model.Model;
import com.example.myapplication.model.Student;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        EditText nameEt = findViewById(R.id.addstudent_name_edittext);
        EditText idEt = findViewById(R.id.addstudent_id_edittext);
        EditText phoneEt = findViewById(R.id.addstudent_phone_edittext);
        EditText addressEt = findViewById(R.id.addstudent_address_edittext);
        CheckBox checkedCb = findViewById(R.id.addstudent_checked_cb);


        TextView messageTv = findViewById(R.id.addstudent_message);
        Button saveBtn = findViewById(R.id.addstudent_save_btn);
        Button cancelBtn = findViewById(R.id.addstudent_cancel_btn);

//        cancelBtn.setOnClickListener(view -> {
//            Intent intent = new Intent(this, .class);
//            startActivity(intent);
//        });

        saveBtn.setOnClickListener(view -> {
            String name = nameEt.getText().toString();
            String id = idEt.getText().toString();
            String phone = phoneEt.getText().toString();
            String address = addressEt.getText().toString();
            boolean checked = checkedCb.isChecked();
            Student st = new Student(name,id,phone,address,checked);
            Model.instance().addStudent(st);
            messageTv.setText(name);
            Intent intent = new Intent(this, StudentRecyclerList.class);
            startActivity(intent);
        });


        cancelBtn.setOnClickListener(view -> finish());
    }
}