package com.fcs.shoppingapi.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fcs.shoppingapi.model.Item;
import com.fcs.shoppingapi.model.Shop;
import com.fcs.shoppingapi.reporitoty.ShopRepository;

@Service
public class ShopService {

    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

    public Optional<List<Shop>> getAll() {
        return Optional.of(shopRepository.findAll());
    }

    public Optional<List<Shop>> getByUser(String userIdentifier) {
        return Optional.of(shopRepository.findAllByUserIdentifier(userIdentifier));
    }

    public Optional<List<Shop>> getByDate(String dateString) throws Exception {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        Date date = formatter.parse(dateString);
        return Optional.of(shopRepository.findAllByDateGreaterThanEquals(date));
    }

    public Optional<Shop> findById(long ProductId) {
        return shopRepository.findById(ProductId);
    }

    public Optional<Shop> save(Shop shop) {
        shop.setCreatedAt(new Date());
        shop.setTotal(shop.getItems().stream().map(Item::getPrice).reduce((float) 0, Float::sum));
        return Optional.of(shopRepository.save(shop));
    }
}
