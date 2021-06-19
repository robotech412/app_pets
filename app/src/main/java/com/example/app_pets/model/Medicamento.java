package com.example.app_pets.model;

public class Medicamento {

    private String Marca;
    private String Nombre;
    private String Cantidad;
    private String Uso;
    private String Descripcion;

    public Medicamento(){

    }

    public Medicamento(String Marca, String Nombre, String Cantidad, String Uso, String Descripcion) {
        this.Marca = Marca;
        this.Nombre = Nombre;
        this.Cantidad = Cantidad;
        this.Uso = Uso;
        this.Descripcion = Descripcion;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getCantidad() {
        return Cantidad;
    }

    public void setCantidad(String cantidad) {
        Cantidad = cantidad;
    }

    public String getUso() {
        return Uso;
    }

    public void setUso(String uso) {
        Uso = uso;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }
}
