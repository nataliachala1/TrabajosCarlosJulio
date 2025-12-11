package com.sena.crudbasic.service.impl;

import com.sena.crudbasic.dto.request.ProviderCreateDto;
import com.sena.crudbasic.dto.response.ProviderResponseDto;
import com.sena.crudbasic.model.Provider;
import com.sena.crudbasic.repository.ProviderRepository;
import com.sena.crudbasic.service.ProviderService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProviderServiceImpl
        extends GenericServiceImpl<Provider, ProviderCreateDto, ProviderResponseDto, Integer>
        implements ProviderService {

    private final ProviderRepository providerRepository;

    @Override
    protected Provider mapToEntity(ProviderCreateDto dto) {
        return Provider.builder()
                .name(dto.getName())
                .build();
    }

    @Override
    protected void updateEntity(Provider entity, ProviderCreateDto dto) {
        entity.setName(dto.getName());
    }

    @Override
    protected ProviderResponseDto mapToResponse(Provider entity) {
        return ProviderResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    protected JpaRepository<Provider, Integer> getRepository() {
        return providerRepository;
    }

    @Override
    protected String getEntityName() {
        return "Proveedor";
    }
}
