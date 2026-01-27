package com.chanzo.animalregistryservice.repo;

import com.chanzo.animalregistryservice.model.AnimalOutbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimalOutboxRepo extends JpaRepository<AnimalOutbox,Integer> {
}
