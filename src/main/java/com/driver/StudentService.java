package com.driver;

import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class StudentService {

    public static void addStudent(Student student){
        StudentRepository.addStudent(student);
    }

    public static void addTeacher(Teacher teacher){
        StudentRepository.addTeacher(teacher);
    }

    public static void addStudentTeacherPair (String student,String teacher){
      StudentRepository.addStudentTeacherPair(student,teacher);
    }

    public static Student getStudentByName(String name){
       return StudentRepository.getStudentByName(name);
    }

    public static Teacher getTeacherByName(String name){
        return StudentRepository.getTeacherByName(name);
    }

    public static List<String> getStudentsByTeacherName(String name){
        return StudentRepository.getStudentsByTeacherName(name);
    }

    public static List<String> getAllStudents(){
       return StudentRepository.getAllStudents();
    }

    public static void deleteTeacherByName(String name){
        StudentRepository.deleteTeacherByName(name);
    }

    public static void deleteAllTeachers(){
        StudentRepository.deleteAllTeachers();
    }
}
