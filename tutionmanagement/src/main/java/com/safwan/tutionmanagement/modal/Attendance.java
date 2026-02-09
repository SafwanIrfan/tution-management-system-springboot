package com.safwan.tutionmanagement.modal;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attId;

    @ManyToOne
    @JoinColumn(name = "stdId")
    private Student student;

    private Integer isPresent; // 1 for present, 0 for absent
    private LocalDate date;
}
