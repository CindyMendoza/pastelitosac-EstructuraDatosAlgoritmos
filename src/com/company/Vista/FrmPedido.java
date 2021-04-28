package com.company.Vista;

import com.company.Clases.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmPedido {


    //public static JTextField txtCliente;
    private JPanel PanlPedido;
    private JButton txtBuscar;
    private JComboBox cmbProducto;
    private JTextField txtPrecio;
    private JTextField txtCantidad;
    private JTextField txtPrecioTotal;
    private JButton registrarButton;
    private JButton limpiarButton;
    private JButton button3;
    private JTable table1;
    private JCheckBox checkBox1;


    private JTextField txtCliente;
    //public static JLabel demo;

    public static String cliente;
    double precioTotal, precioUni, resultado;
    int cantidad;

    public JPanel getRootPanel() {
        return PanlPedido;
    }

    public FrmPedido(){
        cliente= txtCliente.getText();


        //precioUni = Double.parseDouble(txtPrecio.getText());
        //precioTotal = Double.parseDouble(txtPrecioTotal.getText());
        //cantidad = Integer.parseInt(txtCantidad.getText());
        //Producto = cmbProducto.getSelectedItem().toString();


        cmbProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                switch (cmbProducto.getSelectedItem().toString()){
                    case "Seleccione:":
                        txtPrecio.setText("");
                        break;
                    case "Cheesecake":
                        precioUni=10;
                        txtPrecio.setText(String.valueOf(precioUni));
                        break;
                    case "Tiramisú":
                        precioUni=12;
                        txtPrecio.setText(String.valueOf(precioUni));
                        break;
                    case "Tres Leches":
                        precioUni=11;
                        txtPrecio.setText(String.valueOf(precioUni));
                        break;

                    case "Tarta de Santiago":
                        precioUni=14;
                        txtPrecio.setText(String.valueOf(precioUni));
                        break;
                    case "Ópera":
                        precioUni=13.40;
                        txtPrecio.setText(String.valueOf(precioUni));
                        break;
                }

            }
        });
        txtCantidad.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {

                precioUni = Double.parseDouble(txtPrecio.getText());
                precioTotal = Double.parseDouble(txtPrecioTotal.getText());
                cantidad = Integer.parseInt(txtCantidad.getText());

                precioTotal= precioUni*cantidad;

                txtPrecioTotal.setText(String.valueOf(precioTotal));


            }
        });
    }


}
