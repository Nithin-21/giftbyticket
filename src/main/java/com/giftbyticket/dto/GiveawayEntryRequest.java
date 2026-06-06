package com.giftbyticket.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GiveawayEntryRequest {

    private Long userId;
    private Long campaignId;
}