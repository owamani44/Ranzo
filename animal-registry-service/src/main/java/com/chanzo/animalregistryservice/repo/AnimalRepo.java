package com.chanzo.animalregistryservice.repo;

import com.chanzo.animalregistryservice.model.Animal;
import com.chanzo.animalregistryservice.model.AnimalStatus;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnimalRepo extends JpaRepository<Animal,Integer> {
    @Query("SELECT a from Animal a WHERE " +
            "LOWER(a.tagNumber) LIKE LOWER (CONCAT('%',:keyword, '%') )OR " +
            "LOWER(a.breed) LIKE LOWER(CONCAT('%',:keyword,'%') ) OR " +
            "LOWER(a.gender) LIKE LOWER(CONCAT( '%',:keyword,'%')) OR " +
            "LOWER(a.species) LIKE LOWER(CONCAT('%',:keyword,'%')) OR " +
            "LOWER(a.kraalAssignment) LIKE LOWER(CONCAT('%',:keyword,'%')) OR " +
            "LOWER(a.status) LIKE LOWER(CONCAT('%',:keyword,'%'))")
    List<Animal> searchAnimals(String keyword);
    boolean existsByTagNumber(@NotBlank @Size(min = 6 , max=6 ,
            message = "Tag Number should be valid") String tagNumber);


    Optional<Animal> findByTagNumber(String tagNumber);

    Long countAnimalByStatus(AnimalStatus animalStatus);
}
