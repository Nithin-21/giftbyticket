package com.giftbyticket.dto;

import lombok.*;


@Getter
@Setter
public class CampaignRequest {

    private String campaignName;
    private String description;
    private Double entryFee;
    private String status;
}