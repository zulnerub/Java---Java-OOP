package Abstractions.StudentSystem;

import java.util.HashMap;
import java.util.Map;

public class Repository {
    private Map<String, Student> students;

    public Repository() {
        this.students = new HashMap<>();
    }

    public boolean containsStudentByName(String name) {
        return this.students.containsKey(name);
    }

    public void registerStudent(String name, Student student) {
        this.students.put(name, student);
    }

    public Student findOneByName(String name) {
        return this.students.get(name);
    }
}
