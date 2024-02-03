package com.fcs.shoppingapi.reporitoty;

import java.util.Date;
import java.util.List;

import com.fcs.shoppingapi.domain.ShopReport;
import com.fcs.shoppingapi.model.Shop;

public interface ReportRepository {
    public List<Shop> getShopByFilters(Date dataInicio, Date dataFim, Float valorMinimo);

    public ShopReport getReportByDate(Date dataInicio, Date dataFim);
}
