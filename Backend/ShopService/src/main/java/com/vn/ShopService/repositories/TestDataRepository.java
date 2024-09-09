package com.vn.ShopService.repositories;

import com.vn.ShopService.dtos.TestDataDto;
import com.vn.ShopService.entities.TestData;
import com.vn.ShopService.filters.TestDataFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDataRepository extends JpaRepository<TestData, String> {

    @Query(value = "select new com.vn.ShopService.dtos.TestDataDto(td.id, td.code, td.name, td.name) " +
            " from TestData td" +
            " where 1 = 1" +
            " and (:#{#filter.code} is null or :#{#filter.code} like '' or lower(td.code) = :#{#filter.code})" +
            " and (:#{#filter.name} is null or :#{#filter.name} like '' or lower(td.name) like %:#{#filter.name}% escape '!')")
    Page<TestDataDto> search(@Param("filter")TestDataFilter filter, Pageable pageable);
}
