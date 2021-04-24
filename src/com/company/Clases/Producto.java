package com.company.Clases;

public class Producto {
    int IdProducto;
    String NombreProducto;
    double PrecioUni;
    int stock;

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int idProducto) {
        IdProducto = idProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        NombreProducto = nombreProducto;
    }

    public double getPrecioUni() {
        return PrecioUni;
    }

    public void setPrecioUni(double precioUni) {
        PrecioUni = precioUni;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Producto(int idProducto, String nombreProducto, double precioUni, int stock) {
        IdProducto = idProducto;
        NombreProducto = nombreProducto;
        PrecioUni = precioUni;
        this.stock = stock;
    }
}
