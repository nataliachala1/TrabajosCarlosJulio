package com.sena.crudbasic.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name="branch")
public class Branch {

    //Anotación bean para ide de la entidad
    @Id
    //Anotación para autoincremental1
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //Indicar que el campo es una columna
    @Column(name="id_branch")
    private Integer id;
    @Column(name="name", length = 90)
    private String name;
    @Column(name="address", length = 90)
    private String address;

    //Una sucursal tiene muchos empleados
    @OneToMany(mappedBy = "branch")
    private List<Employee> employees;

    //Una sucursal tiene muchos registros de inventario
    @OneToMany(mappedBy = "branch")
    private List<Inventory> inventories;

}
