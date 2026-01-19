package com.chanzo.medicalservice.repo;

import com.chanzo.medicalservice.model.TreatmentPlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreatmentPlanRepo extends JpaRepository<TreatmentPlan, Integer> {
}
