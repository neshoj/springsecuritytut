package com.neshoj.springsecuritytut.student;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    List<Student> studentList = Arrays.asList(
            new Student(1, "Ignatius Ojiambo"),
            new Student(2, "Adrian Xavier"),
            new Student(3, "Blaise Amari"));

    @GetMapping(path = "/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudent(@PathVariable Integer studentId) {
        return studentList.stream()
                .filter(student -> Objects.equals(student.getId(), studentId))
                .findFirst().orElseThrow();
    }
}
