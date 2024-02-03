package com.fcs.shoppingapi.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.fcs.shoppingapi.domain.ShopReport;
import com.fcs.shoppingapi.model.Shop;
import com.fcs.shoppingapi.reporitoty.ReportRepository;

@Service
public class ReportService {

    private final ReportRepository reportRepository;

    public ReportService(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    public List<Shop> getShopsByFilter(Date starDate, Date endDate, Float minValue) {
        return reportRepository.getShopByFilters(starDate, endDate, minValue);
    }

    public ShopReport getReportByDate(Date starDate, Date endDate) {
        return reportRepository.getReportByDate(starDate, endDate);
    }
}
