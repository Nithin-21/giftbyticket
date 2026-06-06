package com.giftbyticket.service.impl;

import com.giftbyticket.dto.GiveawayEntryRequest;
import com.giftbyticket.dto.GiveawayEntryResponse;
import com.giftbyticket.entity.GiveawayEntry;
import com.giftbyticket.repository.GiveawayEntryRepository;
import com.giftbyticket.service.GiveawayEntryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GiveawayEntryServiceImpl
        implements GiveawayEntryService {

    private final GiveawayEntryRepository giveawayEntryRepository;

    @Override
    public GiveawayEntryResponse createEntry(
            GiveawayEntryRequest request) {

        GiveawayEntry entry = GiveawayEntry.builder()
                .userId(request.getUserId())
                .campaignId(request.getCampaignId())
                .entryDate(LocalDateTime.now())
                .build();

        GiveawayEntry savedEntry =
                giveawayEntryRepository.save(entry);

        return mapToResponse(savedEntry);
    }

    @Override
    public List<GiveawayEntryResponse> getAllEntries() {

        return giveawayEntryRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public GiveawayEntryResponse getEntryById(Long id) {

        GiveawayEntry entry =
                giveawayEntryRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Entry not found"));

        return mapToResponse(entry);
    }

    @Override
    public void deleteEntry(Long id) {

        giveawayEntryRepository.deleteById(id);
    }

    private GiveawayEntryResponse mapToResponse(
            GiveawayEntry entry) {

        return GiveawayEntryResponse.builder()
                .id(entry.getId())
                .userId(entry.getUserId())
                .campaignId(entry.getCampaignId())
                .entryDate(entry.getEntryDate())
                .build();
    }
}