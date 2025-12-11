package com.sena.crudbasic.controller;

import com.sena.crudbasic.dto.request.SaleDetailCreateDto;
import com.sena.crudbasic.dto.response.SaleDetailResponseDto;
import com.sena.crudbasic.dto.view.JsonViews;
import com.sena.crudbasic.service.SaleDetailService;
import com.fasterxml.jackson.annotation.JsonView;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/saleDetails")
@RequiredArgsConstructor
@Tag(name = "SaleDetails", description = "API para gestión de detalles de venta")
public class SaleDetailController {

    private final SaleDetailService saleDetailService;

    @GetMapping
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<SaleDetailResponseDto>> getAll() {
        return ResponseEntity.ok(saleDetailService.findAll());
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<SaleDetailResponseDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(saleDetailService.findById(id));
    }

    @PostMapping
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<SaleDetailResponseDto> create(@Valid @RequestBody SaleDetailCreateDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(saleDetailService.create(dto));
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<SaleDetailResponseDto> update(@PathVariable Integer id,
                                                        @Valid @RequestBody SaleDetailCreateDto dto) {
        return ResponseEntity.ok(saleDetailService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        saleDetailService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
