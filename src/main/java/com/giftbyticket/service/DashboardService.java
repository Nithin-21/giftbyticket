package com.giftbyticket.service;

import com.giftbyticket.dto.DashboardResponse;

public interface DashboardService {

    DashboardResponse getDashboardStats();

    DashboardResponse getUserDashboard(Long userId);

}