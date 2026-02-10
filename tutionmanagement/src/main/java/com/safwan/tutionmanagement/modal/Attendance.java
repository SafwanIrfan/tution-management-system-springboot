package com.safwan.tutionmanagement.modal;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
public class Attendance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attId;

    @ManyToOne
    @JoinColumn(name = "stdId")
    private Student student;

    private Integer isPresent; // 1 for present, 0 for absent
    private LocalDate date;

    public Long getAttId() {
        return attId;
    }

    public void setAttId(Long attId) {
        this.attId = attId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Integer getIsPresent() {
        return isPresent;
    }

    public void setIsPresent(Integer isPresent) {
        this.isPresent = isPresent;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
