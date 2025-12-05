package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

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
@Entity
@Table(name="detailBuyProvider")
public class DetailBuyProvider {

    //Anotación bean para id de la entidad
    @Id
    //Anotación para autoincremental1
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Indicar que el campo es una columna
    @Column(name="id_detailBuyProvider")
    private int id;
    @Column(name="name", length = 50)
    private String name;

    //Un proveedor puede tener muchas compras
    @ManyToOne
    @JoinColumn(name = "id_buyProvider")
    private BuyProvider buyProvider;

    //Un producto puede aparecer en muchos detalles compra
    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product product;

}