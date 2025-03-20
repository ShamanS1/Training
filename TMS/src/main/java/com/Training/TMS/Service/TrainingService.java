package com.Training.TMS.Service;

import com.Training.TMS.Entity.Training;
import com.Training.TMS.Repository.TrainingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    public Training createTraining(Training training){
        return trainingRepository.save(training);

    }
    public List<Training> getAllTraining(){
        return trainingRepository.findAll();
    }

    public Optional<Training> getTrainingById(Long id) {
        return trainingRepository.findById(id);
    }

    public void deleteTraining(Long id){
        trainingRepository.deleteById(id);
    }

    public Training updateTraining(Training training){
        return trainingRepository.save(training);
    }

    public List<Training> getBySkill(String skills){
        return trainingRepository.findBySkillsContaining(skills);
    }

    public List<Training> getByOrgName(String orgName){
        return trainingRepository.findByOrgName(orgName);
    }

    public long getTrainingCountWithinDateRange(LocalDate startDate, LocalDate endDate) {
        return trainingRepository.countByStartDateBetween(startDate, endDate);
    }

    public List<Training> getTrainingsWithinDateRange(LocalDate startDate, LocalDate endDate) {
        return trainingRepository.findByStartDateBetween(startDate, endDate);
    }

}
