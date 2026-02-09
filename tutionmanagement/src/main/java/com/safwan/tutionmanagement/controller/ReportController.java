package com.safwan.tutionmanagement.controller;

import com.safwan.tutionmanagement.modal.Report;
import com.safwan.tutionmanagement.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return reportService.getReportById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReport(@PathVariable Long id) {
        reportService.deleteReport(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Report> updateReport(@RequestBody Report report) {
        return ResponseEntity.ok(reportService.saveReport(report));
    }
}
