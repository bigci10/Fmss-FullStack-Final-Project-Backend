package com.example.fmssfinalproject.controller;


import com.example.fmssfinalproject.dto.request.CreateUpdateLeaveRequest;
import com.example.fmssfinalproject.dto.response.LeaveDto;
import com.example.fmssfinalproject.service.ILeaveService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/leaves")
@CrossOrigin
public class LeaveController {
    private final ILeaveService leaveService;

    @PostMapping
    ResponseEntity<LeaveDto> saveLeave(@Valid @RequestBody CreateUpdateLeaveRequest leaveRequest) {
        LeaveDto leaveDto = this.leaveService.saveLeave(leaveRequest);
        return ResponseEntity.ok(leaveDto);
    }

    @GetMapping
    ResponseEntity<List<LeaveDto>> getAllLeaves() {
        if (CollectionUtils.isEmpty(this.leaveService.getAllLeaves()))
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(this.leaveService.getAllLeaves());
    }

    @GetMapping("/{id}")
    ResponseEntity<LeaveDto> getLeaveById(@PathVariable Long id) {
        LeaveDto leaveDto = this.leaveService.getLeaveById(id);


        return ResponseEntity.ok(leaveDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteLeaveById(@PathVariable Long id) {
        this.leaveService.deleteLeaveById(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<LeaveDto> updateLeave(@PathVariable Long id, @Valid @RequestBody CreateUpdateLeaveRequest updateLeaveRequest) {
        LeaveDto updatedLeave = this.leaveService.updateLeave(updateLeaveRequest, id);

        return ResponseEntity.ok(updatedLeave);

    }
}
