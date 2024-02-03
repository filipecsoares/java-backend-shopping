package com.fcs.shoppingapi.protocol;

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
