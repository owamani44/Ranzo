package com.chanzo.medicalservice.repo;

import com.chanzo.medicalservice.model.FollowUp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowUpRepo extends JpaRepository<FollowUp, Integer> {
}
