package com.safwan.tutionmanagement.repo;

import com.safwan.tutionmanagement.modal.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    public Optional<List<Attendance>> findByDate(LocalDate date);
}
