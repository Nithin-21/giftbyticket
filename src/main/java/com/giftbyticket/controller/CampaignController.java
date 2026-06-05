package com.giftbyticket.controller;

import com.giftbyticket.dto.CampaignRequest;
import com.giftbyticket.dto.CampaignResponse;
import com.giftbyticket.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/campaigns")
@RequiredArgsConstructor
public class CampaignController {

    private final CampaignService campaignService;

    // when we donot write any end point here it with take from requestmapping
    @PostMapping
    public CampaignResponse createCampaign(
            @RequestBody CampaignRequest request) {

        return campaignService.createCampaign(request);
    }
    @GetMapping
    public List<CampaignResponse> getAllCampaigns() {
        return campaignService.getAllCampaigns();
    }

    @GetMapping("/{id}")
    public CampaignResponse getCampaignById(
            @PathVariable Long id) {

        return campaignService.getCampaignById(id);
    }

    @PutMapping("/{id}")
    public CampaignResponse updateCampaign(
            @PathVariable Long id,
            @RequestBody CampaignRequest request) {

        return campaignService.updateCampaign(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteCampaign(
            @PathVariable Long id) {

        campaignService.deleteCampaign(id);
        return "Campaign deleted successfully";
    }

}