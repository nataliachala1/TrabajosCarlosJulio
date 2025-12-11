package com.sena.crudbasic.service;

import com.sena.crudbasic.dto.request.ProductCreateDto;
import com.sena.crudbasic.dto.response.ProductResponseDto;

public interface ProductService extends GenericService<ProductCreateDto, ProductResponseDto, Integer> {
}
