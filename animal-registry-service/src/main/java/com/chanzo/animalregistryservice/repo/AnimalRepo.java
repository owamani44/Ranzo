package com.chanzo.animalregistryservice.repo;

import com.chanzo.animalregistryservice.model.Animal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepo extends JpaRepository<Animal,Long> {
    boolean existsByTagNumber(@NotBlank @Size(min = 6 , max=6 , message = "Tag Number should be valid") String tagNumber);
}
