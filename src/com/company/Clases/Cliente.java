package com.company.Clases;

public class Cliente {

    String idClinete, Nombres, telefono, correo, direccion;

    public String getIdClinete() {
        return idClinete;
    }

    public void setIdClinete(String idClinete) {
        this.idClinete = idClinete;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Cliente(String idClinete, String nombres, String telefono, String correo, String direccion) {
        this.idClinete = idClinete;
        Nombres = nombres;
        this.telefono = telefono;
        this.correo = correo;
        this.direccion = direccion;
    }
}
