package com.TMS1.Training.Service;

import com.TMS1.Training.Model.Trainings;
import com.TMS1.Training.Repository.TrainingRepository;
import com.TMS1.Training.dto.Trainingdto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class TrainingService {

    @Autowired
    private TrainingRepository trainingRepository;

    public Trainings createTraining(Trainings training) {
        return trainingRepository.save(training);

    }

    public List<Trainings> getAllTraining() {
        return trainingRepository.findAll();
    }

    public Optional<Trainings> getTrainingById(Long id) {
        return trainingRepository.findById(id);
    }

    public void deleteTraining(Long id) {
        trainingRepository.deleteById(id);
    }

    public Trainings updateTraining(Trainings training) {
        return trainingRepository.save(training);
    }

    public List<Trainings> getBySkill(String skills) {
        return trainingRepository.findBySkillsContaining(skills);
    }

    public List<Trainings> getByOrgName(String orgName) {
        return trainingRepository.findByOrgName(orgName);
    }

    public long getTrainingCountWithinDateRange(LocalDate startDate, LocalDate endDate) {
        return trainingRepository.countByStartDateBetween(startDate, endDate);
    }

    public List<Trainings> getTrainingsWithinDateRange(LocalDate startDate, LocalDate endDate) {
        return trainingRepository.findByStartDateBetween(startDate, endDate);
    }

    private Trainingdto mapToFlightdto(Trainings trainings) {
        Trainingdto trainingdto = new Trainingdto();
        trainingdto.setTrainingId(trainings.getId());
        trainingdto.setFlightNumber(flight.getFlightNumber());
        trainingdto.setAirlinecode(flight.getAirlinecode());
        trainingdto.setDepartureLocation(flight.getDepartureLocation());
        trainingdto.setArrivalLocation(flight.getArrivalLocation());
        trainingdto.setDepartureTime(flight.getDepartureTime());
        trainingdto.setArrivalTime(flight.getArrivalTime());
        trainingdto.setDuration(flight.getDuration());
        trainingdto.setPrice(flight.getPrice());
        trainingdto.setAirline(flight.getAirline());
        return trainingdto;
    }

}
