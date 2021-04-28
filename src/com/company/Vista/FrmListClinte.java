package com.company.Vista;

import com.company.Clases.Cliente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmListClinte extends FrmPedido {
    private JPanel PanelListaCliente;
    private JTextField txtBuscarCliente;
    private JButton buscarButton;
    private JTable TbListaCliente;
    private JButton BtnSeleccion;


    DefaultTableModel tbmodel = (DefaultTableModel) TbListaCliente.getModel();
    TableRowSorter<DefaultTableModel> tr;

    public JPanel getRootPanel() {
        return PanelListaCliente;
    }

    public FrmListClinte(){

        listar();

        BtnSeleccion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                FrmPedido ui = new FrmPedido();
                JPanel jp = ui.getRootPanel();
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(jp);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                //String nombre = String.valueOf(tbmodel.getValueAt(TbListaCliente.getSelectedRow(),1));

                //FrmPedido.txtCliente.setText(nombre);


                //String nombre = String.valueOf(tbmodel.getValueAt(TbListaCliente.getSelectedRow(),1));
                //FrmPedido.Cliente.equals(nombre);

                FrmPedido fr = new FrmPedido();

                int i = TbListaCliente.getSelectedRow();

                //fr.setTxtCliente(TbListaCliente.getValueAt(i,1).toString());

            }
        });
    }

    public void listar(){

        Object[] column = {"Codigo","Nombres","telefono","Correo","direccion"};
        //Object[] row =new Object[0];

        tbmodel.setColumnIdentifiers(column);
        //tbmodel.setColumnIdentifiers(row);
        TbListaCliente.setModel(tbmodel);
        TbListaCliente.setAutoCreateRowSorter(true);
        tr = new  TableRowSorter<>(tbmodel);
        TbListaCliente.setRowSorter(tr);

        tbmodel.addRow(new Object[] { "1", "Carlos diaz", "987678765","juan@gmail", "av. los pinos" });
        tbmodel.addRow(new Object[] { "1", "Juan", "987678765", "juan@gmail","av. los pinos" });
        tbmodel.addRow(new Object[] { "2", "tomas","987678765", "juan@gmail","av. los pinos" });
        tbmodel.addRow(new Object[] { "3", "pepe", "987678765", "juan@gmail","av. los pinos" });
        tbmodel.addRow(new Object[] { "4", "maria", "987678765","juan@gmail","av. los pinos" });
        tbmodel.addRow(new Object[] { "5", "shaka", "987678765","juan@gmail","av. los pinos" });


    }

}
