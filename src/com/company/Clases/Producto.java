package com.company.Clases;

public class Producto {
    String nombreProducto;
    double precioUnitario;
    int stock;

    public Object[] getObjetRow(){
        final Object[] row = new Object[6];

        row[0] = nombreProducto;
        row[1] = String.valueOf(precioUnitario);
        row[2] = String.valueOf(stock);

        return row;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        nombreProducto = nombreProducto;
    }

    public double getPrecioUni() {
        return precioUnitario;
    }

    public void setPrecioUni(double precioUni) {
        precioUnitario = precioUni;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Producto(String nombreProducto, double precioUni, int stock) {
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUni;
        this.stock = stock;
    }
}
