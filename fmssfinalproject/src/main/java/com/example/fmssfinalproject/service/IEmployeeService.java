package com.example.fmssfinalproject.service;

import com.example.fmssfinalproject.dto.request.CreateUpdateEmployeeRequest;
import com.example.fmssfinalproject.dto.response.EmployeeDto;

import java.util.List;

public interface IEmployeeService {

    EmployeeDto saveEmployee(CreateUpdateEmployeeRequest createEmployeeRequest);

    void deleteEmployeeById(Long id);

    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long employeeId, CreateUpdateEmployeeRequest updateEmployeeRequest);

}
