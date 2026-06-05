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
        return new ArrayList<>();
    }

    @Override
    public CampaignResponse getCampaignById(Long id) {
        return null;
    }

    @Override
    public void deleteCampaign(Long id) {
    }
}