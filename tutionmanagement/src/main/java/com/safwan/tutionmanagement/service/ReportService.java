package com.safwan.tutionmanagement.service;

import com.safwan.tutionmanagement.modal.Report;
import com.safwan.tutionmanagement.repo.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public Report saveReport(Report report) {
        return reportRepository.save(report);
    }

    public List<Report> getAllReports() {
        return reportRepository.findAll();
    }

    public Report getReportById(Long id) {
        return reportRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Report not found, id: " + id));
    }

    public void deleteReport(Long id) {
        reportRepository.deleteById(id);
    }
}
