package com.sena.crudbasic.service.impl;

import com.sena.crudbasic.dto.request.InventoryCreateDto;
import com.sena.crudbasic.dto.response.InventoryResponseDto;
import com.sena.crudbasic.dto.response.BranchResponseDto;
import com.sena.crudbasic.model.Inventory;
import com.sena.crudbasic.model.Branch;
import com.sena.crudbasic.repository.InventoryRepository;
import com.sena.crudbasic.repository.BranchRepository;
import com.sena.crudbasic.service.InventoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class InventoryServiceImpl
        extends GenericServiceImpl<Inventory, InventoryCreateDto, InventoryResponseDto, Integer>
        implements InventoryService {

    private final InventoryRepository inventoryRepository;
    private final BranchRepository branchRepository;

    @Override
    protected Inventory mapToEntity(InventoryCreateDto dto) {

        Branch branch = branchRepository.findById(dto.getBranchId())
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        return Inventory.builder()
                .name(dto.getName())
                .branch(branch)
                .build();
    }

    @Override
    protected void updateEntity(Inventory entity, InventoryCreateDto dto) {

        entity.setName(dto.getName());

        Branch branch = branchRepository.findById(dto.getBranchId())
                .orElseThrow(() -> new RuntimeException("Sucursal no encontrada"));

        entity.setBranch(branch);
    }

    @Override
    protected InventoryResponseDto mapToResponse(Inventory entity) {
        return InventoryResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .branch(entity.getBranch() != null ?
                        BranchResponseDto.builder()
                                .id(entity.getBranch().getId())
                                .name(entity.getBranch().getName())
                                .build() : null)
                .build();
    }

    @Override
    protected JpaRepository<Inventory, Integer> getRepository() {
        return inventoryRepository;
    }

    @Override
    protected String getEntityName() {
        return "Inventario";
    }
}
