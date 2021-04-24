package com.dreamtree.webservice.domain.stores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.stream.Stream;

public interface StoresRepository extends JpaRepository<Stores, Integer> {

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

    @Query("select s " +
            "from Stores s " +
            "where 1=1 " +
            "and s.lat between :top and :bottom " +
            "and s.lng between :left and :right")
    Stream<Stores> getStoresByLatAndLng(
            @Param("top") double top,
            @Param("bottom") double bottom,
            @Param("left") double left,
            @Param("right") double right
    );

    @Query("select s " +
            "from Stores s " +
            "where 1=1 " +
            "and s.lat between :top and :bottom " +
            "and s.lng between :left and :right " +
            "and s.store_type = :store_type")
    Stream<Stores> getStoresByLatAndLngAndStore_type(
            @Param("top") double top,
            @Param("bottom") double bottom,
            @Param("left") double left,
            @Param("right") double right,
            @Param("store_type") String store_type
    );

}
