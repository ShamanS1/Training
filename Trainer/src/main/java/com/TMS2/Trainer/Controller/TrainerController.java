package com.TMS2.Trainer.Controller;

import com.TMS2.Trainer.Model.Trainer;
import com.TMS2.Trainer.Service.TrainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trainerinfo")
public class TrainerController {


    @Autowired
    private TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }
    @PostMapping("/trainer")
    public Trainer addTrainer(@RequestBody Trainer trainer) {

        return trainerService.addTrainer(trainer);
    }

    @GetMapping("{trainerId}")
    public List<Trainer> getTrainerInfo(@PathVariable Long trainerId) {
        return trainerService.getTrainerInfo(trainerId);
    }

    @GetMapping("/all")
    public List<Trainer> getAllTrainer(){
        return trainerService.getAllTrainer();
    }
}
