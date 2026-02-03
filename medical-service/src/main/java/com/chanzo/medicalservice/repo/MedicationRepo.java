package com.chanzo.medicalservice.repo;

import com.chanzo.medicalservice.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicationRepo extends JpaRepository<Medication,Integer> {

    Optional<Medication> findByTagNumber(String tagNumber);
}
