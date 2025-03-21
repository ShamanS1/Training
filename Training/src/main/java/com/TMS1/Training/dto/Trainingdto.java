package com.TMS1.Training.dto;

import com.TMS1.Training.Model.Trainings;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trainingdto {
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
    private Trainings.TrainingStatus status;

    @Enumerated(EnumType.STRING)
    private Trainings.Duration duration;

    @Enumerated(EnumType.STRING)
    private Trainings.TraineeType Type;
}
