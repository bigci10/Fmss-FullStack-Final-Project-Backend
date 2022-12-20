package com.example.fmssfinalproject.service;


import com.example.fmssfinalproject.dto.request.CreateUpdateLeaveRequest;
import com.example.fmssfinalproject.dto.response.LeaveDto;

import java.util.List;

public interface ILeaveService {
    LeaveDto saveLeave(CreateUpdateLeaveRequest createLeaveRequest);

    void deleteLeaveById(Long id);

    LeaveDto getLeaveById(Long id);

    List<LeaveDto> getAllLeaves();

    LeaveDto updateLeave(CreateUpdateLeaveRequest updateLeaveRequest, Long leaveId);
}
