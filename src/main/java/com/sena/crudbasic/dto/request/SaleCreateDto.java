package com.sena.crudbasic.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SaleCreateDto {

    @NotBlank(message = "El nombre de la venta es obligatorio")
    private String name;

    @NotNull(message = "El ID del cliente es obligatorio")
    private Integer customerId;

    @NotNull(message = "El ID del empleado es obligatorio")
    private Integer employeeId;
}
