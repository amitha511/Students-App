package com.example.myapplication.model;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();
     List<Student> data = new LinkedList<>();

    private Model(){
        addStudent(new Student("Amit" , "209025689" , "0523338455","Hod Hasharon" , false));
        addStudent(new Student("Maya" , "384129698" , "0524485566","Telmond" , true));
        addStudent(new Student("Keren" , "129157285" , "052121111","Tel aviv" , false));
        addStudent(new Student("Mor" , "123174695" , "0524148225","Hertzeliya" , true));
        addStudent(new Student("Shoval" , "892356487" , "0523658894","Reshon Lezion" , true));
        addStudent(new Student("Shay" , "456978153" , "0525558742","Raanana" , false));
        addStudent(new Student("Ben" , "555888777" , "0521597894","TelMond" , false));
        addStudent(new Student("Yuval" , "224588789" , "0522224567","Heifa" , false));

    }

    public static Model instance() {
        return _instance;
    }

    public List<Student> getAllStudent(){
        return data;
    }

    public void addStudent(Student st){
        data.add(st);
    }
}