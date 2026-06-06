package com.giftbyticket.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponResponse {

    private Long id;
    private String couponCode;
    private String couponTitle;
    private Double discountAmount;
    private String expiryDate;
}