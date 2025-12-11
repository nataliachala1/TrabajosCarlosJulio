package com.sena.crudbasic.service.impl;

import com.sena.crudbasic.dto.request.CategoryCreateDto;
import com.sena.crudbasic.dto.response.CategoryResponseDto;
import com.sena.crudbasic.model.Category;
import com.sena.crudbasic.repository.CategoryRepository;
import com.sena.crudbasic.service.CategoryService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CategoryServiceImpl
        extends GenericServiceImpl<Category, CategoryCreateDto, CategoryResponseDto, Integer>
        implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    protected Category mapToEntity(CategoryCreateDto dto) {
        return Category.builder()
                .name(dto.getName())
                .build();
    }

    @Override
    protected void updateEntity(Category entity, CategoryCreateDto dto) {
        entity.setName(dto.getName());
    }

    @Override
    protected CategoryResponseDto mapToResponse(Category entity) {
        return CategoryResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    protected JpaRepository<Category, Integer> getRepository() {
        return categoryRepository;
    }

    @Override
    protected String getEntityName() {
        return "Categoría";
    }
}
