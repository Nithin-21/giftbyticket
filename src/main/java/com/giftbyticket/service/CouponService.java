package com.giftbyticket.service;

import com.giftbyticket.dto.CouponRequest;
import com.giftbyticket.dto.CouponResponse;

import java.util.List;

public interface CouponService {

    CouponResponse createCoupon(CouponRequest request);

    List<CouponResponse> getAllCoupons();

    CouponResponse getCouponById(Long id);

    CouponResponse updateCoupon(Long id, CouponRequest request);

    void deleteCoupon(Long id);
}