package com.giftbyticket.service.impl;

import com.giftbyticket.dto.AssignCouponRequest;
import com.giftbyticket.dto.UserCouponResponse;
import com.giftbyticket.entity.*;
import com.giftbyticket.repository.*;
import com.giftbyticket.service.UserCouponService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserCouponServiceImpl implements UserCouponService {

    private final UserCouponRepository userCouponRepository;
    private final UserRepository userRepository;
    private final CouponRepository couponRepository;
    private final CampaignRepository campaignRepository;

    @Override
    public UserCouponResponse autoAssignCoupon(
            Long userId,
            Long campaignId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        Campaign campaign = campaignRepository.findById(campaignId)
                .orElseThrow(() ->
                        new RuntimeException("Campaign not found"));

        List<Coupon> coupons = couponRepository.findAll();

        if (coupons.isEmpty()) {
            throw new RuntimeException("No coupons available");
        }

        long totalAssignedCoupons =
                userCouponRepository.count();

        Coupon assignedCoupon =
                coupons.get(
                        (int) (totalAssignedCoupons % coupons.size())
                );

        UserCoupon userCoupon = UserCoupon.builder()
                .user(user)
                .campaign(campaign)
                .coupon(assignedCoupon)
                .giveawayCode(generateGiveawayCode())
                .assignedDate(LocalDateTime.now())
                .used(false)
                .build();

        UserCoupon savedUserCoupon =
                userCouponRepository.save(userCoupon);

        return mapToResponse(savedUserCoupon);
    }


    @Override
    public UserCouponResponse assignCoupon(AssignCouponRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Coupon coupon = couponRepository.findById(request.getCouponId())
                .orElseThrow(() -> new RuntimeException("Coupon not found"));

        Campaign campaign = campaignRepository.findById(request.getCampaignId())
                .orElseThrow(() -> new RuntimeException("Campaign not found"));

        UserCoupon userCoupon = UserCoupon.builder()
                .user(user)
                .coupon(coupon)
                .campaign(campaign)
                .assignedDate(LocalDateTime.now())
                .used(false)
                .build();

        UserCoupon saved = userCouponRepository.save(userCoupon);

        return mapToResponse(saved);
    }

    @Override
    public List<UserCouponResponse> getCouponsByUser(Long userId) {

        return userCouponRepository.findByUserId(userId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public UserCouponResponse markCouponUsed(Long userCouponId) {

        UserCoupon userCoupon = userCouponRepository.findById(userCouponId)
                .orElseThrow(() -> new RuntimeException("User Coupon not found"));

        userCoupon.setUsed(true);
        userCoupon.setUsedDate(LocalDateTime.now());

        UserCoupon updated = userCouponRepository.save(userCoupon);

        return mapToResponse(updated);
    }

    private UserCouponResponse mapToResponse(UserCoupon userCoupon) {

        return UserCouponResponse.builder()
                .id(userCoupon.getId())
                .giveawayCode(userCoupon.getGiveawayCode())

                .userId(userCoupon.getUser().getId())
                .userName(userCoupon.getUser().getName())

                .couponId(userCoupon.getCoupon().getId())
                .couponCode(userCoupon.getCoupon().getCouponCode())
                .couponTitle(userCoupon.getCoupon().getCouponTitle())
                .discountAmount(userCoupon.getCoupon().getDiscountAmount())
                .expiryDate(userCoupon.getCoupon().getExpiryDate())
                .campaignId(userCoupon.getCampaign().getId())
                .campaignName(userCoupon.getCampaign().getCampaignName())

                .assignedDate(userCoupon.getAssignedDate())
                .used(userCoupon.getUsed())
                .usedDate(userCoupon.getUsedDate())

                .build();
    }

    //helper method for coupon code generation

    private String generateGiveawayCode() {

        Random random = new Random();

        return "CP" +
                (1000 + random.nextInt(9000));
    }
}