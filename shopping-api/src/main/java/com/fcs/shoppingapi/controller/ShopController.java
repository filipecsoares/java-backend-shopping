package com.fcs.shoppingapi.controller;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fcs.shoppingapi.protocol.ShopReportResponse;
import com.fcs.shoppingapi.protocol.ShopRequest;
import com.fcs.shoppingapi.protocol.ShopResponse;
import com.fcs.shoppingapi.service.ReportService;
import com.fcs.shoppingapi.service.ShopService;

import jakarta.validation.Valid;

@RequestMapping("/shopping")
@RestController
public class ShopController {

    private final ShopService shopService;

    private final ReportService reportService;

    public ShopController(ShopService shopService, ReportService reportService) {
        this.shopService = shopService;
        this.reportService = reportService;
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
    public ResponseEntity<ShopResponse> newShop(
        @RequestHeader(name = "key", required = true) String key,
        @Valid @RequestBody ShopRequest request) {
        final var shop = shopService.save(request.toModel(), key).orElse(null);
        return ResponseEntity.status(HttpStatus.CREATED).body(ShopResponse.from(shop));
    }

    @GetMapping("/search")
    public ResponseEntity<List<ShopResponse>> getShopsByFilter(
            @RequestParam(name = "startDate", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate,
            @RequestParam(name = "endDate", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate,
            @RequestParam(name = "minValue", required = false) Float minValue) {
        final var response = reportService.getShopsByFilter(startDate, endDate, minValue);
        return ResponseEntity.ok(response.stream().map(ShopResponse::from).toList());
    }

    @GetMapping("/report")
    public ResponseEntity<ShopReportResponse> getReportByDate(
            @RequestParam(name = "startDate", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") Date startDate,
            @RequestParam(name = "endDate", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") Date endDate) {
        final var report = reportService.getReportByDate(startDate, endDate);
        return ResponseEntity.ok(ShopReportResponse.from(report));
    }
}
