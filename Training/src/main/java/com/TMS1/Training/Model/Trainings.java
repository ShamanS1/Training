package com.TMS1.Training.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Trainings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trainingId;
    private List<String> skills = new ArrayList<>();
    private LocalDate startDate;
    private LocalDate endDate;
    private Long numOfBatches;
    private Long numOfStudentsPerBatch;
    private String toc;
    private Double budget;
    private String email;
    private String vendorId;
    private String name;
    private String representative_name;
    private String representative_email;
    private String representative_phone;

    @Enumerated(EnumType.STRING)
    private TrainingStatus status;

    @Enumerated(EnumType.STRING)
    private Duration duration;

    @Enumerated(EnumType.STRING)
    private TraineeType Type;

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

        updateDuration();
    }

    private void updateDuration() {
        if (startDate != null && endDate != null) {
            long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);

            if (daysBetween <= 1) {
                this.duration = Duration.HOURS;
            } else if (daysBetween <= 30) {
                this.duration = Duration.DAYS;
            } else {
                this.duration = Duration.MONTHS;
            }
        } else {
            this.duration = null; // Default to null if dates are missing
        }
    }

    public enum Duration {
        HOURS, DAYS, MONTHS
    }

    public enum TraineeType {
        LATERAL, FRESHER
    }

    public enum TrainingStatus {
        ON_HOLD, IN_PROGRESS, COMPLETED, UPCOMING
    }
}
