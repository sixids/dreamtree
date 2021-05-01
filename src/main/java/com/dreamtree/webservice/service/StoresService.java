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
    public List<StoresMainResponseDto> getStoresByDynamicQuery(
            double bottom, double left, double top, double right, String name, String card
    ){
        return storesRepository.getStoresDynamicQuery(bottom, left, top, right, name, card)
                .stream()
                .map(StoresMainResponseDto::new)
                .collect(Collectors.toList());
    }
}
