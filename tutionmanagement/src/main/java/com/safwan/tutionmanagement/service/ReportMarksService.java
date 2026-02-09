package com.safwan.tutionmanagement.service;

import com.safwan.tutionmanagement.modal.ReportMarks;
import com.safwan.tutionmanagement.repo.ReportMarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReportMarksService {

    @Autowired
    private ReportMarksRepository reportMarksRepository;

    public ReportMarks saveReportMarks(ReportMarks reportMarks) {
        return reportMarksRepository.save(reportMarks);
    }

    public List<ReportMarks> getAllReportMarks() {
        return reportMarksRepository.findAll();
    }

    public Optional<ReportMarks> getReportMarksById(Long id) {
        return reportMarksRepository.findById(id);
    }

    public void deleteReportMarks(Long id) {
        reportMarksRepository.deleteById(id);
    }
}
