package com.giftbyticket.dto;

import lombok.*;

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