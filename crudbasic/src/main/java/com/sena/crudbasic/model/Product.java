package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;
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
@Table(name="product")
public class Product {

    //Anotación bean para id de la entidad
    @Id
    //Anotación para autoincremental1
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Indicar que el campo es una columna
    @Column(name="id_product")
    private int id;
    @Column(name="name", length = 50)
    private String name;

    //Un producto aparece en muchos detalles de venta
    @OneToMany(mappedBy= "product")
    private List<SaleDetail> saleDetails;

    //Un producto puede aparecer en muchos detalles compra
    @OneToMany(mappedBy= "product")
    private List<DetailBuyProvider> detailBuyProviders;

    @ManyToOne
    @JoinColumn(name = "id_category")
    private Category category;
    
    @ManyToOne
    @JoinColumn(name = "id_provider")
    private Provider provider;
}