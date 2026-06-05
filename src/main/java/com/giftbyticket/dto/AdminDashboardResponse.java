package com.giftbyticket.dto;


import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AdminDashboardResponse {

    private Long totalUsers;
    private Long totalCampaigns;
    private Long totalCoupons;
    private Long totalEntries;
    private Long totalWinners;
}