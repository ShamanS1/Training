package com.TMS1.Training.Controller;

import com.TMS1.Training.Model.Trainings;
import com.TMS1.Training.Service.TrainingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/trainings")
public class TrainingController {

    @Autowired
    private TrainingService trainingService;

    @PostMapping("/create")
    public ResponseEntity<Trainings> createTraining(@RequestBody Trainings training) {
        Trainings createdTraining = trainingService.createTraining(training);
        return ResponseEntity.ok(createdTraining);
    }

    @GetMapping("")
    public ResponseEntity<List<Trainings>> getAllTrainings() {
        return ResponseEntity.ok(trainingService.getAllTraining());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Trainings>> getTrainingById(@PathVariable Long id) {
        return ResponseEntity.ok(trainingService.getTrainingById(id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteTraining(@PathVariable Long id) {
        trainingService.deleteTraining(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Trainings> updateTraining(@RequestBody Trainings training) {
        return ResponseEntity.ok(trainingService.updateTraining(training));
    }

    @GetMapping("/skill/{skills}")
    public ResponseEntity<List<Trainings>> getBySkill(@PathVariable String skills) {
        return ResponseEntity.ok(trainingService.getBySkill(skills));
    }

    @GetMapping("/org/{orgName}")
    public ResponseEntity<List<Trainings>> getByOrgName(@PathVariable String orgName) {
        return ResponseEntity.ok(trainingService.getByOrgName(orgName));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getTrainingCountWithinDateRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return ResponseEntity.ok(trainingService.getTrainingCountWithinDateRange(startDate, endDate));
    }

    @GetMapping("/date-range")
    public ResponseEntity<List<Trainings>> getTrainingsWithinDateRange(@RequestParam LocalDate startDate, @RequestParam LocalDate endDate) {
        return ResponseEntity.ok(trainingService.getTrainingsWithinDateRange(startDate, endDate));
    }
}
