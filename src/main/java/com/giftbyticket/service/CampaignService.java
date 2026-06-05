package com.giftbyticket.service;

import com.giftbyticket.dto.CampaignRequest;
import com.giftbyticket.dto.CampaignResponse;

import java.util.*;

public interface CampaignService {

    CampaignResponse createCampaign(CampaignRequest request);

    List<CampaignResponse> getAllCampaigns();

    CampaignResponse getCampaignById(Long id);

    void deleteCampaign(Long id);
}