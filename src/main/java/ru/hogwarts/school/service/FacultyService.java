package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.FacultyNotFoundException;
import ru.hogwarts.school.model.Faculty;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyService {

    private final HashMap<Long, Faculty> faculties = new HashMap<>();

    private long counter = 1;

    public Faculty create(Faculty faculty) {
        faculty.setId(counter++);
        faculties.put(faculty.getId(), faculty);
        return faculty;
    }

    public Faculty read(long id){
        if(faculties.containsKey(id)){
            return faculties.get(id);
        }
        throw new FacultyNotFoundException();
    }

    public Faculty update(Faculty faculty){
        if(faculties.containsKey(faculty.getId())) {
            faculties.put(faculty.getId(), faculty);
            return faculty;
        }
        throw new FacultyNotFoundException();
    }
    

    public Faculty delete(long id){
        if(faculties.containsKey(id)){
            return faculties.remove(id);
        }
        throw new FacultyNotFoundException();
    }

    public List<Faculty> facultiesByColor(String color){
        return faculties.values().stream()
                .filter(faculty -> faculty.getColor().equals(color))
                .collect(Collectors.toList());
    }
}
