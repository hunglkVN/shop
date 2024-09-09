package com.vn.ShopService.controllers;

import com.vn.ShopService.filters.TestDataFilter;
import com.vn.ShopService.services.TestDataService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/test-data")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestDataController {
    final TestDataService testDataService;

    @GetMapping
    public ResponseEntity search(TestDataFilter filter) {
        return ResponseEntity.status(HttpStatus.OK).body(testDataService.search(filter));
    }
}
