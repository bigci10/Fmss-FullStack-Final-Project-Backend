package com.example.fmssfinalproject.dto.response;

import com.example.fmssfinalproject.dto.request.CreateUpdateAddressRequest;
import com.example.fmssfinalproject.model.enums.Department;
import com.example.fmssfinalproject.model.enums.Role;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class EmployeeDto {


    private Long id;

    private String name;

    private String surname;

    private String email;

    private int phoneNumber;

    private Role role;

    private BigDecimal salary;

    private Department department;

    private LocalDate dateOfStart;

    private LocalDate birthDate;

    private AddressDto address;

}
