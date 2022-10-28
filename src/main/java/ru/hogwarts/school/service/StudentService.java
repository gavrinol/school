package ru.hogwarts.school.service;

import org.springframework.stereotype.Service;
import ru.hogwarts.school.exception.FacultyNotFoundException;
import ru.hogwarts.school.exception.StudentNotFoundException;
import ru.hogwarts.school.model.Student;
import ru.hogwarts.school.repository.StudentRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student create(Student student) {
        student.setId(null);
        return studentRepository.save(student);
    }


    public Student read(long id) {
        return studentRepository.findById(id)
                .orElseThrow(FacultyNotFoundException::new);
    }

    public Student update(Student student){
        Student oldStudent = studentRepository.findById(student.getId())
                .orElseThrow(StudentNotFoundException::new);
        oldStudent.setStudent(student.getStudent());
        oldStudent.setAge(student.getAge());
        return studentRepository.save(oldStudent);
    }

    public Student delete(long id) {
            Student student = studentRepository.findById(id)
                .orElseThrow(StudentNotFoundException::new);
        studentRepository.delete(student);
        return student;
    }

    
}
