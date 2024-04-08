package com.patika.kredinbizdeservice.controller;

import com.patika.kredinbizdeservice.model.Campaign;
import com.patika.kredinbizdeservice.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/campaigns")
@RequiredArgsConstructor
public class CampaignController {


    private final CampaignService campaignService;


    @GetMapping
    public List<Campaign> getAll() {
        System.out.println("campaignService: " + campaignService.hashCode());
        return campaignService.getAll();
    }

}
