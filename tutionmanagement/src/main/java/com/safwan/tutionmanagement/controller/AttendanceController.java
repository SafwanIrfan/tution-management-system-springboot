package com.safwan.tutionmanagement.controller;

import com.safwan.tutionmanagement.modal.Attendance;
import com.safwan.tutionmanagement.modal.Student;
import com.safwan.tutionmanagement.repo.StudentRepository;
import com.safwan.tutionmanagement.service.AttendanceService;
import com.safwan.tutionmanagement.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/attendance")
@CrossOrigin("*")
public class AttendanceController {

    @Autowired
    private AttendanceService attendanceService;

    @Autowired
    private StudentService studentService;

    @PostMapping("/add/{stdId}")
    public ResponseEntity<Attendance> addAttendance(@PathVariable String stdId, @RequestBody Attendance attendance) {
        Student student = studentService
                .getStudentById(stdId)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        Attendance savedAttendance =
                attendanceService.saveAttendance(attendance, student);

        return ResponseEntity.ok(savedAttendance);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Attendance>> getAllAttendance() {
        return ResponseEntity.ok(attendanceService.getAllAttendance());
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Attendance> getAttendanceById(@PathVariable Long id) {
        return attendanceService.getAttendanceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<Attendance>> getAttendanceByDate(@PathVariable LocalDate date) {
        return attendanceService.getAttendanceByDate(date)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAttendance(@PathVariable Long id) {
        attendanceService.deleteAttendance(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateAttendance(@PathVariable Long id, @RequestBody Attendance attendance) {
        Attendance newAtt = attendanceService.updateAttendance(id, attendance);
        if(newAtt != null){
            return new ResponseEntity<>("Attendance Updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update attendance", HttpStatus.BAD_REQUEST);
        }
    }
}
