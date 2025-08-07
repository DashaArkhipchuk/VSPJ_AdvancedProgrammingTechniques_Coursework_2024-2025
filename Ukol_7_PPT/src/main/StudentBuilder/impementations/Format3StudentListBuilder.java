package main.StudentBuilder.impementations;

import main.StudentBuilder.interfaces.StudentListBuilder;
import main.model.ClassRoom;
import main.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Format3StudentListBuilder implements StudentListBuilder {
    @Override
    public Map<String, ClassRoom> build(List<String> lines) {
        Map<String, ClassRoom> result = new HashMap<>();
        int i = 0;

        while (i < lines.size()) {
            String className = lines.get(i++).trim();
            int count = Integer.parseInt(lines.get(i++).trim());
            ClassRoom classRoom = new ClassRoom(className);
            for (int j = 0; j < count && i + 1 < lines.size(); j++) {
                String firstName = lines.get(i++).trim();
                String lastName = lines.get(i++).trim();
                classRoom.getStudents().add(new Student(firstName, lastName, j + 1));
            }
            result.put(className, classRoom);
        }

        return result;
    }
}