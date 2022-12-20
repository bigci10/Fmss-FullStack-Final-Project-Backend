package com.example.fmssfinalproject.dto.response;

import com.example.fmssfinalproject.model.enums.ExpenseType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ExpenseDto {

    private Long id;

    private ExpenseType expenseType;

    private LocalDate expenseDate;

    private String expenseDescription;

    private BigDecimal expenseAmount;

    private Long employeeId;
}
