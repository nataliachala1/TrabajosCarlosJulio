package com.sena.crudbasic.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BuyProviderCreateDto {

     @NotBlank(message = "El nombre es obligatorio")
     private String name;

     @NotNull(message = "El ID del proveedor es obligatorio")
     private Integer providerId;

     @NotNull(message = "El ID del empleado es oblgatorio")
     private Integer employeeId;
}
