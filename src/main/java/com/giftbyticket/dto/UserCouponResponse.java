package com.giftbyticket.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class UserCouponResponse {

    private Long id;
    private String giveawayCode;
    private Long userId;
    private String userName;

    private Long couponId;
    private String couponTitle;

    private Long campaignId;
    private String campaignName;

    private LocalDateTime assignedDate;

    private Boolean used;

    private LocalDateTime usedDate;
}