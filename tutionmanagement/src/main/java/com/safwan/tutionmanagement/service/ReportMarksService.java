package com.safwan.tutionmanagement.service;

import com.safwan.tutionmanagement.modal.Report;
import com.safwan.tutionmanagement.modal.ReportMarks;
import com.safwan.tutionmanagement.repo.ReportMarksRepository;
import com.safwan.tutionmanagement.repo.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReportMarksService {

    @Autowired
    private ReportMarksRepository reportMarksRepository;

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private ReportService reportService;

    public String saveReportMarks(Long repId, ReportMarks[] reportMarks) {
        Report report = reportService.getReportById(repId);
        if (report == null) {
            throw new RuntimeException("Report not found");
        }

        for (ReportMarks repmark : reportMarks){
            ReportMarks newRepMarks = new ReportMarks();
            newRepMarks.setReportCard(report);
            report.getReportMarks().add(repmark);
        }

        reportRepository.save(report);
        return "Report Marks Saved.";
    }

    public List<ReportMarks> getAllReportMarks() {
        return reportMarksRepository.findAll();
    }

    public ReportMarks getReportMarksById(Long id) {
        return reportMarksRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report Marks not found of report marks id: " + id));
    }

//    public List<ReportMarks> getReportMarksByRepId(Long repId) {
//        return reportMarksRepository.findByRepId(repId)
//                .orElseThrow(() -> new RuntimeException("Report Marks not found of report id: " + repId));
//    }


    public void deleteReportMarks(Long id) {
        reportMarksRepository.deleteById(id);
    }
}
