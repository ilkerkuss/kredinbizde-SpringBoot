package com.patika.kredinbizdeservice.dto.request;

import com.patika.kredinbizdeservice.model.Loan;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ApplicationRequest {

    private Loan loan;

    private String email;

    private  String bankName;
}
