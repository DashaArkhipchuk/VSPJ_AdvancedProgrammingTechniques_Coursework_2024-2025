package main.model;

import java.util.Map;

public class GradeRecord {
    private Student student;
    private Map<String, Integer> subjectGrades;

    public GradeRecord(Student student, Map<String, Integer> subjectGrades) {
        this.student = student;
        this.subjectGrades = subjectGrades;
    }

    public Student getStudent() {
        return student;
    }

    public Map<String, Integer> getSubjectGrades() {
        return subjectGrades;
    }

    public double getAverageGrade() {
        return subjectGrades.values().stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);
    }

    @Override
    public String toString() {
        return student + " -> " + subjectGrades.toString();
    }
}