package com.sena.crudbasic.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryCreateDto {

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @NotNull(message = "El ID de la sucursal es obligatorio")
    private Integer branchId;
}
