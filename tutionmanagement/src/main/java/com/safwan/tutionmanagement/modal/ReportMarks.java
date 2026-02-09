package com.safwan.tutionmanagement.modal;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class ReportMarks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repMarksId;

    private String subjectName;
    private Double maxMarks;
    private Double totalMarks;
    private String grade;
    private Double percentage;

    @PrePersist
    @PreUpdate
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
}
