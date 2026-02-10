package com.safwan.tutionmanagement.repo;

import com.safwan.tutionmanagement.modal.ReportMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportMarksRepository extends JpaRepository<ReportMarks, Long> {
}
