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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name="buyProvider")
public class BuyProvider {

    //Anotación bean para id de la entidad
    @Id
    //Anotación para autoincremental1
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Indicar que el campo es una columna
    @Column(name="id_buyProvider")
    private int id;
    @Column(name="name", length = 50)
    private String name;

    //una compraProveedor tiene muchos detalleCompraProveedor
    @OneToMany(mappedBy= "buyProvider")
    private List<DetailBuyProvider> detailBuyProviders;

    //Un proveedor puede tener muchas compras
    @ManyToOne
    @JoinColumn(name = "id_provider")
    private Provider provider;

    //Cada compra es registrada por un empleado
    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;

}
