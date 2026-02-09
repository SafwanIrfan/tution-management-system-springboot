package com.safwan.tutionmanagement.repo;

import com.safwan.tutionmanagement.modal.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}
