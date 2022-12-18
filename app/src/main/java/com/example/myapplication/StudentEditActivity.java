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

import java.io.Serializable;
import java.util.List;

public class StudentEditActivity extends AppCompatActivity {


    Student st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_edit);
        int numSt = (int) getIntent().getSerializableExtra("ST");
        Student st = Model.instance().getAllStudent().get(numSt);
        EditText nameEt = findViewById(R.id.editstudent_name_edittext);
        EditText idEt = findViewById(R.id.editstudent_id_edittext);
        EditText phoneEt = findViewById(R.id.editstudent_phone_edittext);
        EditText addressEt = findViewById(R.id.editstudent_address_edittext);
        CheckBox checkedCb = findViewById(R.id.editstudent_checked_cb);

        Button saveBtn = findViewById(R.id.editstudent_save_btn);
        Button cancelBtn = findViewById(R.id.editstudent_cancel_btn);
        Button deleteBtn = findViewById(R.id.editstudent_delete_btn);

        nameEt.setText(st.name);
        idEt.setText(st.id);
        phoneEt.setText(st.phone);
        addressEt.setText(st.address);
        checkedCb.setChecked(st.cb);

        deleteBtn.setOnClickListener(view -> {
            Model.instance().getAllStudent().remove(numSt);
            //adapter.notifyDataSetChanged();
            Intent intent = new Intent(this,StudentRecyclerList.class);
            startActivity(intent);
            finish();
        });

        cancelBtn.setOnClickListener(view ->finish());

        saveBtn.setOnClickListener(view -> {
            Student st1 =Model.instance().getAllStudent().get(numSt);
            st1.setName(nameEt.getText().toString());
            st1.setId(idEt.getText().toString());
            st1.setPhone(phoneEt.getText().toString());
            st1.setAddress(addressEt.getText().toString());
            st1.setCb(checkedCb.isChecked());
            //adapter.notifyDataSetChanged();
            Intent intent = new Intent(this,StudentRecyclerList.class);
            startActivity(intent);
            finish();
        });

    }




}