package com.safwan.tutionmanagement.service;

import com.safwan.tutionmanagement.modal.Attendance;
import com.safwan.tutionmanagement.modal.Report;
import com.safwan.tutionmanagement.modal.ReportMarks;
import com.safwan.tutionmanagement.repo.ReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReportService {

    @Autowired
    private ReportRepository reportRepository;

    public Report saveReport(Report report) {
        if (report.getReportMarks() != null) {
            for (ReportMarks mark : report.getReportMarks()) {
                mark.setReportCard(report);
            }
        }
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
        Report report = getReportById(id);

        if(report != null) {
            reportRepository.deleteById(id);
        } else {
            throw new RuntimeException("Report not found while deleting it, id: " + id);
        }
    }

    public Report updateReport(Long id, Report newReport) {
        Report existingRep = getReportById(id);

        //clear old children
        existingRep.getReportMarks().clear();

        //Add new Children
        for (ReportMarks mark : newReport.getReportMarks()){
            mark.setReportCard(existingRep);
            existingRep.getReportMarks().add(mark);
        }

        existingRep.setExamName(newReport.getExamName());
        existingRep.setDate(newReport.getDate());
        existingRep.setMonth(newReport.getMonth());
        existingRep.setYear(newReport.getYear());
        existingRep.setStudent(newReport.getStudent());

        return reportRepository.save(existingRep);
    }
}
