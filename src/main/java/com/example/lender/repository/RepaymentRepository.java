package com.example.lender.repository;

import com.example.lender.entity.Repayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RepaymentRepository extends JpaRepository<Repayment, Long> {

    List<Repayment> findByLoanId(Long loanId);

    @Query("SELECT COALESCE(SUM(r.amountPaid), 0) FROM Repayment r WHERE r.loan.id = :loanId")
    double findTotalPaid(@Param("loanId") Long loanId);
}
