package com.javarush.task.task29.task2909.human;

import java.util.ArrayList;
import java.util.List;

public class University {
    private String name;
    private int age;
    private List<Student> students = new ArrayList<>();

    public University(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List getStudents() {
        return students;
    }

    public void setStudents(List students) {
        this.students = students;
    }

    public Student getStudentWithAverageGrade(double averageGrade) {
        for (Student studentOk : students) {
            if (studentOk.getAverageGrade() >= averageGrade) return studentOk;
        }
        return null;
    }

    public Student getStudentWithMaxAverageGrade() {
        double maxGrade = students.get(0).getAverageGrade();
        Student studentMax = students.get(0);
        for (Student studentMaxGrade : students) {
            if (studentMaxGrade.getAverageGrade() > maxGrade) {
                maxGrade = studentMaxGrade.getAverageGrade();
                studentMax = studentMaxGrade;
            }
        }
        return studentMax;
    }

    public Student getStudentWithMinAverageGrade() {
        double minGrade = students.get(0).getAverageGrade();
        Student studentMin = students.get(0);
        for (Student studentMaxGrade : students) {
            if (studentMaxGrade.getAverageGrade() < minGrade) {
                minGrade = studentMaxGrade.getAverageGrade();
                studentMin = studentMaxGrade;
            }
        }
        return studentMin;
    }

    public void expel(Student student) {
        students.remove(student);
    }
}