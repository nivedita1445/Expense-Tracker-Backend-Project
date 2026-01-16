package com.nivedita.expense_tracker_backend.controller;

import com.nivedita.expense_tracker_backend.dto.ExpenseRequestDTO;
import com.nivedita.expense_tracker_backend.dto.ExpenseResponseDTO;
import com.nivedita.expense_tracker_backend.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private final ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @PostMapping
    public ExpenseResponseDTO createExpense(
            @Valid @RequestBody ExpenseRequestDTO request
    ) {
        return service.createExpense(request);
    }

    @GetMapping
    public Page<ExpenseResponseDTO> getExpenses(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) Double minAmount,
            @RequestParam(required = false) Double maxAmount,

            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime startDate,

            @RequestParam(required = false)
            @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
            LocalDateTime endDate,

            Pageable pageable
    ) {
        return service.getExpenses(
                category,
                minAmount,
                maxAmount,
                startDate,
                endDate,
                pageable
        );
    }
}
