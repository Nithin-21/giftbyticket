package com.giftbyticket.service.impl;

import com.giftbyticket.repository.*;
import com.giftbyticket.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.giftbyticket.dto.DashboardResponse;

@Service
@RequiredArgsConstructor
public class DashboardServiceImpl implements DashboardService {

    private final UserRepository userRepository;
    private final CampaignRepository campaignRepository;
    private final CouponRepository couponRepository;
    private final GiveawayEntryRepository giveawayEntryRepository;
    private final UserCouponRepository userCouponRepository;
    private final WinnerRepository winnerRepository;

    @Override
    public DashboardResponse getDashboardStats() {

        return DashboardResponse.builder()
                .totalUsers(userRepository.count())
                .totalCampaigns(campaignRepository.count())
                .totalCoupons(couponRepository.count())
                .totalEntries(giveawayEntryRepository.count())
                .totalWinners(winnerRepository.count())
                .build();
    }

    @Override
    public DashboardResponse getUserDashboard(Long userId) {

        Long participationCount =
                giveawayEntryRepository.countByUserId(userId);

        Long couponCount =
                userCouponRepository.countByUserId(userId);

        Long winnerCount =
                winnerRepository.countByUserId(userId);

        return DashboardResponse.builder()
                .participationCount(participationCount)
                .couponCount(couponCount)
                .winnerCount(winnerCount)
                .build();
    }
}