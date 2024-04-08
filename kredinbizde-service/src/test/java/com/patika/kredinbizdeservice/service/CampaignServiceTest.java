package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.repository.CampaignRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CampaignServiceTest {

    @Mock
    private CampaignRepository campaignRepository;

    @InjectMocks
    private CampaignService campaignService;

    @Test
    public void testGetAllCampaigns() {
        List<Campaign> campaignList = new ArrayList<>();

        when(campaignRepository.findAll()).thenReturn(campaignList);

        List<Campaign> allCampaigns = campaignService.getAll();

        assertNotNull(allCampaigns);
        assertEquals(campaignList.size(), allCampaigns.size());

        verify(campaignRepository, times(1)).findAll();
    }
}
