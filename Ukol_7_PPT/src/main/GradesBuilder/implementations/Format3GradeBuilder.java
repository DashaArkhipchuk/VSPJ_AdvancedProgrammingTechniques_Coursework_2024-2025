package main.GradesBuilder.implementations;

import main.GradesBuilder.interfaces.GradeBuilder;
import main.model.ClassRoom;
import main.model.GradeRecord;
import main.model.Student;

import java.util.*;

public class Format3GradeBuilder implements GradeBuilder {

    private static final List<String> SUBJECTS = List.of("MAT", "FYZ", "IT", "CJ", "TV");

    @Override
    public Map<String, List<GradeRecord>> build(List<String> lines, Map<String, ClassRoom> classrooms) {
        Map<String, List<GradeRecord>> gradeMap = new LinkedHashMap<>();
        Iterator<String> iterator = lines.iterator();

        while (iterator.hasNext()) {
            String className = iterator.next().trim();

            if (!iterator.hasNext()) {
                throw new IllegalArgumentException("Missing number of grades for class " + className);
            }

            int totalGrades;
            try {
                totalGrades = Integer.parseInt(iterator.next().trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid number of grades for class " + className);
            }

            if (totalGrades % SUBJECTS.size() != 0) {
                throw new IllegalArgumentException("Total grades not divisible by 5 in class " + className);
            }

            int studentCount = totalGrades / SUBJECTS.size();

            if (!classrooms.containsKey(className)) {
                throw new IllegalArgumentException("Class not found: " + className);
            }

            ClassRoom classRoom = classrooms.get(className);
            List<Student> students = classRoom.getStudents();

            if (students.size() != studentCount) {
                throw new IllegalArgumentException("Mismatch: class " + className + " has "
                        + students.size() + " students but grade file contains " + studentCount + " student entries.");
            }

            List<Integer> gradeValues = new ArrayList<>();
            for (int i = 0; i < totalGrades; i++) {
                if (!iterator.hasNext()) {
                    throw new IllegalArgumentException("Unexpected end of grade values for class " + className);
                }
                try {
                    gradeValues.add(Integer.parseInt(iterator.next().trim()));
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("Invalid grade value in class " + className);
                }
            }

            List<GradeRecord> gradeRecords = new ArrayList<>();

            for (int i = 0; i < studentCount; i++) {
                Map<String, Integer> subjectGrades = new LinkedHashMap<>();
                for (int j = 0; j < SUBJECTS.size(); j++) {
                    int gradeIndex = i * SUBJECTS.size() + j;
                    subjectGrades.put(SUBJECTS.get(j), gradeValues.get(gradeIndex));
                }
                gradeRecords.add(new GradeRecord(students.get(i), subjectGrades));
            }

            gradeMap.put(className, gradeRecords);
        }

        return gradeMap;
    }
}
