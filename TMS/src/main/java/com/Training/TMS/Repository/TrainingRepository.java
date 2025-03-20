package com.Training.TMS.Repository;

import com.Training.TMS.Entity.Training;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.time.LocalDate;
import java.util.List;

@Repository
public interface TrainingRepository extends JpaRepository<Training,Long> {
    List<Training> findBySkillsContaining(String skill);
    List<Training> findByOrgName(String orgName);
    List<Training> findByStartDateBetween(LocalDate startDate, LocalDate endDate);
    long countByStartDateBetween(LocalDate startDate, LocalDate endDate);

}
