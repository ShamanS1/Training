package com.TMS1.Training.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Responsedto {
    private Trainerdto flightdto;
    private List<Trainingdto> passengerdto;
}
