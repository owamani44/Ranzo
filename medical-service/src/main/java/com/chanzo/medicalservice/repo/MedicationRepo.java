package com.chanzo.medicalservice.repo;

import com.chanzo.medicalservice.model.Medication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepo extends JpaRepository<Medication,Integer> {
}
