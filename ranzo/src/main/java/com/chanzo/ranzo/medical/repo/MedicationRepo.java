package com.chanzo.ranzo.medical.repo;

import com.chanzo.ranzo.medical.model.Medication;
import com.chanzo.ranzo.medical.model.MedicationStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MedicationRepo extends JpaRepository<Medication,Integer> {

    Optional<Medication> findByTagNumber(String tagNumber);

    int countByStatus(MedicationStatus medicationStatus);
}
