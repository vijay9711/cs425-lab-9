package edu.mum.cs.cs425.studentmgmt.service;


import edu.mum.cs.cs425.studentmgmt.entity.Student;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> searchStudents(String searchTerm) {
        return studentRepository.findByStudentNumberContainingOrFirstNameContainingOrLastNameContaining(searchTerm, searchTerm, searchTerm);
    }
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student getStudentById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
