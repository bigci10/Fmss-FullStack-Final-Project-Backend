package com.example.fmssfinalproject.mapper.impl;

import com.example.fmssfinalproject.dto.request.CreateUpdateExpenseRequest;
import com.example.fmssfinalproject.dto.response.ExpenseDto;
import com.example.fmssfinalproject.exception.ResourceNotFoundException;
import com.example.fmssfinalproject.mapper.IExpenseMapper;
import com.example.fmssfinalproject.model.Employee;
import com.example.fmssfinalproject.model.Expense;
import com.example.fmssfinalproject.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;



@RequiredArgsConstructor
@Component
public class ExpenseMapperImpl implements IExpenseMapper
{
    private final EmployeeRepository employeeRepository;


    @Override
    public ExpenseDto expenseToDto(Expense expense) {
        if ( expense == null ) {
            return null;
        }

        ExpenseDto.ExpenseDtoBuilder<?, ?> expenseDto = ExpenseDto.builder();

        expenseDto.id( expense.getId() );
        expenseDto.employeeId(expense.getEmployee().getId());
        expenseDto.expenseType( expense.getExpenseType() );
        expenseDto.expenseDate( expense.getExpenseDate() );
        expenseDto.expenseDescription( expense.getExpenseDescription() );
        expenseDto.expenseAmount( expense.getExpenseAmount() );


        return expenseDto.build();
    }
    @Override
    public Expense createExpenseFromCreateExpenseRequest(CreateUpdateExpenseRequest createExpenseRequest) {
        if ( createExpenseRequest == null ) {
            return null;
        }

        Expense.ExpenseBuilder expense = Expense.builder();

        expense.employee(getEmployee((createExpenseRequest)));
        expense.expenseType( createExpenseRequest.getExpenseType() );
        expense.expenseDate( createExpenseRequest.getExpenseDate() );
        expense.expenseDescription( createExpenseRequest.getExpenseDescription() );
        expense.expenseAmount( createExpenseRequest.getExpenseAmount() );


        return expense.build();
    }

    @Override
    public Expense updateExpense(Expense expense, CreateUpdateExpenseRequest expenseRequest) {
        if ( expenseRequest == null ) {
            return null;
        }

        expense.setEmployee(getEmployee(expenseRequest));
        expense.setExpenseType( expenseRequest.getExpenseType() );
        expense.setExpenseDate( expenseRequest.getExpenseDate() );
        expense.setExpenseDescription( expenseRequest.getExpenseDescription() );
        expense.setExpenseAmount( expenseRequest.getExpenseAmount() );

        return expense;
    }

    private Employee getEmployee(CreateUpdateExpenseRequest request)
    {
        return  employeeRepository.findById(request.getEmployeeId())
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found"));
    }

}
