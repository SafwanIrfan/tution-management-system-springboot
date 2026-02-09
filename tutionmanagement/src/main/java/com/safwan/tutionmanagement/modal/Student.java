package com.safwan.tutionmanagement.modal;

import jakarta.persistence.*;
import lombok.Data;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long stdId;
    private String stdName;
    private String fatherName;
    private String phoneNo;
    @Column(name = "class_study")
    private Integer classStudy;
    @Column(name = "group_name")
    private String groupName;

    public Long getStdId() {
        return stdId;
    }

    public void setStdId(Long stdId) {
        this.stdId = stdId;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getStdName() {
        return stdName;
    }

    public void setStdName(String stdName) {
        this.stdName = stdName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public Integer getClassStudy() {
        return classStudy;
    }

    public void setClassStudy(Integer classStudy) {
        this.classStudy = classStudy;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Integer getClassesPerWeek() {
        return classesPerWeek;
    }

    public void setClassesPerWeek(Integer classesPerWeek) {
        this.classesPerWeek = classesPerWeek;
    }

    public String getPaymentOption() {
        return paymentOption;
    }

    public void setPaymentOption(String paymentOption) {
        this.paymentOption = paymentOption;
    }

    private Integer classesPerWeek;
    private String paymentOption;
}
