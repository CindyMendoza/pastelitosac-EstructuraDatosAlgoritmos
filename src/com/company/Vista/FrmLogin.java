package com.company.Vista;

import com.company.Clases.Usuario;
import com.company.Main;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmLogin {
    private JPanel PanelLogin;
    private JLabel label;
    private JTextField txtUsuario;
    private JPasswordField txtPass;
    private JButton BtnIngresar;
    private JButton btnCancelar;
    private JPanel JFont;
    private JFrame frame = new JFrame();

    public JPanel getRootPanel() {
        return PanelLogin;
    }

    public FrmLogin(){
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        BtnIngresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String Usuario, Pass;

                Usuario= txtUsuario.getText();
                Pass= txtPass.getText();

                Usuario obj = new Usuario();

                obj.setUsuario(Usuario);
                obj.setPassword(Pass);

                if (obj.getUsuario().isEmpty() || obj.getPassword().isEmpty()){
                    JOptionPane.showMessageDialog( null, "Los campos deben estar llenos");
                }
                else if(obj.getUsuario().equals("karen") && obj.getPassword().equals("123"))
                {
                    JOptionPane.showMessageDialog( null, "Bienvenida karen que tengas un excelente dia");

                    Registrar();
                    dispose();
                } else {
                    JOptionPane.showMessageDialog( null, "Usuario y contraseña incorrecta");
                }
            }
        });
    }

    public void load () {
        frame.add(PanelLogin);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setUndecorated(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
    }

    public void dispose(){
        frame.dispose();
    }

    public void Registrar () {
        FrmRegistrarCliente frmRegistrarCliente = new FrmRegistrarCliente();
        frmRegistrarCliente.load();
    }
}
