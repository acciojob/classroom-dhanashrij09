package com.driver;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository

public class StudentRepository {
    private HashMap<String,Student> studentMap = new HashMap<>();
    private HashMap<String,Teacher> teacherMap = new HashMap<>();
    private HashMap<String,String> studentTeacherMap = new HashMap<>();
    private HashMap<String, List<String>> listStudentMap = new HashMap<>();



    public void addStudent(Student student){
        studentMap.put(student.getName(),student);
    }

    public void addTeacher(Teacher teacher){
        teacherMap.put(teacher.getName(),teacher);
    }
    public void addStudentTeacherPair(String student,String teacher){
        if(studentMap.containsKey(student) && teacherMap.containsKey(teacher)){
            studentTeacherMap.put(student,teacher);
        }
        List<String> students = new ArrayList<>();
        if(listStudentMap.containsKey(teacher)){
         students = listStudentMap.get(teacher);
        }
        students.add(student);
        listStudentMap.put(teacher,students);

        //update the numberOfStudents
        Teacher teachers = teacherMap.get(teacher);
        teachers.setNumberOfStudents(students.size());
    }

    public Student getStudentByName(String name){
        return studentMap.get(name);
    }

    public Teacher getTeacherByName(String name){
        return teacherMap.get(name);
    }

    public List<String> getStudentsByTeacherName(String name){
      return listStudentMap.get(name);
    }

    public List<String> getAllStudents(){
        List<String> allStudents = new ArrayList<>();
        for(String student : studentMap.keySet()){
           allStudents.add(student);
        }
        return allStudents;
    }

    public  void deleteTeacherByName(String name){
        if(teacherMap.containsKey(name)){
            teacherMap.remove(name);

            //if(studentTeacherMap.containsKey(name))
               // studentTeacherMap.remove(name);

            List<String> listOfStudents = listStudentMap.get(name);
            listStudentMap.remove(name);

            for(String students : listOfStudents){
                studentTeacherMap.remove(students);
            }
        }
    }

    public void deleteAllTeachers() {
        for(String deleteTeachers : teacherMap.keySet())
            teacherMap.remove(deleteTeachers);

        for(String deleteTeacher : listStudentMap.keySet())
            listStudentMap.remove(deleteTeacher);


    }
}
