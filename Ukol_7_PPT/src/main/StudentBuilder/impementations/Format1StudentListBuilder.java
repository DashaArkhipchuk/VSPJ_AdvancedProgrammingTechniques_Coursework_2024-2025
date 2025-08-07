package main.StudentBuilder.impementations;

import main.StudentBuilder.interfaces.StudentListBuilder;
import main.model.ClassRoom;
import main.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Format1StudentListBuilder implements StudentListBuilder {
    public Map<String, ClassRoom> build(List<String> lines) {
        Map<String, ClassRoom> result = new HashMap<>();
        ClassRoom currentClass = null;
        int studentIndex = 1;
        for (String line : lines) {
            if (line.trim().isEmpty()) continue;
            if (!line.contains(";")) {
                currentClass = new ClassRoom(line.trim());
                studentIndex = 1;
                result.put(currentClass.getName(), currentClass);
            } else {
                String[] parts = line.split(";");
                if (parts.length >= 2) {
                    assert currentClass != null;
                    currentClass.getStudents().add(new Student(parts[0], parts[1], studentIndex++));
                }
            }
        }
        return result;
    }
}