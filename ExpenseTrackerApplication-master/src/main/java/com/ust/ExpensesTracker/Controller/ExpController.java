package com.ust.ExpensesTracker.Controller;

import com.ust.ExpensesTracker.Model.Expenses;
import com.ust.ExpensesTracker.Service.ExpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequestMapping("/expenses")
public class ExpController {

    @Autowired
    private ExpService expenseService;

    @PostMapping("/addExpense")
    public ResponseEntity<Expenses> addExpense(@RequestBody Expenses expense) {
        return ResponseEntity.ok(expenseService.addExpense(expense));
    }

    @GetMapping
    public ResponseEntity<List<Expenses>> getExpenses(@RequestParam String start, @RequestParam String end) {
        LocalDateTime startDate = LocalDateTime.parse(start);
        LocalDateTime endDate = LocalDateTime.parse(end);
        return ResponseEntity.ok(expenseService.getExpenses(startDate, endDate));
    }

    @GetMapping("/totalExpenses")
    public ResponseEntity<Double> getTotalExpenses(@RequestParam String start, @RequestParam String end) {
        LocalDateTime startDate = LocalDateTime.parse(start);
        LocalDateTime endDate = LocalDateTime.parse(end);
        return ResponseEntity.ok(expenseService.getTotalExpenses(startDate, endDate));
    }
    @GetMapping("/balance")
    public ResponseEntity<Double> getBalance() {
        return ResponseEntity.ok(expenseService.getBalance());
    }
}
