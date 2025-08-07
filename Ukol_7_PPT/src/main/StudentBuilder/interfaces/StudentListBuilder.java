package main.StudentBuilder.interfaces;

import main.model.ClassRoom;

import java.util.List;
import java.util.Map;

public interface StudentListBuilder {
    Map<String, ClassRoom> build(List<String> lines);
}