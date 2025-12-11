package com.sena.crudbasic.service.impl;

import com.sena.crudbasic.dto.request.SaleDetailCreateDto;
import com.sena.crudbasic.dto.response.SaleDetailResponseDto;
import com.sena.crudbasic.dto.response.ProductResponseDto;
import com.sena.crudbasic.dto.response.SaleResponseDto;
import com.sena.crudbasic.model.Product;
import com.sena.crudbasic.model.Sale;
import com.sena.crudbasic.model.SaleDetail;
import com.sena.crudbasic.repository.ProductRepository;
import com.sena.crudbasic.repository.SaleDetailRepository;
import com.sena.crudbasic.repository.SaleRepository;
import com.sena.crudbasic.service.SaleDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SaleDetailServiceImpl
        extends GenericServiceImpl<SaleDetail, SaleDetailCreateDto, SaleDetailResponseDto, Integer>
        implements SaleDetailService {

    private final SaleDetailRepository saleDetailRepository;
    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;

    @Override
    protected SaleDetail mapToEntity(SaleDetailCreateDto dto) {
        Sale sale = saleRepository.findById(dto.getSaleId())
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        return SaleDetail.builder()
                .name(dto.getName())
                .description(dto.getDescription())
                .sale(sale)
                .product(product)
                .build();
    }

    @Override
    protected void updateEntity(SaleDetail entity, SaleDetailCreateDto dto) {
        entity.setName(dto.getName());
        entity.setDescription(dto.getDescription());

        Sale sale = saleRepository.findById(dto.getSaleId())
                .orElseThrow(() -> new RuntimeException("Venta no encontrada"));

        Product product = productRepository.findById(dto.getProductId())
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        entity.setSale(sale);
        entity.setProduct(product);
    }

    @Override
    protected SaleDetailResponseDto mapToResponse(SaleDetail entity) {
        return SaleDetailResponseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .description(entity.getDescription())
                .sale(entity.getSale() != null ?
                        SaleResponseDto.builder()
                                .id(entity.getSale().getId())
                                .name(entity.getSale().getName())
                                .build()
                        : null)
                .product(entity.getProduct() != null ?
                        ProductResponseDto.builder()
                                .id(entity.getProduct().getId())
                                .name(entity.getProduct().getName())
                                .build()
                        : null)
                .build();
    }

    @Override
    protected JpaRepository<SaleDetail, Integer> getRepository() {
        return saleDetailRepository;
    }

    @Override
    protected String getEntityName() {
        return "Detalle de Venta";
    }
}
