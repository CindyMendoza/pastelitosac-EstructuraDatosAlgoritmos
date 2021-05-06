package com.company.Clases;

public class ProductoMasDemandado {
    public int ocurrencias;
    public String nombreProducto;

    ProductoMasDemandado(int ocurrencias, String nombreProducto) {
        this.ocurrencias = ocurrencias;
        this.nombreProducto = nombreProducto;
    }

    public int getOcurrencias() {
        return ocurrencias;
    }

    public void setOcurrencias(int ocurrencias) {
        this.ocurrencias = ocurrencias;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }
}
