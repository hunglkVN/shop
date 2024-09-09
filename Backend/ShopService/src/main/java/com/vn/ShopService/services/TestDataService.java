package com.vn.ShopService.services;

import com.vn.ShopService.dtos.TestDataDto;
import com.vn.ShopService.filters.TestDataFilter;
import org.springframework.data.domain.Page;

public interface TestDataService {
    Page<TestDataDto> search(TestDataFilter filter);

    void insertData();
}
