package com.example.fmssfinalproject.dto.response;


import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class LeaveDto {
    private Long id;

    private LocalDate fromDate;

    private LocalDate toDate;

    private Long employeeId;

    private String description;
}
