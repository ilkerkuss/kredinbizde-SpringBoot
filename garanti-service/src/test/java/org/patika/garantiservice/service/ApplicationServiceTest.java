package org.patika.garantiservice.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.patika.garantiservice.converter.ApplicationConverter;
import org.patika.garantiservice.dto.request.ApplicationRequest;
import org.patika.garantiservice.dto.response.ApplicationResponse;
import org.patika.garantiservice.entity.Application;
import org.patika.garantiservice.repository.ApplicationRepository;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ApplicationServiceTest {

    @Mock
    private ApplicationRepository applicationRepository;

    @Mock
    private ApplicationConverter applicationConverter;

    @InjectMocks
    private ApplicationService applicationService;


    @Test
    public void should_create_application_successfully() {
        ApplicationRequest request = new ApplicationRequest();
        Application application = new Application();
        ApplicationResponse response = new ApplicationResponse();

        when(applicationConverter.toApplication(request)).thenReturn(application);
        when(applicationRepository.save(application)).thenReturn(application);
        when(applicationConverter.toResponse(application)).thenReturn(response);

        ApplicationResponse createdResponse = applicationService.createApplication(request);

        assertNotNull(createdResponse);
        assertEquals(response, createdResponse);

        verify(applicationConverter, times(1)).toApplication(request);
        verify(applicationRepository, times(1)).save(application);
        verify(applicationConverter, times(1)).toResponse(application);
    }

    @Test
    public void should_get_all_applications_successfully() {
        List<Application> applicationList = new ArrayList<>();
        List<ApplicationResponse> responseList = new ArrayList<>();

        when(applicationRepository.findAll()).thenReturn(applicationList);
        when(applicationConverter.toResponseList(applicationList)).thenReturn(responseList);

        List<ApplicationResponse> allResponses = applicationService.getAll();

        assertNotNull(allResponses);
        assertEquals(responseList.size(), allResponses.size());

        verify(applicationRepository, times(1)).findAll();
        verify(applicationConverter, times(1)).toResponseList(applicationList);
    }

}
