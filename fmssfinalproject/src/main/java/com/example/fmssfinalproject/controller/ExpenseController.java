package com.example.fmssfinalproject.controller;

import com.example.fmssfinalproject.dto.request.CreateUpdateExpenseRequest;
import com.example.fmssfinalproject.dto.response.ExpenseDto;
import com.example.fmssfinalproject.service.IExpenseService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/expenses")
@CrossOrigin
public class ExpenseController {
    private final IExpenseService expenseService;

    @PostMapping
    ResponseEntity<ExpenseDto> saveExpense(@Valid @RequestBody CreateUpdateExpenseRequest expenseRequest) {
        ExpenseDto expenseDto = this.expenseService.saveExpense(expenseRequest);

        return ResponseEntity.ok(expenseDto);
    }

    @GetMapping
    ResponseEntity<List<ExpenseDto>> getAllExpenses() {
        if (CollectionUtils.isEmpty(this.expenseService.getAllExpenses()))
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(this.expenseService.getAllExpenses());
    }

    @GetMapping("/{id}")
    ResponseEntity<ExpenseDto> getExpenseById(@PathVariable Long id) {
        ExpenseDto expenseDto = this.expenseService.getExpenseById(id);


        return ResponseEntity.ok(expenseDto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteExpenseById(@PathVariable Long id) {
        this.expenseService.deleteExpenseById(id);
    }

    @PutMapping("/{id}")
    ResponseEntity<ExpenseDto> updateExpense(@PathVariable Long id, @Valid @RequestBody CreateUpdateExpenseRequest updateExpenseRequest) {
        ExpenseDto updatedExpense = this.expenseService.updateExpense(updateExpenseRequest, id);


        return ResponseEntity.ok(updatedExpense);

    }
}
