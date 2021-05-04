package com.company.Clases;

public class Pedido {

    public String nombreCliente,
    nombreProducto,
    idPedido, idCliente;

    public Double precioUnitario,
            total;

    public int cantidad;

    public Boolean pedidoExpress;

    public Pedido(String nombreCliente,
                  String nombreProducto,
                  Double precioUnitario,
                  int cantidad,
                  Double total,
                  String idPedido,
                  String idCliente,
                  Boolean pedidoExpress) {

        this.nombreCliente = nombreCliente;
        this.nombreProducto = nombreProducto;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
        this.total = total;
        this.idPedido = idPedido;
        this.idCliente = idCliente;
        this.pedidoExpress = pedidoExpress;
    }

    public Object[] getObjetRow(){
        final Object[] row = new Object[6];

        row[0] = nombreCliente;
        row[1] = nombreProducto;
        row[2] = precioUnitario.toString();
        row[3] = String.valueOf(cantidad);
        row[4] = total.toString();

        if(pedidoExpress){
            row[5] = "Si";
        } else {
            row[5] = "No";
        }

        return row;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(String idPedido) {
        this.idPedido = idPedido;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getPedidoExpress() {
        return pedidoExpress;
    }

    public void setPedidoExpress(Boolean pedidoExpress) {
        this.pedidoExpress = pedidoExpress;
    }
}
