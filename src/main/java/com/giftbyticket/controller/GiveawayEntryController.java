package com.giftbyticket.controller;

import com.giftbyticket.dto.GiveawayEntryRequest;
import com.giftbyticket.dto.GiveawayEntryResponse;
import com.giftbyticket.service.GiveawayEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entries")
@RequiredArgsConstructor
public class GiveawayEntryController {

    private final GiveawayEntryService giveawayEntryService;

    @PostMapping
    public GiveawayEntryResponse createEntry(
            @RequestBody GiveawayEntryRequest request) {

        return giveawayEntryService.createEntry(request);
    }

    @GetMapping
    public List<GiveawayEntryResponse> getAllEntries() {

        return giveawayEntryService.getAllEntries();
    }

    @GetMapping("/{id}")
    public GiveawayEntryResponse getEntryById(
            @PathVariable Long id) {

        return giveawayEntryService.getEntryById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEntry(
            @PathVariable Long id) {

        giveawayEntryService.deleteEntry(id);
    }
}