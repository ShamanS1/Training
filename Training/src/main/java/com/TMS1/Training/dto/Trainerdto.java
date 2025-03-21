package com.TMS1.Training.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trainerdto {
    private Long trainerId;
    private String trainerName;
    private String phoneNo;
    private List<String> skills = new ArrayList<>();
    private String email;
    private String experience;
    //List<> schedule = new ArrayList<>();
    private Double minFee;
    private Double maxFee;
    private String trainingId;

    @Enumerated(EnumType.STRING)
    private TrainerStatus trainerStatus;

    @Enumerated(EnumType.STRING)
    private SalaryType salaryType;

    public enum TrainerStatus {
        available, unavailable
    }

    public enum SalaryType {
        daily, weekly, monthly
    }
}




