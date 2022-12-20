package com.example.fmssfinalproject.dto.request;



import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreateUpdateLeaveRequest {

    @NotBlank(message = "from-date must not be blank.")
    private LocalDate fromDate;


    @NotBlank(message = "to-date must not be blank.")
    private LocalDate toDate;


    @NotNull(message = "employee-id must not be null")
    private Long employeeId;

    @NotBlank(message = "Description should not blank.")
    private String description;


}
