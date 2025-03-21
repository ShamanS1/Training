package com.TMS2.Trainer.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Trainer {
    @Id
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
