package com.giftbyticket.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CampaignResponse {

    private Long id;
    private String campaignName;
    private String description;
    private Double entryFee;
    private String status;
}