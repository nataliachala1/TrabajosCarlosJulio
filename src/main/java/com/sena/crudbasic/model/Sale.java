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
@Table(name="sale")
public class Sale {

    //Anotación bean para ide de la entidad
    @Id
    //Anotación para autoincremental1
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Indicar que el campo es una columna
    @Column(name="id_sale")
    private int id;
    @Column(name="name", length = 50)
    private String name;

    //Una venta tiene muchos detalles venta
    @OneToMany(mappedBy = "sale")
    private List<SaleDetail> saleDetails;

    @ManyToOne
    @JoinColumn(name = "id_customer")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "id_employee")
    private Employee employee;
}
