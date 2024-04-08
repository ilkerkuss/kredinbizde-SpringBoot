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
@NoArgsConstructor
@ToString
@Entity
@Table(name = "consumer_loan")
@PrimaryKeyJoinColumn(name = "consumer_loan_id")
public class ConsumerLoan extends Loan {

    private LoanType loanType = LoanType.IHTIYAC_KREDISI;


    @Override
    void calculate(BigDecimal amount, int installment) {
    }


}
