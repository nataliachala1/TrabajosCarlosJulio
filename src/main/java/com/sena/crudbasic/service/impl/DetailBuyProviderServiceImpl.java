package com.sena.crudbasic.service.impl;

import com.sena.crudbasic.dto.request.DetailBuyProviderCreateDto;
import com.sena.crudbasic.dto.response.DetailBuyProviderResponseDto;
import com.sena.crudbasic.dto.response.BuyProviderResponseDto;
import com.sena.crudbasic.dto.response.ProductResponseDto;
import com.sena.crudbasic.model.DetailBuyProvider;
import com.sena.crudbasic.model.BuyProvider;
import com.sena.crudbasic.model.Product;
import com.sena.crudbasic.repository.DetailBuyProviderRepository;
import com.sena.crudbasic.repository.BuyProviderRepository;
import com.sena.crudbasic.repository.ProductRepository;
import com.sena.crudbasic.service.DetailBuyProviderService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DetailBuyProviderServiceImpl
        extends GenericServiceImpl<DetailBuyProvider, DetailBuyProviderCreateDto, DetailBuyProviderResponseDto, Integer>
        implements DetailBuyProviderService {

    private final DetailBuyProviderRepository detailBuyProviderRepository;
    private final BuyProviderRepository buyProviderRepository;
    private final ProductRepository productRepository;

    @Override
    protected DetailBuyProvider mapToEntity(DetailBuyProviderCreateDto dto) {

        BuyProvider buyProvider = buyProviderRepository.findById(dto.getBuyProviderId())
                .orElseThrow(() -> new RuntimeException("Compra a proveedor no encontrada"));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        return DetailBuyProvider.builder()
                .name(dto.getName())
                .buyProvider(buyProvider)
                .product(product)
                .build();
    }

    @Override
    protected void updateEntity(DetailBuyProvider entity, DetailBuyProviderCreateDto dto) {
        entity.setName(dto.getName());

        BuyProvider buyProvider = buyProviderRepository.findById(dto.getBuyProviderId())
                .orElseThrow(() -> new RuntimeException("Compra a proveedor no encontrada"));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        entity.setBuyProvider(buyProvider);
        entity.setProduct(product);
    }

    @Override
    protected DetailBuyProviderResponseDto mapToResponse(DetailBuyProvider entity) {
        return DetailBuyProviderResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .buyProvider(entity.getBuyProvider() != null ? BuyProviderResponseDto.builder()
                        .id(entity.getBuyProvider().getId())
                        .name(entity.getBuyProvider().getName())
                        .build() : null)
                .product(entity.getProduct() != null ? ProductResponseDto.builder()
                        .id(entity.getProduct().getId())
                        .name(entity.getProduct().getName())
                        .build() : null)
                .build();
    }

    @Override
    protected JpaRepository<DetailBuyProvider, Integer> getRepository() {
        return detailBuyProviderRepository;
    }

    @Override
    protected String getEntityName() {
        return "Detalle de Compra a Proveedor";
    }
}
