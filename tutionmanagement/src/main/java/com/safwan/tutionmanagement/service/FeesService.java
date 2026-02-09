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

    public Optional<Fees> getFeesById(Long id) {
        return feesRepository.findById(id);
    }

    public void deleteFees(Long id) {
        feesRepository.deleteById(id);
    }
}
