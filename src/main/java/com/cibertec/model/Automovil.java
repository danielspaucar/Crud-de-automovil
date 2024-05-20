package com.cibertec.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name="tb_automovil")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Automovil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column (nullable = false)
    private int anioFabricacion;

    @Column(length = 60, nullable = false)
    private double cilindrada;

    @Column(nullable = false)
    private int numPuertas;

    @Column(nullable = false)
    private double precio;

    @Column(length = 100, nullable = false)
    private String color;

    @Column(length = 100, nullable = false)
    private  String marca;

    @Column(length = 100, nullable = false)
    private String motor;
}
