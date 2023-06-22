package com.neshoj.springsecuritytut.management;

import com.neshoj.springsecuritytut.student.Student;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("management/api/v1")
public class StudentManagementController {
    List<Student> studentList = Arrays.asList(
            new Student(1, "Ignatius Ojiambo"),
            new Student(2, "Adrian Xavier"),
            new Student(3, "Blaise Amari"));
    @GetMapping
    public List<Student> getAllStudents(){
        return studentList;
    }

    @GetMapping(path = "/{studentId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Student getStudent(@PathVariable Integer studentId) {
        return studentList.stream()
                .filter(student -> Objects.equals(student.getId(), studentId))
                .findFirst().orElseThrow();
    }
    @DeleteMapping(path="/{studentId}")
    public void deleteStudentById(@PathVariable("studentId") Integer studentId){
        System.out.println("Deleting student by Id = " + studentId);
    }
}
