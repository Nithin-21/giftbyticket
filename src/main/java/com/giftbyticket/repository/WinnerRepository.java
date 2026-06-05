package com.giftbyticket.repository;

import com.giftbyticket.entity.Winner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WinnerRepository
        extends JpaRepository<Winner, Long> {
}
