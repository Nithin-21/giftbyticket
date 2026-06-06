package com.giftbyticket.repository;

import com.giftbyticket.entity.UserCoupon;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserCouponRepository extends JpaRepository<UserCoupon, Long> {

    List<UserCoupon> findByUserId(Long userId);
    List<UserCoupon> findByCampaignId(Long campaignId);
}