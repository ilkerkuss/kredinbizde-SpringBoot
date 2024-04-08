package org.patika.garantiservice.service;


import lombok.RequiredArgsConstructor;
import org.patika.garantiservice.converter.ApplicationConverter;
import org.patika.garantiservice.dto.request.ApplicationRequest;
import org.patika.garantiservice.dto.response.ApplicationResponse;
import org.patika.garantiservice.entity.Application;
import org.patika.garantiservice.repository.ApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final ApplicationRepository applicationRepository;

    private final ApplicationConverter applicationConverter;


    public ApplicationResponse createApplication(ApplicationRequest request) {

        Application application = applicationConverter.toApplication(request);

        return applicationConverter.toResponse(applicationRepository.save(application));
    }


    public List<ApplicationResponse> getAll() {

        List<Application> applications = applicationRepository.findAll();

        return applicationConverter.toResponseList(applications);
    }
}
