package com.safwan.tutionmanagement.modal;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
public class Fees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long feesId;

    @ManyToOne
    @JoinColumn(name = "stdId")
    private Student student;
    private String month;
    private LocalDate date;
    private String paymentMode;
    private Double amount;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getFeesId() {
        return feesId;
    }

    public void setFeesId(Long feesId) {
        this.feesId = feesId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }
}
