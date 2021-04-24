package com.dreamtree.webservice.service;

import com.dreamtree.webservice.domain.stores.StoresRepository;
import com.dreamtree.webservice.dto.stores.StoresMainResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class StoresService {

    private StoresRepository storesRepository;

    @Transactional(readOnly = true)
    public List<StoresMainResponseDto> findAllDesc() {
        return storesRepository.findAllDesc()
                .map(StoresMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public StoresMainResponseDto getStoreByStore_id(int store_id) {
        return storesRepository.getStoreByStore_id(store_id)
                .map(StoresMainResponseDto::new)
                .collect(Collectors.toList())
                .get(0);
    }

    @Transactional(readOnly = true)
    public List<StoresMainResponseDto> getStoresByLatAndLng(double top, double bottom, double left, double right) {
        return storesRepository.getStoresByLatAndLng(top, bottom, left, right)
                .map(StoresMainResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public List<StoresMainResponseDto> getStoresByLatAndLngAndStore_type(
            double top, double bottom, double left, double right, String store_type
    ) {
        return storesRepository.getStoresByLatAndLngAndStore_type(top, bottom, left, right, store_type)
                .map(StoresMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
