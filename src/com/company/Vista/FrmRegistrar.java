package com.company.Vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FrmRegistrar {
    private JTextField txtNombre;
    private JTextField txtApelldios;
    private JTextField txtFechaNacimento;
    private JTextField Direccion;
    private JTextField txtCorreo;
    private JButton guardarButton;
    private JButton cancelarButton;
    private JTable LstEmpleado;
    private JPanel rootPanel;

    //public FrmRegistrar(){
      //  lista();
    //}
    //public JPanel getRootPanel() {
      //  return rootPanel;
    //}


    public void lista(){
        LstEmpleado.setModel(new DefaultTableModel(
                null,
                new String []{"Nombre","Apellido","Dirección","Correo","Fechad de Nacimiento"}
        ));
    }
}
