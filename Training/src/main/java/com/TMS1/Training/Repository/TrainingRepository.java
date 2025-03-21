package com.TMS1.Training.Repository;

import com.TMS1.Training.Model.Trainings;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Trainings, Long> {
    List<Trainings> findBySkillsContaining(String skill);

    List<Trainings> findByOrgName(String orgName);

    List<Trainings> findByStartDateBetween(LocalDate startDate, LocalDate endDate);

    long countByStartDateBetween(LocalDate startDate, LocalDate endDate);

}

