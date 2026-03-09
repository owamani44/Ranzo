package com.chanzo.ranzo.weight.repo;

import com.chanzo.ranzo.weight.model.Weight;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WeightRepo extends JpaRepository<Weight,Integer> {
    boolean existsByTagNumber(@NotBlank String tagNumber);

    Optional<Weight> findByTagNumber(String tagNumber);
    @Query("SELECT COALESCE(SUM(w.weight),0) FROM Weight w")
    Double getTotalWeight();


}
