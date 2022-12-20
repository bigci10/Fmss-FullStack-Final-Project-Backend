package com.example.fmssfinalproject.mapper.impl;

import com.example.fmssfinalproject.dto.request.CreateUpdateEmployeeRequest;
import com.example.fmssfinalproject.dto.response.EmployeeDto;
import com.example.fmssfinalproject.mapper.IEmployeeMapper;
import com.example.fmssfinalproject.model.Address;
import com.example.fmssfinalproject.model.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class EmployeeMapperImpl implements IEmployeeMapper
{
    private final AddressMapperImpl addressMapper;
    @Override
    public EmployeeDto employeeToDto(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeDto.EmployeeDtoBuilder<?, ?> employeeDto = EmployeeDto.builder();

        employeeDto.id(employee.getId());
        employeeDto.name( employee.getName() );
        employeeDto.surname( employee.getSurname() );
        employeeDto.email( employee.getEmail() );
        employeeDto.role( employee.getRole() );
        employeeDto.salary( employee.getSalary() );
        employeeDto.department( employee.getDepartment() );
        employeeDto.dateOfStart( employee.getDateOfStart() );
        employeeDto.birthDate( employee.getBirthDate() );
        employeeDto.address( this.addressMapper.addressToDto( employee.getAddress() ) );



        return employeeDto.build();
    }

    @Override
    public Employee createEmployeeFromCreateEmployeeRequest(CreateUpdateEmployeeRequest createEmployeeRequest) {
        if ( createEmployeeRequest == null ) {
            return null;
        }

        Employee.EmployeeBuilder employee = Employee.builder();

        employee.name( createEmployeeRequest.getName() );
        employee.surname( createEmployeeRequest.getSurname() );
        employee.email( createEmployeeRequest.getEmail() );
        employee.salary( createEmployeeRequest.getSalary() );
        employee.role( createEmployeeRequest.getRole() );
        employee.department( createEmployeeRequest.getDepartment() );
        employee.dateOfStart( createEmployeeRequest.getDateOfStart() );
        employee.birthDate( createEmployeeRequest.getBirthDate() );
        employee.address( this.addressMapper.createAddressFromCreateAddresRequest( createEmployeeRequest.getAddress() ) );

        Employee employee1 = employee.build();
        employee1.getAddress().setEmployee(employee1);
        return employee1;
    }

    @Override
    public Employee updateEmployee(Employee employee, CreateUpdateEmployeeRequest employeeRequest) {
        if ( employeeRequest == null ) {
            return null;
        }

        employee.setName( employeeRequest.getName() );
        employee.setSurname( employeeRequest.getSurname() );
        employee.setEmail( employeeRequest.getEmail() );
        employee.setSalary( employeeRequest.getSalary() );
        employee.setRole( employeeRequest.getRole() );
        employee.setDepartment( employeeRequest.getDepartment() );
        employee.setDateOfStart( employeeRequest.getDateOfStart() );
        employee.setBirthDate( employeeRequest.getBirthDate() );
        if ( employeeRequest.getAddress() != null ) {
            if ( employee.getAddress() == null ) {
                employee.setAddress( new Address() );
            }
            this.addressMapper.updateAddress(employee.getAddress(), employeeRequest.getAddress());
        }
        else {
            employee.setAddress( null );
        }

        return employee;
    }
}