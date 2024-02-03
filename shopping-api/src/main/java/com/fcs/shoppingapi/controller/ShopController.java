package com.fcs.shoppingapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fcs.shoppingapi.protocol.ShopRequest;
import com.fcs.shoppingapi.protocol.ShopResponse;
import com.fcs.shoppingapi.service.ShopService;

import jakarta.validation.Valid;

@RequestMapping("/shopping")
@RestController
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping
    public ResponseEntity<List<ShopResponse>> getShops() {
        final var response = shopService.getAll().orElse(List.of()).stream().map(ShopResponse::from).toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/shopByUser/{userIdentifier}")
    public ResponseEntity<List<ShopResponse>> getShops(@PathVariable String userIdentifier) {
        final var response = shopService.getByUser(userIdentifier).orElse(List.of()).stream().map(ShopResponse::from)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/shopByDate/{date}")
    public ResponseEntity<List<ShopResponse>> getShopsByDate(@PathVariable String date) throws Exception {
        List<ShopResponse> response = shopService.getByDate(date).orElse(List.of()).stream().map(ShopResponse::from)
                .toList();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShopResponse> findById(@PathVariable Long id) {
        final var response = shopService.findById(id).map(ShopResponse::from).orElse(null);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ShopResponse> newShop(@Valid @RequestBody ShopRequest request) {
        final var shop = shopService.save(request.toModel()).orElse(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(ShopResponse.from(shop));
    }
}
