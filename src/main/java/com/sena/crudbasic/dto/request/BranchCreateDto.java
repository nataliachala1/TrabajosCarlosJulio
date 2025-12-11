package com.sena.crudbasic.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class BranchCreateDto {

      // @NotNull        // No puede ser null
    //@NotBlank       // No puede ser null, vacío o solo espacios (String)
    //@NotEmpty       // No puede ser null o vacío (Strings, Collections)
    //@Size(min=, max=)  // Tamaño mínimo/máximo
    //@Min(value)     // Valor mínimo (números)
    //@Max(value)     // Valor máximo (números)
    //@Email          // Debe ser email válido
    //@Pattern(regexp="")  // Debe coincidir con expresión regular
    //@Past           // Fecha en el pasado
    //@Future         // Fecha en el futuro
    //@Positive       // Número positivo
    //@PositiveOrZero // Número positivo o cero
    //@DecimalMin     // Valor decimal mínimo
    //@DecimalMax     // Valor decimal máximo
        
    
    @NotBlank(message = "El nombre no puede estar vacío")
    @Size(max = 90, message = "El nombre no puede tener más de 90 caracteres")
    private String name;

    @NotBlank(message = "La dirección no puede estar vacía")
    @Size(max = 90, message = "La dirección no puede tener más de 90 caracteres")
    private String address;
}