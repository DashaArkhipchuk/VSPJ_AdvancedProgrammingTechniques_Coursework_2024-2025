package main.GradesBuilder.implementations;

import main.GradesBuilder.interfaces.GradeBuilder;
import main.model.ClassRoom;
import main.model.GradeRecord;
import main.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Format1GradeBuilder implements GradeBuilder {
    private static final String[] SUBJECTS = {"MAT", "FYZ", "IT", "TV", "CJ"};

    @Override
    public Map<String, List<GradeRecord>> build(List<String> lines, Map<String, ClassRoom> students) {
        Map<String, List<GradeRecord>> result = new HashMap<>();
        String currentClass = null;
        int studentIndex = 0;

        for (String line : lines) {
            if (line.trim().isEmpty()) continue;
            if (!line.contains(";")) {
                currentClass = line.trim();
                result.put(currentClass, new ArrayList<>());
                studentIndex = 0;
            } else {
                String[] marks = line.split(";");
                Student student = students.get(currentClass).getStudents().get(studentIndex++);
                Map<String, Integer> grades = new HashMap<>();
                for (int i = 0; i < marks.length && i < SUBJECTS.length; i++) {
                    grades.put(SUBJECTS[i], Integer.parseInt(marks[i]));
                }
                result.get(currentClass).add(new GradeRecord(student, grades));
            }
        }
        return result;
    }
}