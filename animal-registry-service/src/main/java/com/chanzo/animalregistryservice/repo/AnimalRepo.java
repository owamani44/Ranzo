package com.chanzo.animalregistryservice.repo;

import com.chanzo.animalregistryservice.model.Animal;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnimalRepo extends JpaRepository<Animal,Integer> {
    boolean existsByTagNumber(@NotBlank @Size(min = 6 , max=6 ,
            message = "Tag Number should be valid") String tagNumber);


    Optional<Animal> findByTagNumber(String tagNumber);
}
