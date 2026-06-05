package com.giftbyticket.service.impl;

import com.giftbyticket.dto.CampaignRequest;
import com.giftbyticket.dto.CampaignResponse;
import com.giftbyticket.entity.Campaign;
import com.giftbyticket.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.giftbyticket.repository.CampaignRepository;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CampaignServiceImpl implements CampaignService {

    private final CampaignRepository campaignRepository;


    @Override
    public CampaignResponse createCampaign(CampaignRequest request) {

        Campaign campaign = Campaign.builder()
                .campaignName(request.getCampaignName())
                .description(request.getDescription())
                .entryFee(request.getEntryFee())
                .status(request.getStatus())
                .build();

        Campaign savedCampaign = campaignRepository.save(campaign);

        return CampaignResponse.builder()
                .id(savedCampaign.getId())
                .campaignName(savedCampaign.getCampaignName())
                .description(savedCampaign.getDescription())
                .entryFee(savedCampaign.getEntryFee())
                .status(savedCampaign.getStatus())
                .build();
    }

    @Override
    public List<CampaignResponse> getAllCampaigns() {

        List<Campaign> campaigns = campaignRepository.findAll();

        return campaigns.stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public CampaignResponse getCampaignById(Long id) {

        Campaign campaign = campaignRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Campaign not found with id: " + id));

        return mapToResponse(campaign);
    }

    @Override
    public CampaignResponse updateCampaign(Long id, CampaignRequest request) {

        Campaign campaign = campaignRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Campaign not found with id: " + id));

        campaign.setCampaignName(request.getCampaignName());
        campaign.setDescription(request.getDescription());
        campaign.setEntryFee(request.getEntryFee());
        campaign.setStatus(request.getStatus());

        Campaign updatedCampaign = campaignRepository.save(campaign);

        return mapToResponse(updatedCampaign);
    }

    @Override
    public void deleteCampaign(Long id) {

        Campaign campaign = campaignRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Campaign not found with id: " + id));

        campaignRepository.delete(campaign);
    }

    private CampaignResponse mapToResponse(Campaign campaign) {

        return CampaignResponse.builder()
                .id(campaign.getId())
                .campaignName(campaign.getCampaignName())
                .description(campaign.getDescription())
                .entryFee(campaign.getEntryFee())
                .status(campaign.getStatus())
                .build();
    }
}