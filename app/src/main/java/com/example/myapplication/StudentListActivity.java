//package com.example.myapplication;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.AdapterView;
//import android.widget.BaseAdapter;
//import android.widget.CheckBox;
//import android.widget.ListView;
//import android.widget.TextView;
//
//import com.example.myapplication.model.Model;
//import com.example.myapplication.model.Student;
//
//import java.util.List;
//
//public class StudentListActivity extends AppCompatActivity {
//
//    List<Student> data;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_studentlist);
//
//        data = Model.instance().getAllStudent();
//        ListView list = findViewById(R.id.studentlist_list);
//        list.setAdapter(new studentListAdapter());
//
//        list.setOnItemClickListener(new AdapterView.OnItemClickListener(){
//
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int pos, long l) {
//                Log.d("TAG" , "row was clicked " + pos);
//            }
//        });
//    }
//
//    class studentListAdapter extends BaseAdapter{
//
//        @Override
//        public int getCount() {
//            return data.size();
//        }
//
//        @Override
//        public Object getItem(int i) {
//            return null;
//        }
//
//        @Override
//        public long getItemId(int i) {
//            return 0;
//        }
//
//        @Override
//        public View getView(int pos, View view, ViewGroup viewGroup) {
//            if(view == null){
//                view = getLayoutInflater().inflate(R.layout.student_list_row,null);
//                CheckBox cb = view.findViewById(R.id.studentlistrow_cb);
//                cb.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        int pos = (int)cb.getTag();
//                        Student st = data.get(pos);
//                        st.setCb(cb.isChecked());
//                    }
//                });
//            }
//            Student st = data.get(pos);
//            TextView nameTv = view.findViewById(R.id.studentlistrow_name_tv);
//            nameTv.setText(st.name);
//            TextView idTv = view.findViewById(R.id.studentlistrow_id_tv);
//            idTv.setText(st.id);
//            CheckBox cb = view.findViewById(R.id.studentlistrow_cb);
//            cb.setChecked(st.cb);
//            cb.setTag(pos);
//
//            return view;
//        }
//    }
//
//}