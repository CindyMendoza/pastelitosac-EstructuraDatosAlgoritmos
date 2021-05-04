package com.company;

import com.company.Vista.FrmListaCliente;
import com.company.Vista.FrmLogin;
import com.company.Vista.FrmPedido;
import com.company.Vista.FrmRegistrarCliente;

import javax.swing.*;

public class Main {


    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                //Login();
                //ListaCliente();
                //Pedido();
                Registrar();
            }
        });
    }


    public static void Login () {
        FrmLogin ui = new FrmLogin();
        JPanel jp = ui.getRootPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(jp);
        frame.setUndecorated(true);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public static void Registrar () {
        FrmRegistrarCliente ui = new FrmRegistrarCliente();
        JPanel jp = ui.getRootPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(jp);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(600, 550);

        frame.setIconImage(new ImageIcon(Main.class.getResource("/img/cake.png")).getImage());
        frame.setTitle("Pastelitos");
    }

    public static void Pedido () {

        FrmPedido ui = new FrmPedido();
        JPanel jp = ui.getRootPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(jp);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(600,550);

        frame.setIconImage(new ImageIcon(Main.class.getResource("/img/cake.png")).getImage());
        frame.setTitle("Pastelitos");
    }

    public static void ListaCliente () {

        FrmListaCliente ui = new FrmListaCliente();
        JPanel jp = ui.getRootPanel();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setContentPane(jp);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}