package com.sena.crudbasic.service.impl;

import com.sena.crudbasic.dto.request.BuyProviderCreateDto;
import com.sena.crudbasic.dto.response.BuyProviderResponseDto;
import com.sena.crudbasic.dto.response.EmployeeResponseDto;
import com.sena.crudbasic.dto.response.ProviderResponseDto;
import com.sena.crudbasic.model.BuyProvider;
import com.sena.crudbasic.model.Employee;
import com.sena.crudbasic.model.Provider;
import com.sena.crudbasic.repository.BuyProviderRepository;
import com.sena.crudbasic.repository.EmployeeRepository;
import com.sena.crudbasic.repository.ProviderRepository;
import com.sena.crudbasic.service.BuyProviderService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BuyProviderServiceImpl
        extends GenericServiceImpl<BuyProvider, BuyProviderCreateDto, BuyProviderResponseDto, Integer>
        implements BuyProviderService {

    private final BuyProviderRepository buyProviderRepository;
    private final ProviderRepository providerRepository;
    private final EmployeeRepository employeeRepository;

    // ============================================================
    // DTO → ENTIDAD
    // ============================================================
    @Override
    protected BuyProvider mapToEntity(BuyProviderCreateDto dto) {
        return BuyProvider.builder()
                .name(dto.getName())
                .provider(
                        providerRepository.findById(dto.getProviderId())
                                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"))
                )
                .employee(
                        employeeRepository.findById(dto.getEmployeeId())
                                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"))
                )
                .build();
    }

    // ============================================================
    // UPDATE
    // ============================================================
    @Override
    protected void updateEntity(BuyProvider entity, BuyProviderCreateDto dto) {

        entity.setName(dto.getName());

        Provider provider = providerRepository.findById(dto.getProviderId())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        Employee employee = employeeRepository.findById(dto.getEmployeeId())
                .orElseThrow(() -> new RuntimeException("Empleado no encontrado"));

        entity.setProvider(provider);
        entity.setEmployee(employee);
    }

    // ============================================================
    // ENTIDAD → RESPONSE DTO
    // ============================================================
    @Override
    protected BuyProviderResponseDto mapToResponse(BuyProvider entity) {

        return BuyProviderResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .provider(
                        entity.getProvider() != null ?
                                ProviderResponseDto.builder()
                                        .id(entity.getProvider().getId())
                                        .name(entity.getProvider().getName())
                                        .build()
                                : null
                )
                .employee(
                        entity.getEmployee() != null ?
                                EmployeeResponseDto.builder()
                                        .id(entity.getEmployee().getId())
                                        .name(entity.getEmployee().getName())
                                        .build()
                                : null
                )
                .build();
    }

    // ============================================================
    // REPOSITORIO PARA LA CLASE GENÉRICA
    // ============================================================
    @Override
    protected JpaRepository<BuyProvider, Integer> getRepository() {
        return buyProviderRepository;
    }

    @Override
    protected String getEntityName() {
        return "Compra a Proveedor";
    }
}