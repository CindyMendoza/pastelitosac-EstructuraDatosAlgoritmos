package com.company.Vista;

import com.company.Clases.Cliente;
import com.company.JSON.ReadJSON;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FrmListaCliente {
    private JPanel
            PanelListaCliente;
    private JTextField
            txtBuscarCliente;
    private JButton
            buscarButton;
    public JTable
            TbListaCliente;
    private JButton
            BtnSeleccion;

    //Manejar datos de JSON y listado de clientes
    ArrayList<Cliente> clientes = new ArrayList<>();
    ReadJSON readJSON = new ReadJSON();

    DefaultTableModel
            tbmodel = (DefaultTableModel) TbListaCliente.getModel();
    TableRowSorter<DefaultTableModel> tr;

    public JPanel getRootPanel() {
        return PanelListaCliente;
    }

public FrmListaCliente(){

    listar();

    buscarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            Buscar();
        }
    });

    BtnSeleccion.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            FrmPedido ui = new FrmPedido();
            JPanel jp = ui.getRootPanel();
            JFrame frame = new JFrame();
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setContentPane(jp);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);

            int i = TbListaCliente.getSelectedRow();

            ui.txtCliente.setText(TbListaCliente.getValueAt(i,0).toString());
        }
    });
}

    public void Buscar(){

        try {
            tr.setRowFilter(RowFilter.regexFilter(txtBuscarCliente.getText()));
        } catch (Exception e) {
            JOptionPane.showMessageDialog( null, "Error al Buscar");
        }
    }

    public void listar(){
        Object[] column = {"Nombre completo", "DNI", "Celular","Correo","Dirección"};
        Object[] row = new Object[0];
        tbmodel.setColumnIdentifiers(column);
        TbListaCliente.setModel(tbmodel);
        TbListaCliente.setAutoCreateRowSorter(true);
        tr = new TableRowSorter<>(tbmodel);
        TbListaCliente.setRowSorter(tr);

        //Obtener clientes desde JSON
        clientes = readJSON.getClientes(clientes);

        //Agregar todos los clientes
        for(Cliente c: clientes){
            System.out.println(c.getCorreo());
            final Object[] tbRow = c.getObjetRow();
            tbmodel.addRow(tbRow);
        }
    }
}

