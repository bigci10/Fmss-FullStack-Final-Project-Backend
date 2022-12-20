package com.example.fmssfinalproject.service.impl;

import com.example.fmssfinalproject.dto.request.CreateUpdateEmployeeRequest;
import com.example.fmssfinalproject.dto.response.EmployeeDto;
import com.example.fmssfinalproject.exception.ResourceNotFoundException;
import com.example.fmssfinalproject.mapper.IEmployeeMapper;

import com.example.fmssfinalproject.model.Employee;
import com.example.fmssfinalproject.repository.EmployeeRepository;
import com.example.fmssfinalproject.service.IEmployeeService;
import lombok.RequiredArgsConstructor;


import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class EmployeeService implements IEmployeeService {

    private final IEmployeeMapper employeeMapper;
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto saveEmployee(CreateUpdateEmployeeRequest createEmployeeRequest) {

        Employee employee = this.employeeRepository.save(
                this.employeeMapper.createEmployeeFromCreateEmployeeRequest(createEmployeeRequest));

        return this.employeeMapper.employeeToDto(employee);
    }

    @Override
    public void deleteEmployeeById(Long id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public EmployeeDto getEmployeeById(Long id) {
        Employee employee = this.employeeRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found"));

        return this.employeeMapper.employeeToDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employeeList = this.employeeRepository.findAll();

        return employeeList.stream()
                .map(this.employeeMapper::employeeToDto)
                .toList();
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, CreateUpdateEmployeeRequest updateEmployeeRequest) {
        Employee employee = this.employeeRepository.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found."));

        this.employeeMapper.updateEmployee(employee, updateEmployeeRequest);

        Employee updatedEmployee = this.employeeRepository.save(employee);

        return this.employeeMapper.employeeToDto(updatedEmployee);
    }
}
