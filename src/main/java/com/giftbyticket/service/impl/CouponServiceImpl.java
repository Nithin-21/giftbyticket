package com.giftbyticket.service.impl;

import com.giftbyticket.dto.CouponRequest;
import com.giftbyticket.dto.CouponResponse;
import com.giftbyticket.entity.Coupon;
import com.giftbyticket.repository.CouponRepository;
import com.giftbyticket.service.CouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {

    private final CouponRepository couponRepository;

    @Override
    public CouponResponse createCoupon(CouponRequest request) {

        Coupon coupon = Coupon.builder()
                .couponCode(request.getCouponCode())  //not rquired here
                .couponTitle(request.getCouponTitle())
                .discountAmount(request.getDiscountAmount())
                .expiryDate(request.getExpiryDate())
                .build();

        Coupon savedCoupon = couponRepository.save(coupon);

        return mapToResponse(savedCoupon);
    }

    @Override
    public List<CouponResponse> getAllCoupons() {

        return couponRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public CouponResponse getCouponById(Long id) {

        Coupon coupon = couponRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coupon not found"));

        return mapToResponse(coupon);
    }

    @Override
    public CouponResponse updateCoupon(Long id,
                                       CouponRequest request) {

        Coupon coupon = couponRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Coupon not found"));

        coupon.setCouponCode(request.getCouponCode());
        coupon.setCouponTitle(request.getCouponTitle());
        coupon.setDiscountAmount(request.getDiscountAmount());
        coupon.setExpiryDate(request.getExpiryDate());

        Coupon updatedCoupon = couponRepository.save(coupon);

        return mapToResponse(updatedCoupon);
    }

    @Override
    public void deleteCoupon(Long id) {

        couponRepository.deleteById(id);
    }

    private CouponResponse mapToResponse(Coupon coupon) {

        return CouponResponse.builder()
                .id(coupon.getId())
                .couponCode(coupon.getCouponCode())
                .couponTitle(coupon.getCouponTitle())
                .discountAmount(coupon.getDiscountAmount())
                .expiryDate(coupon.getExpiryDate())
                .build();
    }
}