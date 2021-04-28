package com.company.Vista;

import com.company.Clases.Empleados;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Calendar;

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
    private JTextField txtBuscar;
    private JButton btnBuscar;
    ArrayList<Empleados> lista = new ArrayList<Empleados>();
    DefaultTableModel tbmodel = (DefaultTableModel) TbEmpleado.getModel();
    TableRowSorter<DefaultTableModel> tr;

    String Nombre, Apellido, Direccion, Correo, Fecha;

    public JPanel getRootPanel() {
        return panelPrincipal;
    }

    public FrmRegistrarEmpleados(){

        listar();


        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {



                if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty()|| txtDireccion.getText().isEmpty()|| txtCorreo.getText().isEmpty()|| txtFecha.getText().isEmpty()){
                    JOptionPane.showMessageDialog( null, "Los campos deden estar llenos");
                }
                else{
                    final Object[] row = new Object[5];
                    row[0] = txtNombre.getText();
                    row[1] = txtApellido.getText();
                    row[2] = txtDireccion.getText();
                    row[3] = txtCorreo.getText();
                    row[4] = txtFecha.getText();

                    //obj.setNombres((String) row[0]);

                    tbmodel.addRow(row);

                    Limpiar();
                    JOptionPane.showMessageDialog( null, "Se registro correctamente");

                }
                //Arreglo


                //fila[5]=txtCorreo.getSelectedItem().toString();

                //String dato[] = {txtNombre.getText(),txtApellido.getText(),txtDireccion.getText(),txtCorreo.getText(),txtFecha.getText()};

                //tbmodel.addRow(dato);

                //TbEmpleado.setModel(tbmodel);



                /*
                Empleados obj = new Empleados();

                txtNombre.setText(obj.getNombres());
                Apellido= txtApellido.getText();
                Direccion= txtDireccion.getText();
                Correo= txtCorreo.getText();
                Fecha= txtFecha.getText();

                //new Personal[]{obj}
                Personal obj = new Personal();
                        //{obj.setNombres(Nombre),obj.setApellidos(Apellido),obj.setDireccion(Direccion),obj.setCorreo(Correo),obj.setFechaNacimiento(Fecha)}

                obj.setNombres(Nombre);
                obj.setApellidos(Apellido);
                obj.setDireccion(Direccion);
                obj.setCorreo(Correo);
                obj.setFechaNacimiento(Fecha);

                if (obj.getNombres().isEmpty() || obj.getApellidos().isEmpty()|| obj.getDireccion().isEmpty()|| obj.getCorreo().isEmpty()|| obj.getFechaNacimiento().isEmpty()){
                    JOptionPane.showMessageDialog( null, "Los campos deden estar llenos");
                }
                else if (obj.equals(null)){
                    JOptionPane.showMessageDialog( null, "Error registrar");
                }else{
                    JOptionPane.showMessageDialog( null, "Se registro correctamente");
                    lista.add(obj);
                    //tbmodel.addRow();
                    listar();
                    Limpiar();
                }*/

                //listar();

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
                int dto = TbEmpleado.getSelectedRow();
                if (dto>=0){
                    tbmodel.removeRow(dto);
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
                //tr.setRowFilter(RowFilter.regexFilter(txtBuscar.getText(),1));
                //tr= new TableRowSorter<>(tbmodel);
                //TbEmpleado.setRowSorter(tr);

            }
        });
        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Buscar();
            }
        });
        txtFecha.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Calendar cal = Calendar.getInstance();
                JDateChooser date = new JDateChooser(cal.getTime());
                date.setDateFormatString("dd/MM/yyyy");
                txtFecha.add(date);
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

    public void registrar(){

    }

    public void listar(){

        Object[] column = {"Nombre","Apellido","Dirección","Correo","FechaNacimiento"};
        Object[] row =new Object[0];
        tbmodel.setColumnIdentifiers(column);
        TbEmpleado.setModel(tbmodel);
        TbEmpleado.setAutoCreateRowSorter(true);
        tr = new  TableRowSorter<>(tbmodel);
        TbEmpleado.setRowSorter(tr);
        /*String matris [][] = new String[lista.size()][5];

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
        ));*/
    }

    public void editar(){

        int dto = TbEmpleado.getSelectedRow();

        if ( dto >=0){

            TbEmpleado.setValueAt(txtNombre.getText(), dto,0);
            TbEmpleado.setValueAt(txtApellido.getText(), dto,1);
            TbEmpleado.setValueAt(txtDireccion.getText(), dto,2);
            TbEmpleado.setValueAt(txtCorreo.getText(), dto,3);
            TbEmpleado.setValueAt(txtFecha.getText(), dto,4);

            JOptionPane.showMessageDialog( null, "Se Actulizo correctamente");

        }else {
            JOptionPane.showMessageDialog( null, "Error al Actulizar");
        }

    }
    public void Buscar(){

        try {
            tr.setRowFilter(RowFilter.regexFilter(txtBuscar.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, "Error al Buscar");
        }

    }


}
