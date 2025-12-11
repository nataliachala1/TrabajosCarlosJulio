package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="provider")
public class Provider {

    //Anotación bean para ide de la entidad
    @Id
    //Anotación para autoincremental1
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Indicar que el campo es una columna
    @Column(name="id_provider")
    private int id;
    @Column(name="name", length = 50)
    private String name;

    //Un proveedor tiene muchos productos
    @OneToMany(mappedBy= "provider")
    private List<Product> products;

    //Un proveedor puede tener muchas compras
    @OneToMany(mappedBy= "provider")
    private List<BuyProvider> buyProviders;

}