package com.company.Clases;

public class Cliente {

    public String idCliente, nombreCompleto, celular, correo, direccion;

    public Cliente(String idCliente, String nombreCompleto, String celular, String correo, String direccion) {
        this.idCliente = idCliente;
        this.nombreCompleto = nombreCompleto;
        this.celular = celular;
        this.correo = correo;
        this.direccion = direccion;
    }

    public Object[] getObjetRow(){
        final Object[] row = new Object[5];

        row[0] = nombreCompleto;
        row[1] = idCliente;
        row[2] = celular;
        row[3] = correo;
        row[4] = direccion;

        return row;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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

}
