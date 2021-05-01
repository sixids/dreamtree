package com.dreamtree.webservice.domain.stores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

public interface StoresRepository extends JpaRepository<Stores, Integer>, StoresRepositoryCustom {

    @Query("select s " +
            "from Stores s " +
            "order by s.store_id desc ")
    Stream<Stores> findAllDesc();

    @Query("select s " +
            "from Stores s " +
            "where s.store_id = :store_id")
    Stream<Stores> getStoreByStore_id(
            @Param("store_id") int store_id
    );

}
