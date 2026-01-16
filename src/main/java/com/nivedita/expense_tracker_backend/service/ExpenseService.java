package com.nivedita.expense_tracker_backend.service;

import com.nivedita.expense_tracker_backend.dto.ExpenseRequestDTO;
import com.nivedita.expense_tracker_backend.dto.ExpenseResponseDTO;
import com.nivedita.expense_tracker_backend.model.Expense;
import com.nivedita.expense_tracker_backend.repository.ExpenseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService(ExpenseRepository repository) {
        this.repository = repository;
    }

    public ExpenseResponseDTO createExpense(ExpenseRequestDTO request) {
        Expense e = new Expense();
        e.setTitle(request.getTitle());
        e.setAmount(request.getAmount());
        e.setCategory(request.getCategory());

        Expense saved = repository.save(e);
        return map(saved);
    }

    public Page<ExpenseResponseDTO> getExpenses(
            String category,
            Double minAmount,
            Double maxAmount,
            LocalDateTime startDate,
            LocalDateTime endDate,
            Pageable pageable
    ) {
        Page<Expense> page;

        if (startDate != null && endDate != null) {
            page = repository.findByCreatedAtBetween(startDate, endDate, pageable);
        } else if (category != null) {
            page = repository.findByCategory(category, pageable);
        } else if (minAmount != null && maxAmount != null) {
            page = repository.findByAmountBetween(minAmount, maxAmount, pageable);
        } else {
            page = repository.findAll(pageable);
        }

        return page.map(this::map);
    }

    private ExpenseResponseDTO map(Expense e) {
        ExpenseResponseDTO dto = new ExpenseResponseDTO();
        dto.setId(e.getId());
        dto.setTitle(e.getTitle());
        dto.setAmount(e.getAmount());
        dto.setCategory(e.getCategory());
        dto.setCreatedAt(e.getCreatedAt());
        return dto;
    }
}
