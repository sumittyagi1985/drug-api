package com.test.drugapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.drugapi.model.Drug;
import com.test.drugapi.repository.DrugRepository;

@Service
public class DrugService {
    @Autowired
    private DrugRepository drugRepository;

    public List<Drug> getAllDrugs() {
        return drugRepository.findAll();
    }

    public Optional<Drug> getDrugById(Long id) {
        return drugRepository.findById(id);
    }

    public Drug saveDrug(Drug drug) {
        return drugRepository.save(drug);
    }

    public void deleteDrug(Long id) {
        drugRepository.deleteById(id);
    }
}