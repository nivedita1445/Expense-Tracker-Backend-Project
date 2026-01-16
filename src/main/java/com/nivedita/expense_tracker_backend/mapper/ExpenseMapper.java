package com.nivedita.expense_tracker_backend.mapper;

import com.nivedita.expense_tracker_backend.dto.ExpenseRequestDTO;
import com.nivedita.expense_tracker_backend.dto.ExpenseResponseDTO;
import com.nivedita.expense_tracker_backend.model.Expense;

public class ExpenseMapper {

    private ExpenseMapper() {
        // prevent object creation
    }

    public static Expense toEntity(ExpenseRequestDTO request) {
        Expense expense = new Expense();
        expense.setTitle(request.getTitle());
        expense.setAmount(request.getAmount());
        expense.setCategory(request.getCategory());
        return expense;
    }

    public static ExpenseResponseDTO toResponseDTO(Expense expense) {
        ExpenseResponseDTO dto = new ExpenseResponseDTO();
        dto.setId(expense.getId());
        dto.setTitle(expense.getTitle());
        dto.setAmount(expense.getAmount());
        dto.setCategory(expense.getCategory());
        dto.setCreatedAt(expense.getCreatedAt());
        return dto;
    }
}
