package com.patika.kredinbizdeservice.converter;


import com.patika.kredinbizdeservice.client.dto.response.ApplicationResponse;
import com.patika.kredinbizdeservice.client.dto.response.ApplicationStatus;
import com.patika.kredinbizdeservice.dto.request.ApplicationRequest;
import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.User;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationConverter {

    public Application toApplication(ApplicationRequest request, User user) {
        Application application = new Application();
        application.setUser(user);
        application.setLoan(request.getLoan());


        application.setCreatedDate(LocalDate.now());
        application.setUpdatedDate(LocalDate.now());


        application.setApplicationStatus(com.patika.kredinbizdeservice.enums.ApplicationStatus.INITIAL);

        return application;
    }

    public ApplicationResponse toResponse(Application application) {
        return ApplicationResponse.builder()
                .userId(application.getUser().getUserId())
                .createDate(application.getCreatedDate())
                .applicationStatus(ApplicationStatus.INITIAL)
                .build();
    }

    public List<ApplicationResponse> toResponseList(List<Application> applications) {
        List<ApplicationResponse> applicationResponses = new ArrayList<>();

        applications.forEach(application -> {
            applicationResponses.add(toResponse(application));
        });

        return applicationResponses;
    }


}
