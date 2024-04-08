package com.patika.kredinbizdeservice.model;

import com.patika.kredinbizdeservice.enums.LoanType;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@ToString
@Entity
@Table(name = "vehicle_loan")
@PrimaryKeyJoinColumn(name = "vechile_loan_id")
public class VechileLoan extends Loan {

    private final LoanType loanType = LoanType.ARAC_KREDISI;


    @Override
    void calculate(BigDecimal amount, int installment) {
    }
}
