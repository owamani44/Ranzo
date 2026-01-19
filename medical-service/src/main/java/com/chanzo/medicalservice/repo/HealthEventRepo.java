package com.chanzo.medicalservice.repo;

import com.chanzo.medicalservice.model.HealthEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HealthEventRepo extends JpaRepository<HealthEvent,Integer> {
    List<HealthEvent> eventID(Integer eventID);
}
