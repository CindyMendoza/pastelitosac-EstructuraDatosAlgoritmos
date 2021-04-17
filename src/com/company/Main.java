package com.company;

import com.company.Vista.FrmRegistrarEmpleados;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                Vist();
            }
        });

    }

    public static void Vist(){
        //FrmRegistrar ui = new FrmRegistrar();
        //JPanel jp = ui.getRootPanel();
        //JFrame frame = new JFrame();
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setContentPane(jp);
        //frame.pack();
        //frame.setLocationRelativeTo(null);
       // frame.setVisible(true);

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
