package com.safwan.tutionmanagement.repo;

import com.safwan.tutionmanagement.dto.AttendanceDTO;
import com.safwan.tutionmanagement.modal.Attendance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long> {
    Optional<List<Attendance>> findByDate(LocalDate date);

    // name of variable in query should be same as variable name in JAVA not in SQL
    @Query("""
    SELECT COUNT(a)
    FROM Attendance a
    WHERE a.student.stdId = :id
    AND a.isPresent = 1
    """)
    Integer getStudentPresentClassesByStdId(@Param("id") String id);

    @Query("""
    SELECT new com.safwan.tutionmanagement.dto.AttendanceDTO(a.date, a.isPresent)
    FROM Attendance a
    WHERE a.student.stdId = :id
    """)
    List<AttendanceDTO> getStudentAttendanceByStdId(@Param("id") String id);

}
