package com.sena.crudbasic.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryCreateDto {

    @NotBlank(message = "El nombre de la categoría es obligatorio")
    private String name;
}
