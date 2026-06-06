package com.giftbyticket.controller;

import com.giftbyticket.dto.AdminDashboardResponse;
import com.giftbyticket.repository.CampaignRepository;
import com.giftbyticket.repository.CouponRepository;
import com.giftbyticket.repository.GiveawayEntryRepository;
import com.giftbyticket.repository.UserRepository;
import com.giftbyticket.repository.WinnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
@RequiredArgsConstructor
public class AdminController {

    private final UserRepository userRepository;
    private final CampaignRepository campaignRepository;
    private final CouponRepository couponRepository;
    private final GiveawayEntryRepository giveawayEntryRepository;
    private final WinnerRepository winnerRepository;

    @GetMapping("/dashboard")
    public AdminDashboardResponse dashboard() {

        return AdminDashboardResponse.builder()
                .totalUsers(userRepository.count())
                .totalCampaigns(campaignRepository.count())
                .totalCoupons(couponRepository.count())
                .totalEntries(giveawayEntryRepository.count())
                .totalWinners(winnerRepository.count())
                .build();
    }
}