package com.company.Clases;

import java.util.ArrayList;
import java.util.Collections;

public class Metricas {

    public static double promedioPedidos(ArrayList<Pedido> pedidos, int cantidad) {
        double suma = 0.0;
        double promedio = 0.0;

        for (Pedido p: pedidos){
            suma = suma + p.getTotal();
        }

        promedio = suma / cantidad;

        return promedio;
    }

    public static double sumaMontoTotalPedidos(ArrayList<Pedido> pedidos, int posicion, double promedio){
        if (posicion >= pedidos.size()) return 0;

        return pedidos.get(posicion).getTotal()+sumaMontoTotalPedidos(pedidos, posicion+1, promedio);
    }

    public static ArrayList<ProductoMasDemandado> productosMasDemandados(ArrayList<Pedido> pedidos){
        ArrayList<String> productos = new ArrayList<>();
        ArrayList<ProductoMasDemandado> productosMasDemandados = new ArrayList<>();

        for(Pedido p: pedidos){
            productos.add(p.getNombreProducto());
        }

        for(Object nombreProducto: productos){
            int ocurrencias = Collections.frequency(productos, nombreProducto);

            ProductoMasDemandado productoMasDemandado = new ProductoMasDemandado(
                    ocurrencias,
                    nombreProducto.toString());

            productosMasDemandados.add(productoMasDemandado);
        }

        productosMasDemandados = ordenarDescendente(productosMasDemandados);

        return productosMasDemandados;
    }

    public static ArrayList<ProductoMasDemandado> ordenarDescendente(ArrayList<ProductoMasDemandado> productoMasDemandados){
    //ordenamiento burbuja
        for(int i = 0; i< productoMasDemandados.size(); i++){
            for (int j = productoMasDemandados.size()-1; j > i; j--){
                if(productoMasDemandados.get(i).ocurrencias < productoMasDemandados.get(j).ocurrencias){

                    ProductoMasDemandado temporal = productoMasDemandados.get(i);
                    productoMasDemandados.set(i, productoMasDemandados.get(j));
                    productoMasDemandados.set(j, temporal);
                }
            }
        }

        return productoMasDemandados;
    }

    public static void main(String[] args) {

    }
}
