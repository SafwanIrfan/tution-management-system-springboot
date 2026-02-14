package com.safwan.tutionmanagement.controller;

import com.safwan.tutionmanagement.modal.Attendance;
import com.safwan.tutionmanagement.modal.Report;
import com.safwan.tutionmanagement.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/report")
@CrossOrigin("*")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @PostMapping("/add")
    public ResponseEntity<Report> addReport(@RequestBody Report report) {
        return ResponseEntity.ok(reportService.saveReport(report));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Report>> getAllReports() {
        return ResponseEntity.ok(reportService.getAllReports());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Report> getReportById(@PathVariable Long id) {
        Report report = reportService.getReportById(id);
        return new ResponseEntity<>(report, HttpStatus.OK);

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateReport(@PathVariable Long id, @RequestBody Report report) {
        Report newAtt = reportService.updateReport(id, report);
        if(newAtt != null){
            return new ResponseEntity<>("Report Updated", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update report", HttpStatus.BAD_REQUEST);
        }
    }
}
