package com.company.Vista;

//Librería

import com.company.Clases.Cliente;
import com.company.JSON.ReadJSON;
import com.company.Main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FrmRegistrarCliente {
    //Panel
    private JPanel panelPrincipal;
    //Campos de texto
    private JTextField txtNombre;
    private JTextField txtDNI;
    private JTextField txtCelular;
    private JTextField txtDireccion;
    private JTextField txtCorreo;
    private JTextField txtBuscar;
    //Tabla
    private JTable TbCliente;
    //Botones
    private JButton btnActualizar;
    private JButton btnGuardar;
    private JButton btnEliminar;
    private JButton btnBuscar;
    private JButton btnCrearPedido;
    private JButton btnBorrarCampos;
    private JFrame frame = new JFrame();

    //Manejar datos de JSON y listado de clientes
    ArrayList<Cliente> clientes = new ArrayList<>();
    ReadJSON readJSON = new ReadJSON();

    DefaultTableModel tbmodel = (DefaultTableModel) TbCliente.getModel();
    TableRowSorter<DefaultTableModel> tr;

    public JPanel getRootPanel() {
        return panelPrincipal;
    }

    public FrmRegistrarCliente(){

        listar();

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Crear nuevo objeto cliente y añadirlo al arrayList
                Cliente cliente = new Cliente(
                        txtDNI.getText(),
                        txtNombre.getText(),
                        txtCelular.getText(),
                        txtCorreo.getText(),
                        txtDireccion.getText());

                clientes.add(cliente);

                if (txtNombre.getText().equals("")||txtDNI.getText().equals("") || txtCelular.getText().equals("") || txtCorreo.getText().equals("") || txtDireccion.getText().equals("")){
                    JOptionPane.showMessageDialog( null, "Debe llenar los datos solicitados");
                }
                else {
                    //Delete Rows
                    int rowCount = tbmodel.getRowCount();

                    //Remover filas una a una
                    for(int i = rowCount-1; i>=0; i--){
                        tbmodel.removeRow(i);
                    }

                    //Agregar todos los pedidos ordenados
                    for(Cliente c: clientes){
                        final Object[] tbRow = c.getObjetRow();
                        tbmodel.addRow(tbRow);
                    }

                    JOptionPane.showMessageDialog( null, "Registro exitoso!");
                    BorrarCampos();
                }
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actualizar();
            }
        });

        DefaultTableModel model = (DefaultTableModel) TbCliente.getModel();

        TbCliente.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                int i = TbCliente.getSelectedRow();
                txtNombre.setText(TbCliente.getValueAt(i,0).toString());
                txtDNI.setText(TbCliente.getValueAt(i,1).toString());
                txtCelular.setText(TbCliente.getValueAt(i,2).toString());
                txtCorreo.setText(TbCliente.getValueAt(i,3).toString());
                txtDireccion.setText(TbCliente.getValueAt(i,4).toString());
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dto = TbCliente.getSelectedRow();

                if (dto>=0){
                    clientes.remove(dto);
                    tbmodel.removeRow(dto);
                    JOptionPane.showMessageDialog( null, "Se elimino correctamente"+ dto);
                }else {
                    JOptionPane.showMessageDialog( null, "Error al eliminar");
                }
            }
        });

        btnBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Buscar();
            }
        });

        btnCrearPedido.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(clientes.isEmpty()){
                    clientes = readJSON.getClientes(clientes);
                }

                FrmPedido frmPedido = new FrmPedido(clientes);
                frmPedido.load();

                int i = TbCliente.getSelectedRow();
                System.out.println(TbCliente.getModel());
                System.out.println("indice"+i);
                frmPedido.txtCliente.setText(TbCliente.getValueAt(i,0).toString());
            }
        });

        btnBorrarCampos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BorrarCampos();
            }
        });
    }

    public void load () {
        frame.add(panelPrincipal);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setUndecorated(false);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setSize(750, 600);

        frame.setIconImage(new ImageIcon(Main.class.getResource("/img/cake.png")).getImage());
        frame.setTitle("Pastelitos");
    }

    public void dispose(){
        frame.dispose();
    }

    public void BorrarCampos(){
        txtBuscar.setText((""));
        txtNombre.setText("");
        txtDNI.setText("");
        txtDireccion.setText("");
        txtCorreo.setText("");
        txtCelular.setText("");

        txtNombre.requestFocus();
    }

    public void listar(){
        Object[] column = {"Nombre completo","DNI","Celular","Correo","Dirección"};
        tbmodel.setColumnIdentifiers(column);
        TbCliente.setModel(tbmodel);
        TbCliente.setAutoCreateRowSorter(true);
        tr = new  TableRowSorter<>(tbmodel);
        TbCliente.setRowSorter(tr);

        //Obtener clientes desde JSON
        clientes = readJSON.getClientes(clientes);

        //Agregar todos los clientes
        for(Cliente c: clientes){
            final Object[] tbRow = c.getObjetRow();
            tbmodel.addRow(tbRow);
        }

        //Estilos tabla clientes
        TbCliente.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        TbCliente.getTableHeader().setOpaque(false);
        TbCliente.getTableHeader().setBackground(new Color(78,145,140));
        TbCliente.setRowHeight(25);
    }

    public void actualizar(){

        int dto = TbCliente.getSelectedRow();

        if ( dto >=0){

            TbCliente.setValueAt(txtNombre.getText(), dto,0);
            TbCliente.setValueAt(txtDNI.getText(), dto,1);
            TbCliente.setValueAt(txtCelular.getText(), dto,2);
            TbCliente.setValueAt(txtCorreo.getText(), dto,3);
            TbCliente.setValueAt(txtDireccion.getText(), dto,4);

            JOptionPane.showMessageDialog( null, "Se Actualizó correctamente");

        } else {
            JOptionPane.showMessageDialog( null, "Error al Actualizar");
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
