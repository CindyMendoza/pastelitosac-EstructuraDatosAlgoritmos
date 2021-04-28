package com.company;

import com.company.Vista.FrmListClinte;
import com.company.Vista.FrmLogin;
import com.company.Vista.FrmPedido;
import com.company.Vista.FrmRegistrarEmpleados;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Login();

                ListaCliente();
                //Pedido();
               //Registrar();
            }



        });

    }

    public static void Pedido(){

        FrmPedido ui = new FrmPedido();
        JPanel jp = ui.getRootPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(jp);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void ListaCliente(){

        FrmListClinte ui = new FrmListClinte();
        JPanel jp = ui.getRootPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(jp);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static  void Login(){
        FrmLogin ui = new FrmLogin();
        JPanel jp = ui.getRootPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(jp);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void Registrar(){

        FrmRegistrarEmpleados ui = new FrmRegistrarEmpleados();
        JPanel jp = ui.getRootPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(jp);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


}
