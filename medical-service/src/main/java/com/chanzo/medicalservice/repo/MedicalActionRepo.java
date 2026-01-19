package com.chanzo.medicalservice.repo;

import com.chanzo.medicalservice.model.MedicalAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicalActionRepo extends JpaRepository<MedicalAction,Integer> {
}
