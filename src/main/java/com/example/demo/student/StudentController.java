package com.example.demo.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

/**
 * @author Ivan Kaptue (ivanokaptue@gmail.com)
 */
@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
        new Student(1, "James Bond"),
        new Student(2, "Vin Diesel"),
        new Student(3, "Alain"),
        new Student(4, "Ivan Kaptue")
    );

    @GetMapping(path = "/{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer studentId) {
        return STUDENTS.stream()
            .filter(student -> student.getStudentId().equals(studentId))
            .findFirst()
            .orElseThrow(() -> new IllegalStateException("Student " + studentId + " does not exists"));
    }

}
