package com.giftbyticket.repository;

import com.giftbyticket.entity.Campaign;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CampaignRepository extends JpaRepository<Campaign, Long> {
}
