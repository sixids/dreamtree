package com.dreamtree.webservice.domain.stores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.stream.Stream;

public interface StoresRepository extends JpaRepository<Stores, Integer> {

    @Query("select s " +
    "from Stores s " +
    "order by s.store_id desc ")
    Stream<Stores> findAllDesc();

}
