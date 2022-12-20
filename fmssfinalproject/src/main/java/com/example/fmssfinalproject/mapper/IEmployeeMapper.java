package com.example.fmssfinalproject.mapper;

import com.example.fmssfinalproject.dto.request.CreateUpdateEmployeeRequest;
import com.example.fmssfinalproject.dto.response.EmployeeDto;

import com.example.fmssfinalproject.model.Employee;


public interface IEmployeeMapper {

    EmployeeDto employeeToDto(Employee employee);

    Employee createEmployeeFromCreateEmployeeRequest(CreateUpdateEmployeeRequest createEmployeeRequest);

    Employee updateEmployee(Employee employee, CreateUpdateEmployeeRequest employeeRequest);

}
