package com.giftbyticket.controller;

import com.giftbyticket.dto.AssignCouponRequest;
import com.giftbyticket.dto.UserCouponResponse;
import com.giftbyticket.service.UserCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-coupons")
@RequiredArgsConstructor
public class UserCouponController {

    private final UserCouponService userCouponService;

    @PostMapping
    public UserCouponResponse assignCoupon(
            @RequestBody AssignCouponRequest request) {

        return userCouponService.assignCoupon(request);
    }

    @GetMapping("/user/{userId}")
    public List<UserCouponResponse> getCouponsByUser(
            @PathVariable Long userId) {

        return userCouponService.getCouponsByUser(userId);
    }

    @PutMapping("/use/{id}")
    public UserCouponResponse markCouponUsed(
            @PathVariable Long id) {

        return userCouponService.markCouponUsed(id);
    }
}