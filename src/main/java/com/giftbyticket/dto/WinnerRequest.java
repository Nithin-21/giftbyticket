package com.giftbyticket.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class WinnerRequest {

    private Long campaignId;
    private Long userId;
    private LocalDate winnerDate;
}