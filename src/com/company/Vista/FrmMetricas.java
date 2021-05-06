package com.company.Vista;

import com.company.Clases.*;
import com.company.JSON.ReadJSON;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class FrmMetricas {
        private JTextField txtPedidos;
        private JTextField txtClientes;
        private JTextField txtPromedio;
        private JTextField txtMontoTotal;
        private JTextField txtMasDemandado;
        private JTextField txtMenosDemandado;
        private JButton btnRegresar;
        private JButton Salir;
        private JPanel panel1;
        private JFrame frame = new JFrame();
        public ArrayList<Pedido> pedidos;
        public ArrayList<Cliente> clientes;

    //Manejar datos de JSON y listado de pedidos
    ReadJSON readJSON = new ReadJSON();

    public JPanel getRootPanel() {
        return panel1;
    }

    public void load() {
        frame.add(panel1);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(630, 300);
        frame.setTitle("Métricas");
        frame.setResizable(false);
    }

    public void dispose(){
        frame.dispose();
    }

    public FrmMetricas(ArrayList<Pedido> pedidos, ArrayList<Cliente> clientes){
        //Popular con métricas
        obtenerMetricas(pedidos, clientes);

        btnRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void obtenerMetricas(ArrayList<Pedido> pedidos, ArrayList<Cliente> clientes){
        Metricas metricas = new Metricas();

        //Cantidad de pedidos
        int cantidadPedidos = pedidos.size();
        int cantidadClientes = clientes.size();

        double promedio = metricas.promedioPedidos(pedidos, cantidadPedidos);
        double sumaMontoTotal = metricas.sumaMontoTotalPedidos(pedidos,0, promedio);
        ArrayList<ProductoMasDemandado> productosMasDemandados = metricas.productosMasDemandados(pedidos);

        int tamañoArregloProductos = productosMasDemandados.size();

        txtClientes.setText(String.valueOf(cantidadClientes));
        txtPedidos.setText(String.valueOf(cantidadPedidos));
        txtPromedio.setText(Double.toString(promedio));
        txtMontoTotal.setText(Double.toString(sumaMontoTotal));
        txtMasDemandado.setText(productosMasDemandados.get(0).nombreProducto);
        txtMenosDemandado.setText(productosMasDemandados.get(tamañoArregloProductos-1).nombreProducto);
    }
}
