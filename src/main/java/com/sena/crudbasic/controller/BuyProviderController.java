package com.sena.crudbasic.controller;

import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonView;

import com.sena.crudbasic.dto.request.BuyProviderCreateDto;
import com.sena.crudbasic.dto.response.BuyProviderResponseDto;
import com.sena.crudbasic.dto.view.JsonViews;
import com.sena.crudbasic.service.BuyProviderService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("api/buyProviders")
@RequiredArgsConstructor
@Tag(name = "BuyProviders", description = "API para gestión de compras a proveedores")
public class BuyProviderController {

    private final BuyProviderService buyProviderService;

    // ============================================
    // GET ALL
    // ============================================
    @GetMapping
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<BuyProviderResponseDto>> getAll() {
        return ResponseEntity.ok(buyProviderService.findAll());
    }

    // ============================================
    // GET BY ID
    // ============================================
    @GetMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<BuyProviderResponseDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(buyProviderService.findById(id));
    }

    // ============================================
    // CREATE
    // ============================================
    @PostMapping
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<BuyProviderResponseDto> create(
            @Valid @RequestBody BuyProviderCreateDto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(buyProviderService.create(dto));
    }

    // ============================================
    // UPDATE
    // ============================================
    @PutMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<BuyProviderResponseDto> update(
            @PathVariable Integer id,
            @Valid @RequestBody BuyProviderCreateDto dto) {

        return ResponseEntity.ok(buyProviderService.update(id, dto));
    }

    // ============================================
    // DELETE
    // ============================================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        buyProviderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
