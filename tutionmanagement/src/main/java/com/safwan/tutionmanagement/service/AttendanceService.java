package com.safwan.tutionmanagement.service;

import com.safwan.tutionmanagement.dto.AttendanceDTO;
import com.safwan.tutionmanagement.modal.Attendance;
import com.safwan.tutionmanagement.modal.Student;
import com.safwan.tutionmanagement.repo.AttendanceRepository;
import com.safwan.tutionmanagement.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AttendanceService {

    @Autowired
    private AttendanceRepository attendanceRepository;

    public Attendance saveAttendance(Attendance attendance, Student student) {
        System.out.println(attendance.getStudent());
        attendance.setStudent(student);
        System.out.println(attendance.getStudent());
        return attendanceRepository.save(attendance);
    }

    public Attendance updateAttendance(Long id, Attendance attendance) {

        Attendance newAtt = getAttendanceById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found with ID : " + id));

        newAtt.setIsPresent(attendance.getIsPresent());
        newAtt.setDate(LocalDate.now());

        return attendanceRepository.save(newAtt);
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

    public Integer getStudentPresentClassesByStdId(String id) {
        return attendanceRepository.getStudentPresentClassesByStdId(id);
    }

    public List<AttendanceDTO> getStudentAttendanceByStdId(String id) {
        return attendanceRepository.getStudentAttendanceByStdId(id);
    }
}
