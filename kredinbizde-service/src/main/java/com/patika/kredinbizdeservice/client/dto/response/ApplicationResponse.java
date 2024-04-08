package com.patika.kredinbizdeservice.client.dto.response;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class ApplicationResponse {

    private Long userId;
    private LocalDate createDate;
    private ApplicationStatus applicationStatus;
}
