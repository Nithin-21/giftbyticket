package com.giftbyticket.service;

import com.giftbyticket.dto.WinnerRequest;
import com.giftbyticket.dto.WinnerResponse;

import java.util.List;

public interface WinnerService {

    WinnerResponse createWinner(WinnerRequest request);

    List<WinnerResponse> getAllWinners();

    WinnerResponse getWinnerById(Long id);

    void deleteWinner(Long id);

    WinnerResponse updateWinner(Long id, WinnerRequest request);
}