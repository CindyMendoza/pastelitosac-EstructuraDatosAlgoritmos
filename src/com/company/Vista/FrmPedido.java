package com.company.Vista;
//Librería

import com.company.Clases.Cliente;
import com.company.Clases.Pedido;
import com.company.Clases.Producto;
import com.company.JSON.ReadJSON;
import com.company.Main;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.Document;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class FrmPedido {
    private JPanel PanelPedido;
    private JButton btnMetricas;
    private JComboBox cmbProducto;
    private JTextField txtPrecio;
    private JTextField txtCantidad;
    private JTextField txtTotal;
    private JButton btnRegistrar;
    private JButton btnBorrarCampos;
    private JButton btnActualizar;
    private JTable TbPedido;
    private JCheckBox pedidoExpress;
    public  JTextField txtCliente;
    private JLabel imagenProducto;
    private JFrame frame = new JFrame();
    public ArrayList<Cliente> clientes;

    DefaultTableModel tbmodel = (DefaultTableModel) TbPedido.getModel();

    public JPanel getRootPanel() {
        return PanelPedido;
    }

    //Variables globales
    int indicePrecio;
    String cantidadProducto;
    double precioUnitario;

    //Manejar datos de JSON y listado de pedidos
    ArrayList<Pedido> pedidos = new ArrayList<>();
    ArrayList<Pedido> pedidosOrdenados = new ArrayList<>();
    ArrayList<Producto> productos = new ArrayList<>();
    ReadJSON readJSON = new ReadJSON();

    protected class DocumentListenerCantidad implements DocumentListener{
        public void insertUpdate(DocumentEvent e) {
            indicePrecio = cmbProducto.getSelectedIndex();
            precioUnitario = productos.get(indicePrecio).getPrecioUni();
            cantidadProducto = txtCantidad.getText(); // get cantidad
            int cantidadInt = Integer.parseInt(cantidadProducto); // int cantidad

            //Calcular total
            double total = cantidadInt*precioUnitario;
            txtTotal.setText(String.valueOf(total));
        }

        public void removeUpdate(DocumentEvent e) {
            indicePrecio = cmbProducto.getSelectedIndex();
            precioUnitario = productos.get(indicePrecio).getPrecioUni();
            cantidadProducto = txtCantidad.getText(); // get cantidad
            int cantidadInt;

            if(txtCantidad.getText().isEmpty()){
                    txtTotal.setText(" ");
                    cantidadInt = 0;
            } else {
                cantidadInt = Integer.parseInt(cantidadProducto); // int cantidad
            }

            double total = cantidadInt*precioUnitario;

            txtTotal.setText(String.valueOf(total));
        }

        public void changedUpdate(DocumentEvent e) {
            displayEditInfo(e);
        }
        private void displayEditInfo(DocumentEvent e) {
            Document document = e.getDocument();
            int changeLength = e.getLength();
        }
    }

    public void cambio() {

        if (cmbProducto.getSelectedItem().toString().equals("Cheesecake")) {
            System.out.println(cmbProducto.getSelectedItem().toString());
            imagenProducto.setIcon(new ImageIcon(getClass().getResource("/img/chees.jpg")));
        }
        if (cmbProducto.getSelectedItem().toString().equals("Tiramisú")) {
            System.out.println(cmbProducto.getSelectedItem().toString());
            imagenProducto.setIcon(new ImageIcon(getClass().getResource("/img/tira.jpg")));
        }
        if (cmbProducto.getSelectedItem().toString().equals("Tres Leches")) {
            System.out.println(cmbProducto.getSelectedItem().toString());
            imagenProducto.setIcon(new ImageIcon(getClass().getResource("/img/tres.jpg")));
        }
        if (cmbProducto.getSelectedItem().toString().equals("Ópera")) {
            System.out.println(cmbProducto.getSelectedItem().toString());
            imagenProducto.setIcon(new ImageIcon(getClass().getResource("/img/ope.jpg")));

        }
        if (cmbProducto.getSelectedItem().toString().equals("Tarta de Santiago")) {
            imagenProducto.setIcon(new ImageIcon(getClass().getResource("/img/santi.jpg")));

        }
    }

    public FrmPedido(ArrayList<Cliente> clientes){

        listar();
        agregarNombreProductos();

        System.out.println("Clientes FrmPedido"+clientes.isEmpty());

        //Clientes
        this.clientes = clientes;

        // Agregar DocumentListener a campo de cantidad
        txtCantidad.getDocument().addDocumentListener(new DocumentListenerCantidad());

        cmbProducto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                indicePrecio = cmbProducto.getSelectedIndex(); //get indice combobox
                txtPrecio.setText(String.valueOf(precioUnitario = productos.get(indicePrecio).getPrecioUni())); // set precio en lbl
                precioUnitario = productos.get(indicePrecio).getPrecioUni();    // get precio
                cantidadProducto = txtCantidad.getText(); // get cantidad
            }
        });

        txtCantidad.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e){
                indicePrecio = cmbProducto.getSelectedIndex();
                precioUnitario = productos.get(indicePrecio).getPrecioUni();

                //Validar si la cantidad ingresada es un número válido
                char keyChar = e.getKeyChar();
                int keyCode = e.getKeyCode();

                txtCantidad.setEditable(!Character.isLetter(keyChar) && keyCode != 32);
            }

            @Override
            public void keyPressed(KeyEvent e) {
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });

        TbPedido.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                int i = TbPedido.getSelectedRow();
                txtCliente.setText(TbPedido.getValueAt(i,0).toString());
                cmbProducto.setSelectedItem((TbPedido.getValueAt(i,1).toString()));
                txtPrecio.setText(TbPedido.getValueAt(i,2).toString());
                txtCantidad.setText(TbPedido.getValueAt(i,3).toString());
                txtTotal.setText(TbPedido.getValueAt(i,4).toString());

                pedidoExpress.setSelected(TbPedido.getValueAt(i, 5).equals("Si"));
            }
        });

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (txtCliente.getText().equals("") ||
                        cmbProducto.getSelectedItem().toString().equals("Seleccione:") ||
                        txtPrecio.getText().equals("") ||
                        txtCantidad.getText().equals("")){
                    JOptionPane.showMessageDialog( null, "Debe llenar los datos solicitados");
                } else {

                    Pedido pedido = new Pedido(
                            txtCliente.getText(),
                            cmbProducto.getSelectedItem().toString(),
                            Double.parseDouble(txtPrecio.getText()),
                            Integer.parseInt(txtCantidad.getText()),
                            Double.parseDouble(txtTotal.getText()),
                            "xyz",
                            "46545454",
                            pedidoExpress.isSelected()
                    );

                    pedidos = readJSON.getPedidos(pedidos);

                    pedidos.add(pedido);

                    pedidosOrdenados = readJSON.ordenarPedidos(pedidos);

                    //Delete Rows
                    int rowCount = tbmodel.getRowCount();

                    //Remover filas una a una
                    for(int i = rowCount-1; i>=0; i--){
                        tbmodel.removeRow(i);
                    }

                    //Agregar todos los pedidos ordenados
                    for(Pedido p: pedidosOrdenados){
                        final Object[] tbRow = p.getObjetRow();
                        tbmodel.addRow(tbRow);
                    }

                    listar();
                    JOptionPane.showMessageDialog( null, "Registro exitoso!");
                    BorrarCampos();
                }
            }
        });

        btnBorrarCampos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               BorrarCampos();
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Actualizar();
            }
        });

        TbPedido.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });

        cmbProducto.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cambio();
            }
        });

        btnMetricas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Metricas();
            }
        });
    }

    public void load () {
        frame.add(PanelPedido);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setSize(750, 600);
        frame.setIconImage(new ImageIcon(Main.class.getResource("/img/cake.png")).getImage());
        frame.setTitle("Pastelitos");
    }

    public void dispose(){
        frame.dispose();
    }

    public void listar(){
        Object[] column = {"Cliente","Producto","Precio","Cantidad","PrecioTotal","Delivery"};
        tbmodel.setColumnIdentifiers(column);
        TbPedido.setModel(tbmodel);
        TbPedido.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        TbPedido.getTableHeader().setOpaque(false);
        TbPedido.getTableHeader().setBackground(new Color(78,145,140));
        TbPedido.setRowHeight(25);

        if(!pedidosOrdenados.isEmpty()){
            pedidosOrdenados = readJSON.ordenarPedidos(pedidos);

            //Delete Rows
            int rowCount = tbmodel.getRowCount();

            //Remover filas una a una
            for(int i = rowCount-1; i>=0; i--){
                tbmodel.removeRow(i);
            }

            //Agregar todos los pedidos ordenados
            for(Pedido p: pedidosOrdenados){
                final Object[] tbRow = p.getObjetRow();
                tbmodel.addRow(tbRow);
            }
        } else {
            pedidos = readJSON.getPedidos(pedidos);
            pedidosOrdenados = readJSON.ordenarPedidos(pedidos);

            //Delete Rows
            int rowCount = tbmodel.getRowCount();

            //Remover filas una a una
            for(int i = rowCount-1; i>=0; i--){
                tbmodel.removeRow(i);
            }

            //Agregar todos los pedidos ordenados
            for(Pedido p: pedidosOrdenados){
                final Object[] tbRow = p.getObjetRow();
                tbmodel.addRow(tbRow);
            }
        }
    }

    public void agregarNombreProductos(){
        productos = readJSON.getProductos(productos);

        for(Producto p: productos){
            final Object[] tbRow = p.getObjetRow();

            cmbProducto.addItem(tbRow[0]);
        }

    }

    public void BorrarCampos(){
        cmbProducto.setSelectedIndex(0);
        txtPrecio.setText("");
        txtCantidad.setText("");
        txtTotal.setText("");
        pedidoExpress.setSelected(false);
    }

    public void Actualizar(){

        int dto = TbPedido.getSelectedRow();

        if ( dto >=0){

            TbPedido.setValueAt(txtCliente.getText(), dto,0);
            TbPedido.setValueAt(cmbProducto.getSelectedItem().toString(), dto,1);
            TbPedido.setValueAt(txtPrecio.getText(), dto,2);
            TbPedido.setValueAt(txtCantidad.getText(), dto,3);
            TbPedido.setValueAt(txtTotal.getText(), dto,4);
            TbPedido.setValueAt(pedidoExpress.isSelected(), dto,5);



            JOptionPane.showMessageDialog( null, "Se Actualizó correctamente");

        } else {
            JOptionPane.showMessageDialog( null, "Error al Actualizar");
        }

    }

    public void Metricas () {
        System.out.println("Pedidos"+pedidos.isEmpty());
        System.out.println("Clientes Metricas"+clientes.isEmpty());
        FrmMetricas frmMetricas = new FrmMetricas(pedidos, this.clientes);
        frmMetricas.load();
    }
}
