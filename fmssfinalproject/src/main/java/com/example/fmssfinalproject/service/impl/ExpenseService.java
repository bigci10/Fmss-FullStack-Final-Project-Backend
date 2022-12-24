package com.example.fmssfinalproject.service.impl;

import com.example.fmssfinalproject.dto.request.CreateUpdateExpenseRequest;
import com.example.fmssfinalproject.dto.response.ExpenseDto;
import com.example.fmssfinalproject.exception.ResourceNotFoundException;


import com.example.fmssfinalproject.mapper.IExpenseMapper;
import com.example.fmssfinalproject.model.Expense;

import com.example.fmssfinalproject.repository.ExpenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.example.fmssfinalproject.service.IExpenseService;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ExpenseService implements IExpenseService {
    private final ExpenseRepository expenseRepository;
    private final IExpenseMapper expenseMapper;


    @Override
    public ExpenseDto saveExpense(CreateUpdateExpenseRequest createExpenseRequest) {

        Expense expense = this.expenseMapper.createExpenseFromCreateExpenseRequest((createExpenseRequest));
        expenseRepository.save(expense);

        return this.expenseMapper.expenseToDto(expense);
    }

    @Override
    public void deleteExpenseById(Long id) {
        this.expenseRepository.deleteById(id);
    }

    @Override
    public ExpenseDto getExpenseById(Long id) {

        Expense getExpenseById = this.expenseRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Expense Not Found"));

        return this.expenseMapper.expenseToDto(getExpenseById);
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {
        List<Expense> expenseList = this.expenseRepository.findAll();

        return expenseList.stream()
                .map(this.expenseMapper::expenseToDto)
                .toList();
    }

    @Override
    public ExpenseDto updateExpense(CreateUpdateExpenseRequest updateExpenseRequest, Long expenseId) {

        Expense expense = this.expenseRepository.findById(expenseId).orElseThrow(() -> new ResourceNotFoundException("Expense Not Found"));
        this.expenseMapper.updateExpense(expense, updateExpenseRequest);

        Expense updatedExpense = this.expenseRepository.save(expense);

        return this.expenseMapper.expenseToDto(updatedExpense);
    }

}
