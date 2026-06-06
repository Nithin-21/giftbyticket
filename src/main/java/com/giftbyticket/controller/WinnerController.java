package com.giftbyticket.controller;

import com.giftbyticket.dto.WinnerRequest;
import com.giftbyticket.dto.WinnerResponse;
import com.giftbyticket.service.WinnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/winners")
@RequiredArgsConstructor
public class WinnerController {

    private final WinnerService winnerService;

    @PostMapping
    public WinnerResponse createWinner(
            @RequestBody WinnerRequest request) {

        return winnerService.createWinner(request);
    }

    @PutMapping("/{id}")
    public WinnerResponse updateWinner(
            @PathVariable Long id,
            @RequestBody WinnerRequest request) {

        return winnerService.updateWinner(id, request);
    }

    @GetMapping
    public List<WinnerResponse> getAllWinners() {

        return winnerService.getAllWinners();
    }

    @GetMapping("/{id}")
    public WinnerResponse getWinnerById(
            @PathVariable Long id) {

        return winnerService.getWinnerById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteWinner(
            @PathVariable Long id) {

        winnerService.deleteWinner(id);
    }
}