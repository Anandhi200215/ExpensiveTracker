package com.ust.ExpensesTracker.Repository;

import com.ust.ExpensesTracker.Model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ExpRepository extends JpaRepository<Expenses,Long> {
    List<Expenses> findByTimestampBetween(LocalDateTime start, LocalDateTime end);
}

