package com.safwan.tutionmanagement.modal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repId;

    @ManyToOne
    @JoinColumn(name = "stdId")
    private Student student;

    @OneToMany(mappedBy = "reportCard", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ReportMarks> reportMarks;
    private String month;
    private LocalDate date;
    private String year;

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public Long getRepId() {
        return repId;
    }

    public void setRepId(Long repId) {
        this.repId = repId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<ReportMarks> getReportMarks() {
        return reportMarks;
    }

    public void setReportMarks(List<ReportMarks> reportMarks) {
        this.reportMarks = reportMarks;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
