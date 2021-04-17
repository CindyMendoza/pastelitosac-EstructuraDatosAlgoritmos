package com.company.Vista;

import com.company.Clases.Personal;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FrmRegistrarEmpleados {
    private JPanel panelPrincipal;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtFecha;
    private JTextField txtDireccion;
    private JTextField txtCorreo;
    private JButton btnEditar;
    private JButton btnGuardar;
    private JTable TbEmpleado;
    private JButton bntEliminar;
    private JButton button1;
    private JTextField txtBuscar;
    private JButton btnBuscar;
    ArrayList<Personal> lista = new ArrayList<Personal>();
    DefaultTableModel tbmodel = (DefaultTableModel) TbEmpleado.getModel();
    TableRowSorter<TableModel> tr;

    public JPanel getRootPanel() {
        return panelPrincipal;
    }

    public FrmRegistrarEmpleados(){
        listar();

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Personal per= new Personal(txtNombre.getText(),txtApellido.getText(),txtFecha.getText(), txtDireccion.getText(), txtCorreo.getText());
                if (per.equals(null)){
                    JOptionPane.showMessageDialog( null, "Error registrar");
                }else {
                    JOptionPane.showMessageDialog( null, "Se registro correctamente");
                }
                lista.add(per);
                listar();
                Limpiar();
            }
        });

        btnEditar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editar();

            }
        });

        //TbEmpleado.addMouseListener(new MouseEvent());

        DefaultTableModel model = (DefaultTableModel) TbEmpleado.getModel();

        TbEmpleado.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                int i = TbEmpleado.getSelectedRow();
                txtNombre.setText(TbEmpleado.getValueAt(i,0).toString());
                txtApellido.setText(TbEmpleado.getValueAt(i,1).toString());
                txtDireccion.setText(TbEmpleado.getValueAt(i,2).toString());
                txtCorreo.setText(TbEmpleado.getValueAt(i,3).toString());
                txtFecha.setText(TbEmpleado.getValueAt(i,4).toString());
            }
        });

        bntEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                if (TbEmpleado.getSelectedColumn()>=0){
                    tbmodel.removeRow(TbEmpleado.getSelectedRow());
                    JOptionPane.showMessageDialog( null, "Se elimino correctamente");
                }else {
                    JOptionPane.showMessageDialog( null, "Error al eliminar");
                }
            }
        });



        txtBuscar.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                //JOptionPane.showMessageDialog( null, "Demo");
                tr.setRowFilter(RowFilter.regexFilter(txtBuscar.getText()));
            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Buscar();
            }
        });
    }

    public void Limpiar(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtCorreo.setText("");
        txtFecha.setText("");

        txtNombre.requestFocus();
    }

    public void listar(){
        String matris [][] = new String[lista.size()][5];

        for (int i=0; i<lista.size(); i++){
            matris[i][0]=lista.get(i).getNombres();
            matris[i][1]=lista.get(i).getApellidos();
            matris[i][2]=lista.get(i).getFechaNacimiento();
            matris[i][3]=lista.get(i).getDireccion();
            matris[i][4]=lista.get(i).getCorreo();
        }

        TbEmpleado.setModel(new DefaultTableModel(
                matris,
                new String []{"Nombre","Apellido","Dirección","Correo","Fecha de Nacimiento"}
        ));
    }

    public void editar(){

        String Nombre, Apellido, Direccion, Correo, Fecha;

        if (TbEmpleado.getSelectedColumn() >=0){

            Nombre= txtNombre.getText();
            Apellido= txtApellido.getText();
            Direccion=txtDireccion.getText();
            Correo=txtCorreo.getText();
            Fecha=txtFecha.getText();

            TbEmpleado.setValueAt(Nombre, TbEmpleado.getSelectedRow(),0);
            TbEmpleado.setValueAt(Apellido, TbEmpleado.getSelectedRow(),1);
            TbEmpleado.setValueAt(Direccion, TbEmpleado.getSelectedRow(),2);
            TbEmpleado.setValueAt(Correo, TbEmpleado.getSelectedRow(),3);
            TbEmpleado.setValueAt(Fecha, TbEmpleado.getSelectedRow(),4);

            JOptionPane.showMessageDialog( null, "Se Actulizo correctamente");
        }else {
            JOptionPane.showMessageDialog( null, "Error al Actulizar");
        }
        Limpiar();



    }
    public void Buscar(){
        String filtro=txtBuscar.getText();
        if(!filtro.equals("")){
            tr.setRowFilter(RowFilter.regexFilter(filtro));
        }else{
            tr.setRowFilter(null);
        }

    }

}
