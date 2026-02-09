package com.safwan.tutionmanagement.service;

import com.safwan.tutionmanagement.modal.Attendance;
import com.safwan.tutionmanagement.repo.AttendanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance saveAttendance(Attendance attendance) {
        return attendanceRepository.save(attendance);
    }

    public List<Attendance> getAllAttendance() {
        return attendanceRepository.findAll();
    }

    public Optional<Attendance> getAttendanceById(Long id) {
        return attendanceRepository.findById(id);
    }

    public Optional<List<Attendance>> getAttendanceByDate(LocalDate date) {
        return attendanceRepository.findByDate(date);
    }

    public void deleteAttendance(Long id) {
        attendanceRepository.deleteById(id);
    }
}
