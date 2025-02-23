package com.test.drugapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.test.drugapi.model.Drug;
import com.test.drugapi.service.DrugService;

@RestController
@RequestMapping("/api/drugs")
public class DrugController {
    @Autowired
    private DrugService drugService;

    @GetMapping
    public List<Drug> getAllDrugs() {
        return drugService.getAllDrugs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Drug> getDrugById(@PathVariable Long id) {
        Optional<Drug> drug = drugService.getDrugById(id);
        return drug.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Drug createDrug(@RequestBody Drug drug) {
        return drugService.saveDrug(drug);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Drug> updateDrug(@PathVariable Long id, @RequestBody Drug drugDetails) {
        Optional<Drug> drug = drugService.getDrugById(id);
        if (drug.isPresent()) {
            Drug updatedDrug = drug.get();
            updatedDrug.setName(drugDetails.getName());
            updatedDrug.setDescription(drugDetails.getDescription());
            return ResponseEntity.ok(drugService.saveDrug(updatedDrug));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDrug(@PathVariable Long id) {
        drugService.deleteDrug(id);
        return ResponseEntity.noContent().build();
    }
}