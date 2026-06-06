package com.giftbyticket.dto;

import lombok.Data;

@Data
public class AssignCouponRequest {

    private Long userId;
    private Long couponId;
    private Long campaignId;
}