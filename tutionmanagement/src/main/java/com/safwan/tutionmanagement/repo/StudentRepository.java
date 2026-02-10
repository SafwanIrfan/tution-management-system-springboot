package com.safwan.tutionmanagement.repo;

import com.safwan.tutionmanagement.modal.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
}
