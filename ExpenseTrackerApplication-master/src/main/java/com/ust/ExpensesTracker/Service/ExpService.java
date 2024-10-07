package com.ust.ExpensesTracker.Service;

import com.ust.ExpensesTracker.Model.Expenses;
import com.ust.ExpensesTracker.Repository.ExpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExpService {
    @Autowired
    private ExpRepository expenseRepository;

    public Expenses addExpense(Expenses expense) {
        expense.setTimestamp(LocalDateTime.now());
        return expenseRepository.save(expense);
    }

    public List<Expenses> getExpenses(LocalDateTime start, LocalDateTime end) {
        return expenseRepository.findByTimestampBetween(start, end);
    }

    public double getTotalExpenses(LocalDateTime start, LocalDateTime end) {
        return getExpenses(start, end).stream().mapToDouble(Expenses::getAmount).sum();
    }

    public double getBalance() {
        return expenseRepository.findAll().stream()
                .mapToDouble(Expenses::getAmount)
                .sum();
    }
}



