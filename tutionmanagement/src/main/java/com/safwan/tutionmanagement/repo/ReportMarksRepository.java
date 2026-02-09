package com.safwan.tutionmanagement.repo;

import com.safwan.tutionmanagement.modal.ReportMarks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportMarksRepository extends JpaRepository<ReportMarks, Long> {
}
