package com.safwan.tutionmanagement.controller;

import com.safwan.tutionmanagement.modal.ReportMarks;
import com.safwan.tutionmanagement.service.ReportMarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reportmarks")
@CrossOrigin("*")
public class ReportMarksController {

    @Autowired
    private ReportMarksService reportMarksService;

    @PostMapping("/add")
    public ResponseEntity<ReportMarks> addReportMarks(@RequestBody ReportMarks reportMarks) {
        return ResponseEntity.ok(reportMarksService.saveReportMarks(reportMarks));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReportMarks>> getAllReportMarks() {
        return ResponseEntity.ok(reportMarksService.getAllReportMarks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportMarks> getReportMarksById(@PathVariable Long id) {
        return reportMarksService.getReportMarksById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReportMarks(@PathVariable Long id) {
        reportMarksService.deleteReportMarks(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update")
    public ResponseEntity<ReportMarks> updateReportMarks(@RequestBody ReportMarks reportMarks) {
        return ResponseEntity.ok(reportMarksService.saveReportMarks(reportMarks));
    }
}
