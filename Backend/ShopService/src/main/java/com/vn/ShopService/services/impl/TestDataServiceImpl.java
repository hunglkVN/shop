package com.vn.ShopService.services.impl;

import com.vn.ShopService.dtos.TestDataDto;
import com.vn.ShopService.entities.TestData;
import com.vn.ShopService.filters.TestDataFilter;
import com.vn.ShopService.repositories.TestDataRepository;
import com.vn.ShopService.services.TestDataService;
import com.vn.ShopService.utils.DateUtils;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TestDataServiceImpl implements TestDataService {
    final TestDataRepository testDataRepository;
    @Override
    public Page<TestDataDto> search(TestDataFilter filter) {
        Pageable pageable = filter.toPageable();
        return testDataRepository.search(filter, pageable);
    }

//    @Scheduled(initialDelay = 10, fixedDelay=Long.MAX_VALUE)
    @Override
    public void insertData() {
        int n = 4000000;
        int i = 2000001;
        int j = 0;
        int m = 0;
        List<TestData> testDataList = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        long endTime = 0;
        long duration = 0;
        Date date = new Date();
        while (i < n) {
            TestData testData = new TestData();
            testData.setCode("HNOI_" + i);
            testData.setName("Hà Nội HN" + i);
            testData.setNote("Đây là thành phố Hà Nội HN: " + i);
            testData.setCreateTime(DateUtils.addDay(date, 1));
            testData.setUpdateTime(DateUtils.addDay(date, 1));
            testDataList.add(testData);
            j++;
            if (j == 5000) {
                testDataRepository.saveAll(testDataList);
                testDataList = new ArrayList<>();
                j = 0;
                endTime = System.currentTimeMillis();
                duration = endTime - startTime;
                System.out.println("save " + m + ": " + duration);
                m++;
                startTime = System.currentTimeMillis();
            }
            i++;
        }
    }
}
