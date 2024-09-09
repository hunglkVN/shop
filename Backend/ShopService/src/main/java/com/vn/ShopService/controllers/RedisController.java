package com.vn.ShopService.controllers;

import com.vn.ShopService.services.BaseRedisService;
import com.vn.ShopService.services.BaseRedisServiceV2;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/redis")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class RedisController {
    final BaseRedisServiceV2<String, String, String> baseRedisService;

    @PostMapping
    public void set() {
        baseRedisService.set("redis", "hi");
    }

    @GetMapping
    public Object get() {
        return baseRedisService.get("redis");
    }
}
