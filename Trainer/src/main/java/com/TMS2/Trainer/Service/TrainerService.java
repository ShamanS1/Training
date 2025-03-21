package com.TMS2.Trainer.Service;

import com.TMS2.Trainer.Model.Trainer;
import com.TMS2.Trainer.Repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TrainerService {
    @Autowired
    private TrainerRepository trainerRepository;

    public Trainer addTrainer(Trainer trainer) {

        return trainerRepository.save(trainer);
    }

    public List<Trainer> getTrainerInfo(Long trainerId) {

        return trainerRepository.findByTrainerId(trainerId);
    }

    public List<Trainer> getAllTrainer() {
        return trainerRepository.findAll();
    }
}
