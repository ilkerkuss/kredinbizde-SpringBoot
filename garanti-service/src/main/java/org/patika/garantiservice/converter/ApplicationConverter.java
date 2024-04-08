package org.patika.garantiservice.converter;


import org.patika.garantiservice.dto.request.ApplicationRequest;
import org.patika.garantiservice.dto.response.ApplicationResponse;
import org.patika.garantiservice.entity.Application;
import org.patika.garantiservice.enums.ApplicationStatus;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationConverter {

    public Application toApplication(ApplicationRequest request) {
        // @formatter:off
        return Application.builder()
                .userId(request.getUserId())
                .createDate(LocalDateTime.now())
                .applicationStatus(ApplicationStatus.INITIAL)
                .build();
        // @formatter:on
    }

    public ApplicationResponse toResponse(Application application) {
        // @formatter:off
        return ApplicationResponse.builder()
                .userId(application.getUserId())
                .createDate(application.getCreateDate())
                .applicationStatus(application.getApplicationStatus())
                .build();
        // @formatter:on
    }

    public List<ApplicationResponse> toResponseList(List<Application> applications) {
        List<ApplicationResponse> applicationResponses = new ArrayList<>();

        applications.forEach(application -> {
            applicationResponses.add(toResponse(application));
        });

        return applicationResponses;
    }
}
