package com.example.BBVA2.DoMain;

public class Empleado2 {
    private final int id;
    private final String nombre;
    private final double salary;

    public Empleado2(int id, String nombre, double salary) {
        this.id = id;
        this.nombre = nombre;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }


    public String getNombre() {
        return nombre;
    }


    public double getSalary() {
        return salary;
    }


}