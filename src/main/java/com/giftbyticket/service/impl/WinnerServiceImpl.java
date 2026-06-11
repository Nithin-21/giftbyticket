package com.giftbyticket.service.impl;

import com.giftbyticket.dto.WinnerRequest;
import com.giftbyticket.dto.WinnerResponse;
import com.giftbyticket.entity.Winner;
import com.giftbyticket.repository.WinnerRepository;
import com.giftbyticket.service.WinnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WinnerServiceImpl implements WinnerService {

    private final WinnerRepository winnerRepository;

    @Override
    public WinnerResponse createWinner(WinnerRequest request) {

        Winner winner = Winner.builder()
                .campaignId(request.getCampaignId())
                .userId(request.getUserId())
                .winnerDate(LocalDate.now())
                .build();

        Winner savedWinner = winnerRepository.save(winner);

        return mapToResponse(savedWinner);
    }

    @Override
    public List<WinnerResponse> getAllWinners() {

        return winnerRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public WinnerResponse getWinnerById(Long id) {

        Winner winner = winnerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Winner not found"));

        return mapToResponse(winner);
    }


    @Override
    public void deleteWinner(Long id) {

        winnerRepository.deleteById(id);
    }
    @Override
    public WinnerResponse updateWinner(Long id,
                                       WinnerRequest request) {

        Winner winner = winnerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Winner not found"));

        winner.setWinnerDate(request.getWinnerDate());


        Winner updatedWinner = winnerRepository.save(winner);

        return mapToResponse(updatedWinner);
    }

    private WinnerResponse mapToResponse(Winner winner) {

        return WinnerResponse.builder()
                .id(winner.getId())
                .campaignId(winner.getCampaignId())
                .userId(winner.getUserId())
                .winnerDate(winner.getWinnerDate())
                .build();
    }
}