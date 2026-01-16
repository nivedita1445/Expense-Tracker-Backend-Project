package com.nivedita.expense_tracker_backend.repository;

import com.nivedita.expense_tracker_backend.model.Expense;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    Page<Expense> findByCategory(String category, Pageable pageable);

    Page<Expense> findByAmountBetween(
            Double minAmount,
            Double maxAmount,
            Pageable pageable
    );

    Page<Expense> findByCreatedAtBetween(
            LocalDateTime start,
            LocalDateTime end,
            Pageable pageable
    );
}
