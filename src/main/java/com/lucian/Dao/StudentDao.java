package com.lucian.Dao;

import com.lucian.Entity.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class StudentDao {

    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>(){
            {
                put(1, new Student(1, "Luci", "C.S."));
                put(2, new Student(1, "John", "Math"));
                put(3, new Student(1, "Edy", "Civil Engineering"));

            }

        };
    }

    public Collection<Student> getAllStudents(){
        return this.students.values();
    }

    public Student getStudentById(int id) {
         return this.students.get(id);
    }

    public void removeStudentById(int id) {
        this.students.remove(id);
    }

    public void updateStudentById(Student student){
        Student std = students.get(student.getId());
        std.setCourse(student.getCourse());
        std.setName(student.getName());
        students.put(student.getId(), student);
    }

    public void insertStudent(Student student) {
        this.students.put(student.getId(), student);
    }
}
