package com.giftbyticket.repository;

import com.giftbyticket.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository
        extends JpaRepository<Coupon, Long> {
}
