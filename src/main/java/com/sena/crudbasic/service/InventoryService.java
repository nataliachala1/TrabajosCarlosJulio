package com.sena.crudbasic.service;

import com.sena.crudbasic.dto.request.InventoryCreateDto;
import com.sena.crudbasic.dto.response.InventoryResponseDto;

public interface InventoryService extends GenericService<InventoryCreateDto, InventoryResponseDto, Integer> {
}
