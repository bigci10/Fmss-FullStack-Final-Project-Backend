package com.example.fmssfinalproject.model;

import lombok.*;


import javax.persistence.*;

@Data
@Entity
@Table(name = "adress")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Address {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String adress;


    private String city;


    private String country;

    private int postalCode;

    @OneToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
