package com.sena.crudbasic.controller;

import com.sena.crudbasic.dto.request.ProviderCreateDto;
import com.sena.crudbasic.dto.response.ProviderResponseDto;
import com.sena.crudbasic.dto.view.JsonViews;
import com.sena.crudbasic.service.ProviderService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.List;

@RestController
@RequestMapping("/api/providers")
@RequiredArgsConstructor
@Tag(name = "Providers", description = "API para gestión de proveedores")
public class ProviderController {

    private final ProviderService providerService;

    @GetMapping
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<ProviderResponseDto>> getAll() {
        return ResponseEntity.ok(providerService.findAll());
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<ProviderResponseDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(providerService.findById(id));
    }

    @PostMapping
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<ProviderResponseDto> create(@Valid @RequestBody ProviderCreateDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(providerService.create(dto));
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<ProviderResponseDto> update(@PathVariable Integer id,
                                                      @Valid @RequestBody ProviderCreateDto dto) {
        return ResponseEntity.ok(providerService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        providerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
