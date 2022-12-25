package com.example.fmssfinalproject.controller;


import com.example.fmssfinalproject.dto.request.CreateUpdateEmployeeRequest;

import com.example.fmssfinalproject.dto.response.EmployeeDto;
import com.example.fmssfinalproject.service.IEmployeeService;
import lombok.RequiredArgsConstructor;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/employees")
@CrossOrigin
public class EmployeeController {
    private final IEmployeeService employeeService;

    @PostMapping
    ResponseEntity<EmployeeDto> saveEmployee(@Valid @RequestBody CreateUpdateEmployeeRequest createEmployeeRequest) {
        EmployeeDto employeeDto = this.employeeService.saveEmployee(createEmployeeRequest);

        return ResponseEntity.ok(employeeDto);
    }

    @GetMapping
    ResponseEntity<List<EmployeeDto>> getAllEmployees() {
        if (CollectionUtils.isEmpty(this.employeeService.getAllEmployees()))
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(this.employeeService.getAllEmployees());
    }

    @GetMapping("/{id}")
    ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id) {
        EmployeeDto employee = this.employeeService.getEmployeeById(id);


        return ResponseEntity.ok(employee);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteEmployeeById(@PathVariable Long id) {
        this.employeeService.deleteEmployeeById(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @Valid @RequestBody CreateUpdateEmployeeRequest updateEmployeeRequest) {
        EmployeeDto updatedEmployee = this.employeeService.updateEmployee(id, updateEmployeeRequest);

        return ResponseEntity.ok(updatedEmployee);
    }


}
