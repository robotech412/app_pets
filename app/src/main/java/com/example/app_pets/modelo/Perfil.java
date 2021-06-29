package com.example.app_pets.modelo;

public class Perfil {
    private String Nombres;
    private String Apellidos;
    private String Sexo;
    private String Telefono;

    public Perfil() {
    }

    public Perfil(String Nombres, String Apellidos, String Sexo, String Telefono) {
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Sexo = Sexo;
        this.Telefono = Telefono;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String telefono) {
        Telefono = telefono;
    }
}
