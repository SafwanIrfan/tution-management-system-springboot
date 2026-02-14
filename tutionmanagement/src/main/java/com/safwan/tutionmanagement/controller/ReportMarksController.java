package com.safwan.tutionmanagement.controller;

import com.safwan.tutionmanagement.modal.Report;
import com.safwan.tutionmanagement.modal.ReportMarks;
import com.safwan.tutionmanagement.service.ReportMarksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reportmarks")
@CrossOrigin("*")
public class ReportMarksController {

    @Autowired
    private ReportMarksService reportMarksService;

    @PostMapping("/add/{repId}")
    public ResponseEntity<String> addReportMarks(@PathVariable Long repId, @RequestBody ReportMarks reportMarks) {
        return ResponseEntity.ok(reportMarksService.saveReportMarks(repId, reportMarks));
    }

    @GetMapping("/all")
    public ResponseEntity<List<ReportMarks>> getAllReportMarks() {
        return ResponseEntity.ok(reportMarksService.getAllReportMarks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReportMarks> getReportMarksById(@PathVariable Long id) {
        ReportMarks reportMarks = reportMarksService.getReportMarksById(id);
        return new ResponseEntity<>(reportMarks, HttpStatus.OK);

    }

//    @GetMapping("report/{repId}")
//    public ResponseEntity<List<ReportMarks>> getReportMarksByRepId(@PathVariable Long repId) {
//        List<ReportMarks> reportMarks = reportMarksService.getReportMarksByRepId(repId);
//        return new ResponseEntity<>(reportMarks, HttpStatus.OK);
//    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteReportMarks(@PathVariable Long id) {
        reportMarksService.deleteReportMarks(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateReportMarks(@PathVariable Long id,  @RequestBody ReportMarks reportMarks) {
        ReportMarks newRepMarks = reportMarksService.updateReportMarks(id, reportMarks);
        if(newRepMarks != null){
            return new ResponseEntity<>("Report Marks Updated.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update report marks.", HttpStatus.BAD_REQUEST);
        }

        }
}
