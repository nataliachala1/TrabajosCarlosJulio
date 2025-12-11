package com.sena.crudbasic.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleDetailCreateDto {

    @NotNull(message = "El nombre es obligatorio")
    private String name;

    @NotNull(message = "La descripción es obligatoria")
    private String description;

    @NotNull(message = "El ID de la venta es obligatorio")
    private Integer saleId;

    @NotNull(message = "El ID del producto es obligatorio")
    private Integer productId;
}
