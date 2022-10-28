package ru.hogwarts.school.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;


@Entity
public class Student {

    @Id
    @GeneratedValue
    private long id;

    private String student;

    private int age;

    public Student(long id, String student, int age) {
        this.id = id;
        this.student = student;
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudent() {
        return student;
    }

    public void setStudent(String student) {
        this.student = student;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student1 = (Student) o;
        return id == student1.id && age == student1.age && Objects.equals(student, student1.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, student, age);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", student='" + student + '\'' +
                ", age=" + age +
                '}';
    }
}
