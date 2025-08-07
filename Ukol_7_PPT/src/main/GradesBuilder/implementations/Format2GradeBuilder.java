package main.GradesBuilder.implementations;

import main.GradesBuilder.interfaces.GradeBuilder;
import main.model.ClassRoom;
import main.model.GradeRecord;
import main.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Format2GradeBuilder implements GradeBuilder {
    private static final String[] SUBJECTS = {"MAT", "FYZ", "IT", "CJ", "TV"};

    @Override
    public Map<String, List<GradeRecord>> build(List<String> lines, Map<String, ClassRoom> students) {
        Map<String, List<GradeRecord>> result = new HashMap<>();
        int i = 0;

        while (i < lines.size()) {
            String className = lines.get(i++).trim();
            int count = Integer.parseInt(lines.get(i++).trim());
            List<GradeRecord> grades = new ArrayList<>();
            ClassRoom classRoom = students.get(className);
            for (int j = 0; j < count && i < lines.size(); j++) {
                String[] marks = lines.get(i++).split(";");
                Student s = classRoom.getStudents().get(j);
                Map<String, Integer> g = new HashMap<>();
                for (int k = 0; k < marks.length; k++) {
                    g.put(SUBJECTS[k], Integer.parseInt(marks[k]));
                }
                grades.add(new GradeRecord(s, g));
            }
            result.put(className, grades);
        }

        return result;
    }
}
