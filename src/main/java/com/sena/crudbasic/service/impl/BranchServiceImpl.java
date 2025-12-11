package com.sena.crudbasic.service.impl;

import com.sena.crudbasic.dto.request.BranchCreateDto;
import com.sena.crudbasic.dto.response.BranchResponseDto;
import com.sena.crudbasic.model.Branch;
import com.sena.crudbasic.repository.BranchRepository;
import com.sena.crudbasic.service.BranchService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BranchServiceImpl extends GenericServiceImpl<Branch, BranchCreateDto, BranchResponseDto, Integer>
        implements BranchService {

    private final BranchRepository branchRepository;

    // ============================================
    // CREATE: Mapear DTO → ENTIDAD
    // ============================================
    @Override
    protected Branch mapToEntity(BranchCreateDto dto) {
        return Branch.builder()
                .name(dto.getName())
                .address(dto.getAddress())
                .build();
    }

    // ============================================
    // UPDATE: Actualizar entidad existente
    // ============================================
    @Override
    protected void updateEntity(Branch branch, BranchCreateDto dto) {
        branch.setName(dto.getName());
        branch.setAddress(dto.getAddress());
    }

    // ============================================
    // Map ENTIDAD → RESPONSE DTO
    // ============================================
    @Override
    protected BranchResponseDto mapToResponse(Branch branch) {
        return BranchResponseDto.builder()
                .id(branch.getId())
                .name(branch.getName())
                .address(branch.getAddress())
                .build();
    }

    // ============================================
    // RETORNAR REPOSITORIO A LA CLASE GENÉRICA
    // ============================================
    @Override
    protected JpaRepository<Branch, Integer> getRepository() {
        return branchRepository;
    }

    @Override
    protected String getEntityName() {
        return "Sucursal";
    }
}
