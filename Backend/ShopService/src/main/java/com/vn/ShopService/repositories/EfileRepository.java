package com.vn.ShopService.repositories;

import com.vn.ShopService.entities.Efile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EfileRepository extends JpaRepository<Efile, String> {

    Efile findByCode(String code);

    @Query(value = "select count(e.id) from Efile e")
    Integer countAllNotDelete();
}
