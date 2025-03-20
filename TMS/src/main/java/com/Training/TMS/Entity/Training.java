package com.Training.TMS.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Training {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainingId;
    private List<String> skills = new ArrayList<>();
    private LocalDate startDate;
    private LocalDate endDate;
    private Long numOfBatches;
    private Long numOfStudentsPerBatch;
    private String toc;
    private String poc;
    private Double budget;
    private String email;
    private Long phoneNumber;
    private String orgName;
    private String name;

    @Enumerated(EnumType.STRING)
    private TrainingStatus status;

    @Enumerated(EnumType.STRING)
    private StudentType studentType;

    @Enumerated(EnumType.STRING)
    private Duration duration;

    public enum Duration{
        hours,days,months
    }
    public enum StudentType{
        lateral,fresher
    }

    public enum TrainingStatus{
        ON_HOLD,IN_PROGRESS,COMPLETED,UPCOMING
    }
    @PrePersist
    @PreUpdate
    public void updateTrainingStatus() {
        LocalDate today = LocalDate.now();
        if (startDate == null || endDate == null) {
            this.status = TrainingStatus.ON_HOLD;
        } else if (today.isBefore(startDate)) {
            this.status = TrainingStatus.UPCOMING;
        } else if (today.isAfter(endDate)) {
            this.status = TrainingStatus.COMPLETED;
        } else {
            this.status = TrainingStatus.IN_PROGRESS;
        }
    }
}


