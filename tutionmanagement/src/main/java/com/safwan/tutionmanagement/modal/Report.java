package com.safwan.tutionmanagement.modal;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long repId;

    @ManyToOne
    @JoinColumn(name = "stdId")
    private Student student;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "repMarksId")
    private ReportMarks reportMarks;

    private String year;
    private String month;
    private LocalDate date;
}
