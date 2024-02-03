package com.fcs.shoppingapi.protocol;

import com.fcs.shoppingapi.domain.ShopReport;

public class ShopReportResponse {
    private Integer count;
    private Double total;
    private Double mean;

    public ShopReportResponse() {

    }

    public ShopReportResponse(Integer count, Double total, Double mean) {
        this.count = count;
        this.total = total;
        this.mean = mean;
    }

    public static ShopReportResponse from(ShopReport shopReport) {
        return new ShopReportResponse(shopReport.getCount(), shopReport.getTotal(), shopReport.getMean());
    }

    public Integer getCount() {
        return count;
    }

    public Double getTotal() {
        return total;
    }

    public Double getMean() {
        return mean;
    }
}
