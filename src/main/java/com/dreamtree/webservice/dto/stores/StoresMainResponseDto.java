package com.dreamtree.webservice.dto.stores;

import com.dreamtree.webservice.domain.stores.Stores;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
public class StoresMainResponseDto {
    private int store_id;
    private String name;
    private String store_type;
    private String addr1;
    private String addr2;
    private String phone_number;
    private double lat;
    private double lng;
    private String last_modified_date;

    public StoresMainResponseDto(Stores entity){
        store_id = entity.getStore_id();
        name = entity.getName();
        store_type = entity.getStore_type();
        addr1 = entity.getAddr1();
        addr2 = entity.getAddr2();
        phone_number = entity.getPhone_number();
        lat = entity.getLat();
        lng = entity.getLng();
        last_modified_date = toStringDateTime(entity.getLast_modified_date());
    }

    private String toStringDateTime(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return Optional.ofNullable(localDateTime)
                .map(formatter::format)
                .orElse("");
    }
}
