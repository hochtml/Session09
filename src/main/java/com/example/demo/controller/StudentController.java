// controller/StudentController.java
package com.example.demo.controller;

import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/students")
public class StudentController {

    private List<Student> students = new ArrayList<>();

    // Giả lập dữ liệu trong Constructor
    public StudentController() {
        students.add(new Student("SV001", "Nguyen Van A"));
        students.add(new Student("SV002", "Tran Thi B"));
        students.add(new Student("SV003", "Le Van C"));
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        throw new StudentNotFoundException("Sinh viên với ID " + id + " không tồn tại");
    }
}