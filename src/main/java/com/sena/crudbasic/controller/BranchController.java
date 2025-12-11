package com.sena.crudbasic.controller;

import org.springframework.web.bind.annotation.*;
import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crudbasic.dto.request.BranchCreateDto;
import com.sena.crudbasic.dto.response.BranchResponseDto;
import com.sena.crudbasic.dto.view.JsonViews;
import com.sena.crudbasic.service.BranchService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;

@RestController
@RequestMapping("/api/branches")
@RequiredArgsConstructor
@Tag(name = "Branches", description = "API para gestión de sucursales")
public class BranchController {

    private final BranchService branchService;

    // ==========================================================
    // GET ALL
    // ==========================================================
    @GetMapping
    @JsonView(JsonViews.Resumen.class)
    public ResponseEntity<List<BranchResponseDto>> getAllBranches() {
        return ResponseEntity.ok(branchService.findAll());
    }

    // ==========================================================
    // GET BY ID
    // ==========================================================
    @GetMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<BranchResponseDto> getBranchById(@PathVariable Integer id) {
        return ResponseEntity.ok(branchService.findById(id));
    }

    // ==========================================================
    // CREATE
    // ==========================================================
    @PostMapping
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<BranchResponseDto> createBranch(
            @Valid @RequestBody BranchCreateDto dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(branchService.create(dto));
    }

    // ==========================================================
    // UPDATE
    // ==========================================================
    @PutMapping("/{id}")
    @JsonView(JsonViews.Detalle.class)
    public ResponseEntity<BranchResponseDto> updateBranch(
            @PathVariable Integer id,
            @Valid @RequestBody BranchCreateDto dto) {

        return ResponseEntity.ok(branchService.update(id, dto));
    }

    // ==========================================================
    // DELETE
    // ==========================================================
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBranch(@PathVariable Integer id) {
        branchService.delete(id);
        return ResponseEntity.noContent().build();
    }

}