package com.dreamtree.webservice.domain.stores;

import com.dreamtree.webservice.domain.StoresTimeEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class Stores extends StoresTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int store_id;

    @Column(length = 50, nullable = false)
    private String card;

    @Column(length = 300, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String store_type;

    @Column(length = 100)
    private String addr1;

    @Column(length = 100)
    private String addr2;

    @Column(length = 30)
    private String phone_number;

    // DB에서 decimal(12,8)로 해놨는데, java에서 뭘로 받아야 할지 모름
    @Column
    private double lat;

    // DB에서 decimal(12,8)로 해놨는데, java에서 뭘로 받아야 할지 모름
    @Column
    private double lng;

    @Builder
    public Stores(String name, String card, String store_type, String addr1, String addr2, String phone_number, double lat, double lng){
        this.name = name;
        this.card = card;
        this.store_type = store_type;
        this.addr1 = addr1;
        this.addr2 = addr2;
        this.phone_number = phone_number;
        this.lat = lat;
        this.lng = lng;
    }
}
