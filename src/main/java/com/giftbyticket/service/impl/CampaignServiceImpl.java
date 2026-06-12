package com.giftbyticket.service.impl;

import com.giftbyticket.dto.CampaignRequest;
import com.giftbyticket.dto.CampaignResponse;
import com.giftbyticket.entity.Campaign;
import com.giftbyticket.repository.CampaignRepository;
import com.giftbyticket.service.CampaignService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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

        campaign = campaignRepository.save(campaign);

        return mapToResponse(campaign);
    }

    @Override
    public List<CampaignResponse> getAllCampaigns() {

        return campaignRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CampaignResponse getCampaignById(Long id) {

        Campaign campaign = campaignRepository.findById(id)
                .orElseThrow();

        return mapToResponse(campaign);
    }

    @Override
    public CampaignResponse updateCampaign(Long id, CampaignRequest request) {

        Campaign campaign = campaignRepository.findById(id)
                .orElseThrow();

        campaign.setCampaignName(request.getCampaignName());
        campaign.setDescription(request.getDescription());
        campaign.setEntryFee(request.getEntryFee());
        campaign.setStatus(request.getStatus());

        campaign = campaignRepository.save(campaign);

        return mapToResponse(campaign);
    }

    @Override
    public void deleteCampaign(Long id) {
        campaignRepository.deleteById(id);
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