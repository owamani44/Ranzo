package com.chanzo.animalregistryservice.kafka;

import com.chanzo.animalregistryservice.model.AnimalOutbox;
import com.chanzo.animalregistryservice.repo.AnimalOutboxRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@EnableScheduling
public class PollerService {

    private AnimalOutboxRepo animalOutboxRepo;
    @Scheduled(fixedRate = 10000)
    public void pollOutboxAndPublish(){

        /**fetch registered animals**/
        List<AnimalOutbox> notRegistered = animalOutboxRepo.findByRegisteredFalse();

        /**publish to kafka**/
    }

}
