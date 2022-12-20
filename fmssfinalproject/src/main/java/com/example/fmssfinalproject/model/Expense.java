package com.example.fmssfinalproject.model;

import com.example.fmssfinalproject.model.enums.ExpenseType;

import lombok.*;


import javax.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "employee_expenses")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private ExpenseType expenseType;

    private LocalDate expenseDate;


    private String expenseDescription;


    private BigDecimal expenseAmount;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
