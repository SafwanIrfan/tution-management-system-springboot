package com.safwan.tutionmanagement.modal;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;


@Entity
public class ReportMarks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repMarksId;

    private String subjectName;
    private Double maxMarks;
    private Double totalMarks;
    private String grade;
    private Double percentage;

    @ManyToOne
    @JoinColumn(name = "rep_Id", nullable = false)
    @JsonIgnore
    private Report reportCard;

    @PrePersist //Automatically executed before inserting data into database managed by JPA
    @PreUpdate //Automatically executed before updating data into database managed by JPA
    public void calculateGradeAndPercentage() {
        if (maxMarks != null && totalMarks != null && maxMarks > 0) {
            this.percentage = (totalMarks / maxMarks) * 100;
            if (percentage >= 90)
                this.grade = "A+";
            else if (percentage >= 80)
                this.grade = "A";
            else if (percentage >= 70)
                this.grade = "B";
            else if (percentage >= 60)
                this.grade = "C";
            else if (percentage >= 50)
                this.grade = "D";
            else
                this.grade = "F";
        }
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Long getRepMarksId() {
        return repMarksId;
    }

    public void setRepMarksId(Long repMarksId) {
        this.repMarksId = repMarksId;
    }

    public Double getMaxMarks() {
        return maxMarks;
    }

    public void setMaxMarks(Double maxMarks) {
        this.maxMarks = maxMarks;
    }

    public Double getTotalMarks() {
        return totalMarks;
    }

    public void setTotalMarks(Double totalMarks) {
        this.totalMarks = totalMarks;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public Double getPercentage() {
        return percentage;
    }

    public void setPercentage(Double percentage) {
        this.percentage = percentage;
    }

    public Report getReportCard() {
        return reportCard;
    }

    public void setReportCard(Report reportCard) {
        this.reportCard = reportCard;
    }

}
