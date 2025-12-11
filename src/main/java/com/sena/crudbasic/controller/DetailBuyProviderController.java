package com.sena.crudbasic.controller;

import com.sena.crudbasic.dto.request.DetailBuyProviderCreateDto;
import com.sena.crudbasic.dto.response.DetailBuyProviderResponseDto;
import com.sena.crudbasic.dto.view.JsonViews;
import com.sena.crudbasic.service.DetailBuyProviderService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.List;

@RestController
@RequestMapping("/api/detailBuyProviders")
@RequiredArgsConstructor
@Tag(name = "DetailBuyProviders", description = "API para gestión de detalles de compras a proveedores")
public class DetailBuyProviderController {

    private final DetailBuyProviderService detailBuyProviderService;

    @GetMapping
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<DetailBuyProviderResponseDto>> getAll() {
        return ResponseEntity.ok(detailBuyProviderService.findAll());
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<DetailBuyProviderResponseDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(detailBuyProviderService.findById(id));
    }

    @PostMapping
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<DetailBuyProviderResponseDto> create(
            @Valid @RequestBody DetailBuyProviderCreateDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(detailBuyProviderService.create(dto));
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<DetailBuyProviderResponseDto> update(
            @PathVariable Integer id,
            @Valid @RequestBody DetailBuyProviderCreateDto dto) {
        return ResponseEntity.ok(detailBuyProviderService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        detailBuyProviderService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
