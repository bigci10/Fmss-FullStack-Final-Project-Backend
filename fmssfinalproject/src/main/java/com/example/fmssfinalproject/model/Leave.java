package com.example.fmssfinalproject.model;


import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "leave")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Leave {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private LocalDate fromDate;


    private LocalDate toDate;


    private String description;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


}
