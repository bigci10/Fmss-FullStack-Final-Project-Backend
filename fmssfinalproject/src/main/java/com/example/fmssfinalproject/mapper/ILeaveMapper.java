package com.example.fmssfinalproject.mapper;


import com.example.fmssfinalproject.dto.request.CreateUpdateLeaveRequest;
import com.example.fmssfinalproject.dto.response.LeaveDto;
import com.example.fmssfinalproject.model.Leave;


public interface ILeaveMapper {
    LeaveDto leaveToDto(Leave leave);

    Leave createLeaveFromCreateLeaveRequest(CreateUpdateLeaveRequest createLeaveRequest);

    Leave updateLeave(Leave leave, CreateUpdateLeaveRequest leaveRequest);
}
