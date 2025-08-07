package main.model;

import java.util.ArrayList;
import java.util.List;

public class ClassRoom {
    private String name;
    private List<Student> students;

    public ClassRoom(String name) {
        this.name = name;
        this.students = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public Student getStudentByNumber(int number) {
        for (Student s : students) {
            if (s.getNumber() == number) return s;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Class " + name + ":\n");
        for (Student s : students) {
            sb.append(s.toString()).append("\n");
        }
        return sb.toString();
    }
}