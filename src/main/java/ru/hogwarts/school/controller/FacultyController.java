package ru.hogwarts.school.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.hogwarts.school.model.Faculty;
import ru.hogwarts.school.service.FacultyService;


@RestController
@RequestMapping("/faculty")

public class FacultyController {

    private final FacultyService facultyService;

    public FacultyController(FacultyService facultyService) {
        this.facultyService = facultyService;
    }

    @GetMapping("/{id}")
    public Faculty read(@PathVariable Long id){
        return facultyService.read(id);
    }

    @PostMapping
    public ResponseEntity<Faculty> create(@RequestBody Faculty faculty){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(facultyService.create(faculty));
    }

    @PutMapping
    public Faculty update(Faculty faculty){
        return facultyService.update(faculty);
    }

    @DeleteMapping("/{id}")
    public Faculty delete(@PathVariable Long id){
        return facultyService.delete(id);
    }
}
