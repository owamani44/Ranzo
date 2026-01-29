package com.chanzo.weightrecordservice.repo;

import com.chanzo.weightrecordservice.model.Weight;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeightRepo extends JpaRepository<Weight,Integer> {
    boolean existsByTagNumber(@NotBlank String tagNumber);

    Optional<Weight> findByTagNumber(String tagNumber);
}
