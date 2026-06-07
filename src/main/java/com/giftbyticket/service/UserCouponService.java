package com.giftbyticket.service;

import com.giftbyticket.dto.AssignCouponRequest;
import com.giftbyticket.dto.UserCouponResponse;

import java.util.List;

public interface UserCouponService {



    UserCouponResponse autoAssignCoupon( Long userId,   Long campaignId);


    UserCouponResponse assignCoupon(AssignCouponRequest request);

    List<UserCouponResponse> getCouponsByUser(Long userId);

    UserCouponResponse markCouponUsed(Long id);
}