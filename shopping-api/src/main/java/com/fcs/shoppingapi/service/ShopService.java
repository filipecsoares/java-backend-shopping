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

    private final UserService userService;

    private final ProductService productService;

    public ShopService(ShopRepository shopRepository, UserService userService, ProductService productService) {
        this.shopRepository = shopRepository;
        this.userService = userService;
        this.productService = productService;
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
        if (userService.getUserByEmail(shop.getUserIdentifier()) == null) {
            return Optional.empty();
        }
        if (!validateProducts(shop.getItems())) {
            return Optional.empty();
        }
        shop.setCreatedAt(new Date());
        shop.setTotal(shop.getItems().stream().map(Item::getPrice).reduce((float) 0, Float::sum));
        return Optional.of(shopRepository.save(shop));
    }

    private boolean validateProducts(List<Item> items) {
        if (items == null) {
            return false;
        }
        for (Item item : items) {
            final var product = productService.getProductByIdentifier(item.getProductIdentifier());
            if (product == null) {
                return false;
            }
            item.setPrice(product.getPrice());
        }
        return true;
    }
}
