package com.sena.crudbasic.service.impl;

import com.sena.crudbasic.dto.request.ProductCreateDto;
import com.sena.crudbasic.dto.response.ProductResponseDto;
import com.sena.crudbasic.dto.response.CategoryResponseDto;
import com.sena.crudbasic.dto.response.ProviderResponseDto;
import com.sena.crudbasic.model.Product;
import com.sena.crudbasic.model.Category;
import com.sena.crudbasic.model.Provider;
import com.sena.crudbasic.repository.ProductRepository;
import com.sena.crudbasic.repository.CategoryRepository;
import com.sena.crudbasic.repository.ProviderRepository;
import com.sena.crudbasic.service.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductServiceImpl
        extends GenericServiceImpl<Product, ProductCreateDto, ProductResponseDto, Integer>
        implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ProviderRepository providerRepository;

    @Override
    protected Product mapToEntity(ProductCreateDto dto) {

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Provider provider = providerRepository.findById(dto.getProviderId())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        return Product.builder()
                .name(dto.getName())
                .category(category)
                .provider(provider)
                .build();
    }

    @Override
    protected void updateEntity(Product entity, ProductCreateDto dto) {

        entity.setName(dto.getName());

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada"));

        Provider provider = providerRepository.findById(dto.getProviderId())
                .orElseThrow(() -> new RuntimeException("Proveedor no encontrado"));

        entity.setCategory(category);
        entity.setProvider(provider);
    }

    @Override
    protected ProductResponseDto mapToResponse(Product entity) {

        return ProductResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .category(entity.getCategory() != null ?
                        CategoryResponseDto.builder()
                                .id(entity.getCategory().getId())
                                .name(entity.getCategory().getName())
                                .build() : null)
                .provider(entity.getProvider() != null ?
                        ProviderResponseDto.builder()
                                .id(entity.getProvider().getId())
                                .name(entity.getProvider().getName())
                                .build() : null)
                .build();
    }

    @Override
    protected JpaRepository<Product, Integer> getRepository() {
        return productRepository;
    }

    @Override
    protected String getEntityName() {
        return "Producto";
    }
}
