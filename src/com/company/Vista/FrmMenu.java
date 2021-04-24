package com.company.Vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmMenu {
    private JPanel PanelMenu;
    private JButton registroButton;

    public JPanel getRootPanel() {

        return PanelMenu;
    }

    public FrmMenu() {
        registroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmRegistrarEmpleados ui = new FrmRegistrarEmpleados();
                JPanel jp = ui.getRootPanel();
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(jp);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }


}
