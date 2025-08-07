package main.StudentBuilder.impementations;

import main.StudentBuilder.interfaces.StudentListBuilder;
import main.model.ClassRoom;
import main.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Format2StudentListBuilder implements StudentListBuilder {
    @Override
    public Map<String, ClassRoom> build(List<String> lines) {
        Map<String, ClassRoom> result = new HashMap<>();
        int i = 0;
        while (i < lines.size()) {
            String className = lines.get(i++).trim();
            int count = Integer.parseInt(lines.get(i++).trim());
            ClassRoom classRoom = new ClassRoom(className);
            for (int j = 0; j < count && i < lines.size(); j++) {
                String[] parts = lines.get(i++).split(";");
                classRoom.getStudents().add(new Student(parts[0], parts[1], j + 1));
            }
            result.put(className, classRoom);
        }
        return result;
    }
}