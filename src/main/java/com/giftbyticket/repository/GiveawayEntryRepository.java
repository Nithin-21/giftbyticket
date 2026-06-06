package com.giftbyticket.repository;

import com.giftbyticket.entity.GiveawayEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiveawayEntryRepository
        extends JpaRepository<GiveawayEntry, Long> {
    boolean existsByUserIdAndCampaignId(
            Long userId,
            Long campaignId);
}
