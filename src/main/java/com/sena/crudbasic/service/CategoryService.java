package com.sena.crudbasic.service;

import com.sena.crudbasic.dto.request.CategoryCreateDto;
import com.sena.crudbasic.dto.response.CategoryResponseDto;

public interface CategoryService extends GenericService<CategoryCreateDto, CategoryResponseDto, Integer> {
}
