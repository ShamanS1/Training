package com.TMS1.Training.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trainerdto {
    private Long trainerId;
    private String flightNumber;
    private String vendorName;
    private String vendorLocation;
    private int duration; // Duration in minutes
    private double price;
    //private String;
}




