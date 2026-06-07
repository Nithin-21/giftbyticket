package com.giftbyticket.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GiveawayEntryResponse {

    private Long id;

    private Long userId;

    private Long campaignId;

    private LocalDateTime entryDate;


    private String campaignName;
    private String couponTitle;
    private String giveawayCode;
}