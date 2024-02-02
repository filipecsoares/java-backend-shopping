package com.fcs.shoppingapi.reporitoty;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fcs.shoppingapi.model.Shop;

public interface ShopRepository extends JpaRepository<Shop, Long> {

    List<Shop> findAllByUserIdentifier(String userIdentifier);

    List<Shop> findAllByTotalGreaterThan(Float total);

    List<Shop> findAllByDateGreaterThanEquals(Date date);
}
