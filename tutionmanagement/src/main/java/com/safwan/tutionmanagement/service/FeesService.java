package com.safwan.tutionmanagement.service;

import com.safwan.tutionmanagement.modal.Fees;
import com.safwan.tutionmanagement.repo.FeesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FeesService {

    @Autowired
    private FeesRepository feesRepository;

    public Fees saveFees(Fees fees) {
        return feesRepository.save(fees);
    }

    public List<Fees> getAllFees() {
        return feesRepository.findAll();
    }

    public Fees getFeesById(Long id) {
        return feesRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Fees not found with id: " + id));
    }

    public void deleteFees(Long id) {
        feesRepository.deleteById(id);
    }

    public Fees updateFees(Long id, Fees fees) {
        Fees newFees = getFeesById(id);
        newFees.setAmount(fees.getAmount());
        newFees.setDate(fees.getDate());
        newFees.setMonth(fees.getMonth());
        newFees.setStudent(fees.getStudent());
        newFees.setPaymentMode(fees.getPaymentMode());

        return feesRepository.save(newFees);
    }
}
