package com.sena.crudbasic.dto.response;

import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crudbasic.dto.view.JsonViews;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SaleResponseDto {

    @JsonView(JsonViews.Resumen.class)
    private Integer id;

    @JsonView(JsonViews.Resumen.class)
    private String name;

    @JsonView(JsonViews.Detalle.class)
    private CustomerResponseDto customer;

    @JsonView(JsonViews.Detalle.class)
    private EmployeeResponseDto employee;
}
