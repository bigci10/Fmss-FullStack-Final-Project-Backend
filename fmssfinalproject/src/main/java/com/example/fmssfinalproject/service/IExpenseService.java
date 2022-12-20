package com.example.fmssfinalproject.service;

import com.example.fmssfinalproject.dto.request.CreateUpdateExpenseRequest;
import com.example.fmssfinalproject.dto.response.ExpenseDto;

import java.util.List;

public interface IExpenseService {
    ExpenseDto saveExpense(CreateUpdateExpenseRequest createExpenseRequest);

    void deleteExpenseById(Long id);

    ExpenseDto getExpenseById(Long id);

    List<ExpenseDto> getAllExpenses();

    ExpenseDto updateExpense(CreateUpdateExpenseRequest updateExpenseRequest, Long expenseId);
}
