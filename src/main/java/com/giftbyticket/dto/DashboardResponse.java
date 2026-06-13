package com.giftbyticket.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DashboardResponse {

    // Admin dashboard
    private Long totalUsers;
    private Long totalCampaigns;
    private Long totalCoupons;
    private Long totalEntries;
    private Long totalWinners;

    // User dashboard
    private Long participationCount;
    private Long couponCount;
    private Long winnerCount;
}