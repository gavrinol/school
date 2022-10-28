package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.service.StudentService;

import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> create(@RequestBody Student student){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.create(student));
    }

    @GetMapping("/{id}")
    public Student read(@PathVariable("id") Long id){
        return studentService.read(id);
    }

    @PutMapping
    public Student update(@RequestBody Student student) {
        return  studentService.update(student);
    }

    @DeleteMapping("{id}")
    public Student delete(@PathVariable long id){
        return studentService.delete(id);
    }

}

