package com.safwan.tutionmanagement.modal;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Fees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feesId;

    @ManyToOne
    @JoinColumn(name = "stdId")
    private Student student;

    private String issuedBy;
    private Double amount;
    private String month;
    private LocalDate date;
    private String paymentMode;
}
