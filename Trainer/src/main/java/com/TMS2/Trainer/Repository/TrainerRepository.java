package com.TMS2.Trainer.Repository;

import com.TMS2.Trainer.Model.Trainer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrainerRepository extends JpaRepository<Trainer, Long> {

    List<Trainer> findByTrainerId(Long trainerId);
}
