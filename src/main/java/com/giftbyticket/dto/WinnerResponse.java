package com.giftbyticket.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WinnerResponse {

    private Long id;

    private Long campaignId;

    private Long userId;

    private LocalDate winnerDate;
}