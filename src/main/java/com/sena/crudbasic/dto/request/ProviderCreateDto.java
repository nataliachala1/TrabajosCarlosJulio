package com.sena.crudbasic.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProviderCreateDto {

    @NotBlank(message = "El nombre es obligatorio")
    private String name;
}
