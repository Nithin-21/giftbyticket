package com.giftbyticket.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CouponRequest {

    private String couponCode;
    private String couponTitle;
    private Double discountAmount;
    private String expiryDate;
}
