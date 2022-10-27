package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.StudentNotFoundException;
import ru.hogwarts.school.model.Student;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final Map<Long, Student> students = new HashMap<>();

    private long counter = 1;

    public Student create(Student student) {
        student.setId(counter++);
        students.put(student.getId(), student);
        return student;
    }

    public Student read(long id){
        if (students.containsKey(id)){
            return students.get(id);
        }
        throw new StudentNotFoundException();
    }

    public Student update(Student student){
        if (students.containsKey(student.getId())){
            students.put(student.getId(), student);
            return student;
        }
        throw new StudentNotFoundException();
    }

    public Student delete(long id){
        if(students.containsKey(id)){
            return students.remove(id);
        }
        throw new StudentNotFoundException();
    }

    public List<Student> studentsByAge (int age){
        return students.values().stream()
                .filter(student -> student.getAge() == age)
                .collect(Collectors.toList());
    }
}
