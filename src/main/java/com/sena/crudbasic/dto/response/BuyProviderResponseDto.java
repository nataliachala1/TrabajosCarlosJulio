package com.sena.crudbasic.dto.response;

import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crudbasic.dto.view.JsonViews;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class BuyProviderResponseDto {

    @JsonView(JsonViews.Resumen.class)
    private Integer id;

    @JsonView(JsonViews.Resumen.class)
    private String name;

    @JsonView(JsonViews.Detalle.class)
    private ProviderResponseDto provider;

    @JsonView(JsonViews.Detalle.class)
    private EmployeeResponseDto employee;
}
