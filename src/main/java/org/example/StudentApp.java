package org.example;

import za.ac.tut.entity.Student;
import za.ac.tut.bl.StudentManager;
import za.ac.tut.bl.StudentManagerInterface;
import za.ac.tut.entity.Student;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StudentApp {

    public static void main(String[] args) {

        try{
        File file = new File("D://Tasks//AOP//Semester test 1//files to be shared with students//question 3//ClassListManagerJavadoc//students.txt");

        StudentManager studentManager = new StudentManager();
        String studentName;
        int studentAge;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please choose from the options below: " +
                "\n 1) Add student" +
                "\n 2) Get all students" +
                "\n 0) Exit");
        int option = scanner.nextInt();

        while(option != 0) {
            switch (option){
                case 1:
                    System.out.print("Enter student name: ");
                    studentName = scanner.next();
                    System.out.print("Student age: ");
                    studentAge = scanner.nextInt();
                    Student student = new Student(studentName, studentAge);
                    //add student
                    studentManager.addStudent(student, file);
                    System.out.println("Student added successfully");
                    break;

                case 2:
                    //get student
                   List<Student> studentList = studentManager.getStudents(file);
                   for(Student stud: studentList){
                       System.out.println("Name: " + stud.getName() + "\n" +
                               "Age: " + stud.getAge() + "\n" +
                               "============================");
                   }
                    break;

                default:
                    System.out.println("Oops! Invalid option!");
            }
            System.out.println(
                    "\n 1) Add another student" +
                    "\n 2) Get all students" +
                    "\n 0) Exit");
             option = scanner.nextInt();
        }
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}
