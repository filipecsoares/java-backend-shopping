package com.fcs.shoppingapi.reporitoty;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;

import com.fcs.shoppingapi.domain.ShopReport;
import com.fcs.shoppingapi.model.Shop;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

public class ReportRepositoryImpl implements ReportRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Shop> getShopByFilters(Date starDate, Date endDate, Float minValue) {
        StringBuilder sb = new StringBuilder();
        sb.append("select s ");
        sb.append("from shop s ");
        sb.append("where s.createdAt >= :starDate ");
        if (endDate != null) {
            sb.append("and s.createdAt <= :endDate ");
        }
        if (minValue != null) {
            sb.append("and s.total <= :minValue ");
        }
        Query query = entityManager.createQuery(sb.toString());
        query.setParameter("starDate", starDate);
        if (endDate != null) {
            query.setParameter("endDate", endDate);
        }
        if (minValue != null) {
            query.setParameter("minValue", minValue);
        }
        return query.getResultList();
    }

    @Override
    public ShopReport getReportByDate(Date starDate, Date endDate) {
        StringBuilder sb = new StringBuilder();
        sb.append("select count(sp.id), sum(sp.total), avg(sp.total) ");
        sb.append("from shopping.shop sp ");
        sb.append("where sp.createdAt >= :starDate ");
        sb.append("and sp.createdAt <= :endDate ");
        Query query = entityManager.createNativeQuery(sb.toString());
        query.setParameter("starDate", starDate);
        query.setParameter("endDate", endDate);
        Object[] result = (Object[]) query.getSingleResult();
        ShopReport shopReport = new ShopReport(((BigInteger) result[0]).intValue(), (Double) result[1], (Double) result[2]);
        return shopReport;
    }

}
