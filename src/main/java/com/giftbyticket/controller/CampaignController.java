package com.giftbyticket.controller;

import com.giftbyticket.dto.CampaignRequest;
import com.giftbyticket.dto.CampaignResponse;
import com.giftbyticket.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/campaigns")
@RequiredArgsConstructor
public class CampaignController {

    private final CampaignService campaignService;

    @PostMapping
    public CampaignResponse createCampaign(
            @RequestBody CampaignRequest request) {

        return campaignService.createCampaign(request);
    }


}