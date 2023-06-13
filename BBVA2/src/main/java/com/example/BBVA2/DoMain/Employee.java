package com.example.BBVA2.DoMain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private Double sueldo;
    private Rol rol = Rol.USUARIO;

    public Employee(String nombre, Double sueldo, Rol rol) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.rol = rol;
    }

    public Employee(int id, String nombre, double sueldo) {
        this.id = id;
        this.nombre = nombre;
        this.sueldo = sueldo;
    }
}
