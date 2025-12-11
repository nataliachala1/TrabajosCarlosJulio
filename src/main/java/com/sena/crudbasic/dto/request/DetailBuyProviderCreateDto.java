package com.sena.crudbasic.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DetailBuyProviderCreateDto {

    @NotBlank(message = "El nombre es obligatorio")
    private String name;

    @NotNull(message = "El ID de la compra a proveedor es obligatorio")
    private Integer buyProviderId;

    @NotNull(message = "El ID del producto es obligatorio")
    private Integer productId;
}
