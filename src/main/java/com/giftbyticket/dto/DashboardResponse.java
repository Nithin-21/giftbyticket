package com.giftbyticket.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashboardResponse {

    private Long totalUsers;
    private Long totalCampaigns;
    private Long totalCoupons;
    private Long totalEntries;
    private Long totalWinners;
}