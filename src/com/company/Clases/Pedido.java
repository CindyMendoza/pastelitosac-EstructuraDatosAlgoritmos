package com.company.Clases;

public class Pedido {

    String nombreProduto ;
    Double precioUni;
    Double precioTotal;
    int Cantidad;
    Pedido idPedido;
    Cliente idClinete;
    int delivery;

    public String getNombreProduto() {
        return nombreProduto;
    }

    public void setNombreProduto(String nombreProduto) {
        this.nombreProduto = nombreProduto;
    }

    public Double getPrecioUni() {
        return precioUni;
    }

    public void setPrecioUni(Double precioUni) {
        this.precioUni = precioUni;
    }

    public Double getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(Double precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        Cantidad = cantidad;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public Cliente getIdClinete() {
        return idClinete;
    }

    public void setIdClinete(Cliente idClinete) {
        this.idClinete = idClinete;
    }

    public void setDelivery(int delivery) {
        this.delivery = delivery;
    }

    public Pedido(String nombreProduto, Double precioUni, Double precioTotal, int cantidad, Pedido idPedido, Cliente idClinete, int delivery) {
        this.nombreProduto = nombreProduto;
        this.precioUni = precioUni;
        this.precioTotal = precioTotal;
        Cantidad = cantidad;
        this.idPedido = idPedido;
        this.idClinete = idClinete;
        this.delivery = delivery;
    }
}
