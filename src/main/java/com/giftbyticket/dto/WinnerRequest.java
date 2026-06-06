package com.giftbyticket.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class WinnerRequest {

    private Long campaignId;
    private Long userId;
    private LocalDate winnerDate;
}