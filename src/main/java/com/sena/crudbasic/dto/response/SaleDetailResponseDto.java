package com.sena.crudbasic.dto.response;

import com.fasterxml.jackson.annotation.JsonView;
import com.sena.crudbasic.dto.view.JsonViews;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class SaleDetailResponseDto {

    @JsonView(JsonViews.Resumen.class)
    private Integer id;

    @JsonView(JsonViews.Resumen.class)
    private String name;

    @JsonView(JsonViews.Resumen.class)
    private String description;

    @JsonView(JsonViews.Detalle.class)
    private SaleResponseDto sale;

    @JsonView(JsonViews.Detalle.class)
    private ProductResponseDto product;
}
