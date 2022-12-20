package com.example.fmssfinalproject.mapper;

import com.example.fmssfinalproject.dto.request.CreateUpdateExpenseRequest;
import com.example.fmssfinalproject.dto.response.ExpenseDto;
import com.example.fmssfinalproject.model.Expense;


public interface IExpenseMapper {

    ExpenseDto expenseToDto(Expense expense);

    Expense createExpenseFromCreateExpenseRequest(CreateUpdateExpenseRequest createExpenseRequest);

    Expense updateExpense(Expense expense, CreateUpdateExpenseRequest expenseRequest);
}
