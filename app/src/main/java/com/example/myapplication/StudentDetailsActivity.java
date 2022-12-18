package com.example.myapplication;

import androidx.activity.result.contract.ActivityResultContracts;
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

public class StudentDetailsActivity extends AppCompatActivity{


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);

        TextView nameTv = findViewById(R.id.details_name_tv);
        TextView idTv = findViewById(R.id.details_id_tv);
        TextView phoneTv = findViewById(R.id.details_phone_tv);
        TextView addressTv = findViewById(R.id.details_address_tv);
        CheckBox checkedCb = findViewById(R.id.details_checked_cb);

        int numSt= (int) getIntent().getSerializableExtra("ST");
        Student st = Model.instance().getAllStudent().get(numSt);
        nameTv.setText(st.name);
        idTv.setText(st.id);
        phoneTv.setText(st.phone);
        addressTv.setText(st.address);
        checkedCb.setChecked(st.cb);

        Button editBtn = findViewById(R.id.details_edit_btn);
        Button backBtn = findViewById(R.id.details_back_btn);

        editBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this,StudentEditActivity.class);
            intent.putExtra("ST",numSt);///
            startActivity(intent);
            finish();
        });

        backBtn.setOnClickListener(view -> finish());


    }


}