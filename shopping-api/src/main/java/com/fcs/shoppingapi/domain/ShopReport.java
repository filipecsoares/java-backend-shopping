package com.fcs.shoppingapi.domain;

public class ShopReport {
    private Integer count;
    private Double total;
    private Double mean;

    public ShopReport() {

    }

    public ShopReport(Integer count, Double total, Double mean) {
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
