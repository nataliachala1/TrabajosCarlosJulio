package com.sena.crudbasic.model;

import java.util.List;

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


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "employee")
public class Employee {

     //Anotación bean para ide de la entidad
    @Id
    //Anotación para autoincremental1
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Indicar que el campo es una columna
    @Column(name="id_employee")
    private int id;
    @Column(name="name", length = 50)
    private String name;
    @Column(name="lastName", length = 60)
    private String lastName;

    //Un empleado registra muchas ventas
    @OneToMany(mappedBy= "employee")
    private List<Sale> sales;

    //Un empleado registra muchas compras
    @OneToMany(mappedBy = "employee")    
    private List<BuyProvider> buyProviders;

    @ManyToOne
    @JoinColumn(name = "id_branch")
    private Branch branch;
}

