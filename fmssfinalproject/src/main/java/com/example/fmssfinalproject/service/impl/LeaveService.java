package com.example.fmssfinalproject.service.impl;


import com.example.fmssfinalproject.dto.request.CreateUpdateLeaveRequest;
import com.example.fmssfinalproject.dto.response.LeaveDto;
import com.example.fmssfinalproject.exception.IncorrectDateSelection;
import com.example.fmssfinalproject.exception.ResourceNotFoundException;

import com.example.fmssfinalproject.mapper.ILeaveMapper;
import com.example.fmssfinalproject.model.Leave;
import com.example.fmssfinalproject.repository.LeaveRepository;
import com.example.fmssfinalproject.service.ILeaveService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.List;


@RequiredArgsConstructor
@Service
public class LeaveService implements ILeaveService {
    private final LeaveRepository leaveRepository;
    private final ILeaveMapper leaveMapper;


    @Override
    public LeaveDto saveLeave(CreateUpdateLeaveRequest createLeaveRequest) {

        validLeaveDays(createLeaveRequest);

        Leave leave = this.leaveRepository.save(
                this.leaveMapper.createLeaveFromCreateLeaveRequest((createLeaveRequest)));

        return this.leaveMapper.leaveToDto(leave);
    }

    @Override
    public void deleteLeaveById(Long id) {

        this.leaveRepository.deleteById(id);
    }

    @Override
    public LeaveDto getLeaveById(Long id) {
        Leave getLeaveById = this.leaveRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Leave Not Found"));

        return this.leaveMapper.leaveToDto(getLeaveById);
    }

    @Override
    public List<LeaveDto> getAllLeaves() {
        List<Leave> leaveList = this.leaveRepository.findAll();

        return leaveList.stream()
                .map(this.leaveMapper::leaveToDto)
                .toList();
    }

    @Override
    public LeaveDto updateLeave(CreateUpdateLeaveRequest updateLeaveRequest, Long leaveId) {

        validLeaveDays(updateLeaveRequest);
        Leave leave = this.leaveRepository.findById(leaveId).orElseThrow(() -> new ResourceNotFoundException("Leave Not Found"));

        this.leaveMapper.updateLeave(leave, updateLeaveRequest);
        Leave updatedLeave = this.leaveRepository.save(leave);

        return this.leaveMapper.leaveToDto(updatedLeave);

    }

    private void validLeaveDays(CreateUpdateLeaveRequest request) {
        LocalDate fromDate = request.getFromDate();
        LocalDate toDate = request.getToDate();

        boolean isEqual = fromDate.isEqual(toDate);
        boolean isWrongDays = fromDate.isAfter(toDate);
        if (isEqual || isWrongDays)
            throw new IncorrectDateSelection("Incorrect Date Selection");
    }
}
