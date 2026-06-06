package com.giftbyticket.service;

import com.giftbyticket.dto.GiveawayEntryRequest;
import com.giftbyticket.dto.GiveawayEntryResponse;

import java.util.List;

public interface GiveawayEntryService {

    GiveawayEntryResponse createEntry(
            GiveawayEntryRequest request);

    List<GiveawayEntryResponse> getAllEntries();

    GiveawayEntryResponse getEntryById(Long id);

    void deleteEntry(Long id);
}