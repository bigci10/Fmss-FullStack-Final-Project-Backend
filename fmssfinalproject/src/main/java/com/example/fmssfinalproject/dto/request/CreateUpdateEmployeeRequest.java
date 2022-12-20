package com.example.fmssfinalproject.dto.request;


import com.example.fmssfinalproject.model.enums.Department;
import com.example.fmssfinalproject.model.enums.Role;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class CreateUpdateEmployeeRequest {
    @NotBlank(message = "Name cannot empty")
    private String name;

    @NotBlank(message = "Surname cannot empty")
    private String surname;

    @Email(regexp = "^(.+)@(.+)$", message = "Email is not valid. Please follow the example: turkcell@mail.com")
    @NotBlank(message = "Email must not be blank")
    private String email;


    @NotNull(message = "Role must not be null.")
    private Role role;

    @Min(value = 0, message = "Salary should not be less than 0.")
    private BigDecimal salary;

    @NotNull(message = "Department not be null.")
    private Department department;

    @NotBlank(message = "Start date must not be blank")
    private LocalDate dateOfStart;

    @NotBlank(message = "Birthdate must not be blank")
    private LocalDate birthDate;

    @NotBlank(message = "Addres must not be blank")
    private CreateUpdateAddressRequest address;

}
