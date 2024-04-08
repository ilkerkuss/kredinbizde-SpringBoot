package com.patika.kredinbizdeservice.service;

import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.repository.CampaignRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CampaignService implements ICampaignService {

    private final CampaignRepository campaignRepository;

    @Override
    public List<Campaign> getAll() {
        System.out.println("campaignRepository: " + campaignRepository.hashCode());
        return campaignRepository.findAll();
    }
}
