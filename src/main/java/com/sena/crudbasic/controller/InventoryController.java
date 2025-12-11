package com.sena.crudbasic.controller;

import com.sena.crudbasic.dto.request.InventoryCreateDto;
import com.sena.crudbasic.dto.response.InventoryResponseDto;
import com.sena.crudbasic.dto.view.JsonViews;
import com.sena.crudbasic.service.InventoryService;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fasterxml.jackson.annotation.JsonView;
import java.util.List;

@RestController
@RequestMapping("/api/inventories")
@RequiredArgsConstructor
@Tag(name = "Inventories", description = "API para gestión de inventarios")
public class InventoryController {

    private final InventoryService inventoryService;

    @GetMapping
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<InventoryResponseDto>> getAll() {
        return ResponseEntity.ok(inventoryService.findAll());
    }

    @GetMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<InventoryResponseDto> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(inventoryService.findById(id));
    }

    @PostMapping
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<InventoryResponseDto> create(@Valid @RequestBody InventoryCreateDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(inventoryService.create(dto));
    }

    @PutMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<InventoryResponseDto> update(@PathVariable Integer id,
                                                       @Valid @RequestBody InventoryCreateDto dto) {
        return ResponseEntity.ok(inventoryService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        inventoryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
