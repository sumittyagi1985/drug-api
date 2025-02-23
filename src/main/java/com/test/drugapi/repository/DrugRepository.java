package com.test.drugapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.drugapi.model.Drug;

public interface DrugRepository extends JpaRepository<Drug, Long> {
}