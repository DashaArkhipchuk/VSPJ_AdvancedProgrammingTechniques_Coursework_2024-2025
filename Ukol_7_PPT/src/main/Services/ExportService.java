package main.Services;

import main.model.ClassRoom;
import main.model.GradeRecord;
import main.model.Student;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExportService {
    public void exportClassStudents(Map<String, ClassRoom> classRooms) throws IOException {
        for (var entry : classRooms.entrySet()) {
            String className = entry.getKey();
            List<Student> students = entry.getValue().getStudents();
            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(className + ".csv"))) {
                writer.write(className + "\n");
                for (Student s : students) {
                    writer.write(s.getFirstName() + ";" + s.getLastName() + "\n");
                }
            }
        }
    }

    public void exportResults(Map<String, List<GradeRecord>> grades) throws IOException {
        for (var entry : grades.entrySet()) {
            String className = entry.getKey();
            List<GradeRecord> records = entry.getValue();
            Map<String, Double> subjectAverages = new HashMap<>();

            for (String subj : List.of("MAT", "FYZ", "IT", "CJ", "TV")) {
                double avg = records.stream()
                        .mapToInt(r -> r.getSubjectGrades().getOrDefault(subj, 0))
                        .average().orElse(0);
                subjectAverages.put(subj, avg);
            }

            try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(className + "_results.csv"))) {
                writer.write("Subject;Average\n");
                for (var subj : subjectAverages.keySet()) {
                    writer.write(subj + ";" + String.format("%.2f", subjectAverages.get(subj)) + "\n");
                }
            }
        }
    }
}