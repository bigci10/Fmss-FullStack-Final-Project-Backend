package com.example.fmssfinalproject.dto.request;

import com.example.fmssfinalproject.model.enums.ExpenseType;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreateUpdateExpenseRequest {

    @NotNull(message = "expense-type should not null.")
    private ExpenseType expenseType;


    @NotBlank(message = "expense-date must not blank.")
    private LocalDate expenseDate;


    @NotBlank(message = "Description should not blank.")
    private String expenseDescription;


    @Min(value = 0, message = "Amount should not be less than 0.")
    @NotBlank(message = "Amount should not blank.")
    private BigDecimal expenseAmount;


    @NotNull(message = "employee-id must not be null.")
    private Long employeeId;
}
