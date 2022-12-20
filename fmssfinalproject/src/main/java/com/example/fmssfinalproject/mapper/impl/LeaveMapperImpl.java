package com.example.fmssfinalproject.mapper.impl;


import com.example.fmssfinalproject.dto.request.CreateUpdateLeaveRequest;
import com.example.fmssfinalproject.dto.response.LeaveDto;
import com.example.fmssfinalproject.exception.ResourceNotFoundException;
import com.example.fmssfinalproject.mapper.ILeaveMapper;
import com.example.fmssfinalproject.model.Employee;
import com.example.fmssfinalproject.model.Leave;
import com.example.fmssfinalproject.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class LeaveMapperImpl implements ILeaveMapper
{

    private final EmployeeRepository employeeRepository;

    @Override
    public LeaveDto leaveToDto(Leave leave) {
        if ( leave == null ) {
            return null;
        }

        LeaveDto.LeaveDtoBuilder<?, ?> leaveDto = LeaveDto.builder();


        leaveDto.id(leave.getId());
        leaveDto.employeeId(leave.getEmployee().getId());
        leaveDto.fromDate( leave.getFromDate() );
        leaveDto.toDate( leave.getToDate() );
        leaveDto.description( leave.getDescription() );

        return leaveDto.build();
    }

    @Override
    public Leave createLeaveFromCreateLeaveRequest(CreateUpdateLeaveRequest createLeaveRequest) {
        if ( createLeaveRequest == null ) {
            return null;
        }

        Leave.LeaveBuilder leave = Leave.builder();

        leave.employee(getEmployee(createLeaveRequest));
        leave.fromDate( createLeaveRequest.getFromDate() );
        leave.toDate( createLeaveRequest.getToDate() );
        leave.description( createLeaveRequest.getDescription() );


        return leave.build();
    }

    @Override
    public Leave updateLeave(Leave leave, CreateUpdateLeaveRequest leaveRequest) {
        if ( leaveRequest == null ) {
            return null;
        }

        leave.setEmployee(getEmployee(leaveRequest));
        leave.setFromDate( leaveRequest.getFromDate() );
        leave.setToDate( leaveRequest.getToDate() );
        leave.setDescription( leaveRequest.getDescription() );


        return leave;
    }

    private Employee getEmployee(CreateUpdateLeaveRequest request)
    {
        return  employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }

}
