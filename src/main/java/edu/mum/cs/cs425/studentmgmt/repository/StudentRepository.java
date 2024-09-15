package edu.mum.cs.cs425.studentmgmt.repository;


import edu.mum.cs.cs425.studentmgmt.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByStudentNumberContainingOrFirstNameContainingOrLastNameContaining(String studentNumber, String firstName, String lastName);
}
