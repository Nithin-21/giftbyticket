package com.giftbyticket.controller;

import com.giftbyticket.dto.CouponRequest;
import com.giftbyticket.dto.CouponResponse;
import com.giftbyticket.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coupons")
@RequiredArgsConstructor
public class CouponController {

    private final CouponService couponService;

    @PostMapping
    public CouponResponse createCoupon(
            @RequestBody CouponRequest request) {

        return couponService.createCoupon(request);
    }

    @GetMapping
    public List<CouponResponse> getAllCoupons() {

        return couponService.getAllCoupons();
    }

    @GetMapping("/{id}")
    public CouponResponse getCouponById(
            @PathVariable Long id) {

        return couponService.getCouponById(id);
    }

    @PutMapping("/{id}")
    public CouponResponse updateCoupon(
            @PathVariable Long id,
            @RequestBody CouponRequest request) {

        return couponService.updateCoupon(id, request);
    }

    @DeleteMapping("/{id}")
    public void deleteCoupon(
            @PathVariable Long id) {

        couponService.deleteCoupon(id);
    }
}
