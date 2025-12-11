package com.sena.crudbasic.controller;

import com.sena.crudbasic.dto.request.SaleCreateDto;
import com.sena.crudbasic.dto.response.SaleResponseDto;
import com.sena.crudbasic.dto.view.JsonViews;
import com.sena.crudbasic.service.SaleService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.List;

@RestController
@RequestMapping("/api/sales")
@RequiredArgsConstructor
@Tag(name = "Sales", description = "API para gestión de ventas")
public class SaleController {

    private final SaleService saleService;

    @GetMapping
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<SaleResponseDto>> getAll() {
        return ResponseEntity.ok(saleService.findAll());
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<SaleResponseDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(saleService.findById(id));
    }

    @PostMapping
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<SaleResponseDto> create(@Valid @RequestBody SaleCreateDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(saleService.create(dto));
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<SaleResponseDto> update(@PathVariable Integer id,
                                                  @Valid @RequestBody SaleCreateDto dto) {
        return ResponseEntity.ok(saleService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        saleService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
