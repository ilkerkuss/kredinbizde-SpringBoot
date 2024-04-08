package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.client.AkbankServiceClient;
import com.patika.kredinbizdeservice.client.GarantiServiceClient;
import com.patika.kredinbizdeservice.client.dto.request.AkbankApplicationRequest;
import com.patika.kredinbizdeservice.client.dto.request.GarantiApplicationRequest;
import com.patika.kredinbizdeservice.client.dto.response.ApplicationResponse;
import com.patika.kredinbizdeservice.converter.ApplicationConverter;
import com.patika.kredinbizdeservice.dto.request.ApplicationRequest;
import com.patika.kredinbizdeservice.model.Application;
import com.patika.kredinbizdeservice.model.User;
import com.patika.kredinbizdeservice.producer.LogProducer;
import com.patika.kredinbizdeservice.repository.ApplicationRepository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ApplicationServiceTest {

    @Mock
    private ApplicationRepository applicationRepository;

    @Mock
    private ApplicationConverter applicationConverter;

    @Mock
    private UserService userService;

    @Mock
    private AkbankServiceClient akbankServiceClient;

    @Mock
    private GarantiServiceClient garantiServiceClient;

    @Mock
    private LogProducer logProducer;

    @InjectMocks
    private ApplicationService applicationService;



    @Test
    public void testCreateApplicationForAkbank() {
        ApplicationRequest request = new ApplicationRequest();
        request.setEmail("test@gmail.com");
        request.setBankName("Akbank");

        User user = prepareUser();
        Application application = prepareApplication();

        when(userService.getByEmail(request.getEmail())).thenReturn(user);
        when(applicationConverter.toApplication(request, user)).thenReturn(application);
        when(applicationRepository.save(application)).thenReturn(application);
        when(akbankServiceClient.createApplication(any(AkbankApplicationRequest.class))).thenReturn(new ApplicationResponse());

        Application createdApplication = applicationService.createApplication(request);

        assertNotNull(createdApplication);
        assertEquals(application, createdApplication);

        verify(userService, times(1)).getByEmail(request.getEmail());
        verify(applicationConverter, times(1)).toApplication(request, user);
        verify(applicationRepository, times(1)).save(application);
        verify(akbankServiceClient, times(1)).createApplication(any(AkbankApplicationRequest.class));
    }

    @Test
    public void testCreateApplicationForGaranti() {
        ApplicationRequest request = new ApplicationRequest();
        request.setEmail("test@gmail.com");
        request.setBankName("Garanti");

        User user = prepareUser();
        Application application = prepareApplication();

        when(userService.getByEmail(request.getEmail())).thenReturn(user);
        when(applicationConverter.toApplication(request, user)).thenReturn(application);
        when(applicationRepository.save(application)).thenReturn(application);
        when(garantiServiceClient.createApplication(any(GarantiApplicationRequest.class))).thenReturn(new ApplicationResponse());

        Application createdApplication = applicationService.createApplication(request);

        assertNotNull(createdApplication);
        assertEquals(application, createdApplication);

        verify(userService, times(1)).getByEmail(request.getEmail());
        verify(applicationConverter, times(1)).toApplication(request, user);
        verify(applicationRepository, times(1)).save(application);
        verify(garantiServiceClient, times(1)).createApplication(any(GarantiApplicationRequest.class));
    }

    @Test
    public void testCreateApplicationForUnknownBank() {
        ApplicationRequest request = new ApplicationRequest();
        request.setEmail("test@gmail.com");
        request.setBankName("ABCBank");

        User user = prepareUser();
        Application application = prepareApplication();

        when(userService.getByEmail(request.getEmail())).thenReturn(user);
        when(applicationConverter.toApplication(request, user)).thenReturn(application);
        when(applicationRepository.save(application)).thenReturn(application);

        Application createdApplication = applicationService.createApplication(request);

        assertNotNull(createdApplication);
        assertEquals(application, createdApplication);

        verify(userService, times(1)).getByEmail(request.getEmail());
        verify(applicationConverter, times(1)).toApplication(request, user);
        verify(applicationRepository, times(1)).save(application);

    }

    @Test
    public void testGetAllApplications() {
        List<Application> applicationList = new ArrayList<>();

        when(applicationRepository.findAll()).thenReturn(applicationList);

        List<ApplicationResponse> allApplications = applicationService.getAll();

        assertNotNull(allApplications);
        assertEquals(applicationList.size(), allApplications.size());

        verify(applicationRepository, times(1)).findAll();
    }

    @Test
    public void testGetAllApplicationsByUserId() {
        Long userId = 1L;
        List<Application> applicationList = new ArrayList<>();

        when(applicationRepository.findApplicationByUserUserId(userId)).thenReturn(applicationList);

        List<ApplicationResponse> applicationsByUserId = applicationService.getAllByUserId(userId);

        assertNotNull(applicationsByUserId);

        verify(applicationRepository, times(1)).findApplicationByUserUserId(userId);
    }


    private Application prepareApplication(){
        Application application= new Application();
        application.setId(1L);
        application.setUser(prepareUser());

        return application;
    }

    private User prepareUser() {

        User user = new User();

        user.setName("test name");
        user.setSurname("test surname");
        user.setEmail("test@mail.com");
        user.setPassword("testpassword");

        return user;
    }
}
