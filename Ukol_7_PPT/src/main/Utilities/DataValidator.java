package main.Utilities;

import main.model.ClassRoom;
import main.model.GradeRecord;
import main.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataValidator {

    public static void validateClassroomGrades(
            Map<String, ClassRoom> classrooms,
            Map<String, List<GradeRecord>> gradeRecords
    ) {
        for (String className : classrooms.keySet()) {
            List<Student> students = classrooms.get(className).getStudents();
            List<GradeRecord> grades = gradeRecords.getOrDefault(className, new ArrayList<>());

            if (students.size() != grades.size()) {
                throw new IllegalArgumentException("Mismatch in student count and grade records in class: " + className);
            }

            for (GradeRecord record : grades) {
                if (record.getSubjectGrades().size() != 5) {
                    throw new IllegalArgumentException("Student " + record.getStudent() +
                            " in class " + className + " has invalid number of grades: " +
                            record.getSubjectGrades().size());
                }
            }
        }
    }
}
