package com.cibertec.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AutomovilCreateDTO {
    private int anioFabricacion;
    private double cilindrada;
    private int numPuertas;
    private double precio;
    private String color;
    private String marca;
    private String motor;
}