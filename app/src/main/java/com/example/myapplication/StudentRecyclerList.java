package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.myapplication.model.Model;
import com.example.myapplication.model.Student;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class StudentRecyclerList extends AppCompatActivity {

    List<Student> data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_recycler_list);

        FloatingActionButton addBtn = findViewById(R.id.recycler_floating_add_btn);

        data = Model.instance().getAllStudent();
        RecyclerView list = findViewById(R.id.studentrecycler_list);
        list.setHasFixedSize(true);

        list.setLayoutManager(new LinearLayoutManager(this));  //build list (order of items)
        StudentRecyclerAdapter adapter = new StudentRecyclerAdapter();
        list.setAdapter(adapter);
        adapter.notifyDataSetChanged();


        addBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this,AddStudentActivity.class);
            startActivity(intent);
        });


        Intent intentToDetails = new Intent(this,StudentDetailsActivity.class);

        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int pos) {
                Intent intent = new Intent(intentToDetails);
                intent.putExtra("ST",pos);
                startActivity(intent);
                adapter.notifyDataSetChanged();

            }

        });

        adapter.notifyDataSetChanged();


    }

    class StudentViewHolder extends RecyclerView.ViewHolder{   // holder save pointers of text/img and more... for row
        TextView nameTv ;
        TextView idTv;
        CheckBox cb;

        public StudentViewHolder(@NonNull View itemView , OnItemClickListener listener) {
            super(itemView);
            nameTv = itemView.findViewById(R.id.studentlistrow_name_tv);
            idTv = itemView.findViewById(R.id.studentlistrow_id_tv);
            cb = itemView.findViewById(R.id.studentlistrow_cb);
            cb.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = (int)cb.getTag();
                    Student st = data.get(pos);
                    st.setCb(cb.isChecked());
                }
            });

            itemView.setOnClickListener(view -> {
                int pos= getAdapterPosition(); //return num of row
                Log.d("TAG", "row click " +pos);

                listener.onItemClick(pos);
            });

        }

        public void bind(Student st , int pos){
            nameTv.setText(st.name);
            idTv.setText(st.id);
            cb.setChecked(st.cb);
            cb.setTag(pos);
        }
    }


    public interface OnItemClickListener{
        void onItemClick(int pos);
    }

    class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentViewHolder> {

        OnItemClickListener listener;

        void setOnItemClickListener(OnItemClickListener listener){
            this.listener = listener;
        }


        @NonNull
        @Override
        public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {   //create new row
            View view = getLayoutInflater().inflate(R.layout.student_list_row,parent,false);
            return new StudentViewHolder(view,listener);
        }

        @Override
        public void onBindViewHolder(@NonNull StudentViewHolder holder, int pos) {    //bind data to row
            Student st = data.get(pos);
            holder.bind(st, pos);
        }


        @Override
        public int getItemCount() {
            return data.size();
        }
    }
}