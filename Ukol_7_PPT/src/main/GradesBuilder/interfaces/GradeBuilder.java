package main.GradesBuilder.interfaces;

import main.model.ClassRoom;
import main.model.GradeRecord;

import java.util.List;
import java.util.Map;

public interface GradeBuilder {
    Map<String, List<GradeRecord>> build(List<String> lines, Map<String, ClassRoom> students);
}
