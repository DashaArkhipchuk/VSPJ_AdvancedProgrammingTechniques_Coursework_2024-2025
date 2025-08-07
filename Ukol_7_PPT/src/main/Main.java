package main;

import main.FileProvider.CsvFileProvider;
import main.FileProvider.FileProvider;
import main.GradesBuilder.implementations.Format1GradeBuilder;
import main.GradesBuilder.implementations.Format2GradeBuilder;
import main.GradesBuilder.implementations.Format3GradeBuilder;
import main.GradesBuilder.interfaces.GradeBuilder;
import main.Services.ExportService;
import main.StudentBuilder.impementations.Format1StudentListBuilder;
import main.StudentBuilder.impementations.Format2StudentListBuilder;
import main.StudentBuilder.impementations.Format3StudentListBuilder;
import main.StudentBuilder.interfaces.StudentListBuilder;
import main.Utilities.DataValidator;
import main.model.ClassRoom;
import main.model.GradeRecord;

import java.io.File;
import java.util.List;
import java.util.Map;

public class Main {

    public static void TestFormat1(){
        try {
            FileProvider provider = new CsvFileProvider();
            List<String> studentLines = provider.load("students_format1.csv");
            List<String> gradeLines = provider.load("grades_format1.csv");

            StudentListBuilder studentBuilder = new Format1StudentListBuilder();
            GradeBuilder gradeBuilder = new Format1GradeBuilder();

            Map<String, ClassRoom> classRooms = studentBuilder.build(studentLines);
            Map<String, List<GradeRecord>> grades = gradeBuilder.build(gradeLines, classRooms);

            DataValidator.validateClassroomGrades(classRooms, grades);

            System.out.println("Data loaded and validated successfully.");

            ExportService export = new ExportService();
            export.exportClassStudents(classRooms);
            export.exportResults(grades);

            System.out.println("Ready.");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void TestFormat2(){
        try {
            FileProvider provider = new CsvFileProvider();
            List<String> studentLines = provider.load("students_format2.csv");
            List<String> gradeLines = provider.load("grades_format2.csv");

            StudentListBuilder studentBuilder = new Format2StudentListBuilder();
            GradeBuilder gradeBuilder = new Format2GradeBuilder();

            Map<String, ClassRoom> classRooms = studentBuilder.build(studentLines);
            Map<String, List<GradeRecord>> grades = gradeBuilder.build(gradeLines, classRooms);

            DataValidator.validateClassroomGrades(classRooms, grades);

            System.out.println("Data loaded and validated successfully.");

            ExportService export = new ExportService();
            export.exportClassStudents(classRooms);
            export.exportResults(grades);

            System.out.println("Ready.");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void TestFormat3(){
        try {
            FileProvider provider = new CsvFileProvider();
            List<String> studentLines = provider.load("students_format3.csv");
            List<String> gradeLines = provider.load("grades_format3.csv");

            StudentListBuilder studentBuilder = new Format3StudentListBuilder();
            GradeBuilder gradeBuilder = new Format3GradeBuilder();

            Map<String, ClassRoom> classRooms = studentBuilder.build(studentLines);
            Map<String, List<GradeRecord>> grades = gradeBuilder.build(gradeLines, classRooms);

            DataValidator.validateClassroomGrades(classRooms, grades);

            System.out.println("Data loaded and validated successfully.");

            ExportService export = new ExportService();
            export.exportClassStudents(classRooms);
            export.exportResults(grades);

            System.out.println("Ready.");

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        TestFormat1();
    }
}
