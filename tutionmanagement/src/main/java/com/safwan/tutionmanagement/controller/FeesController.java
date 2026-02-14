package com.safwan.tutionmanagement.controller;

import com.safwan.tutionmanagement.modal.Fees;
import com.safwan.tutionmanagement.modal.Report;
import com.safwan.tutionmanagement.service.FeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fees")
@CrossOrigin("*")
public class FeesController {

    @Autowired
    private FeesService feesService;

    @PostMapping("/add")
    public ResponseEntity<Fees> addFees(@RequestBody Fees fees) {
        return ResponseEntity.ok(feesService.saveFees(fees));
    }

    @GetMapping("/all")
    public ResponseEntity<List<Fees>> getAllFees() {
        return ResponseEntity.ok(feesService.getAllFees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fees> getFeesById(@PathVariable Long id) {
        Fees fees = feesService.getFeesById(id);
        return new ResponseEntity<>(fees, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteFees(@PathVariable Long id) {
        feesService.deleteFees(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateFees(@PathVariable Long id, @RequestBody Fees fees) {
        Fees newFees = feesService.updateFees(id, fees);
        if(newFees != null){
            return new ResponseEntity<>("Fees Updated.", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update fees.", HttpStatus.BAD_REQUEST);
        }
    }
}

