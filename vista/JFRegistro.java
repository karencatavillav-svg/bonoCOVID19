package vista;

import javax.swing.*;
import java.awt.*;

public class JFRegistro extends JFrame {
    
     public JPanel panel1;
     public JLabel lblTipoDocumento, lblDocumento, lblNombre, lblApellido,
              lblDireccion, lblTelefono, lblEdad, lblEstrato,
              lblEstadoCivil, lblTipo, lblInstitucion, lblEspecialidad,
              lblNivel;
     public JTextField txtDocumento, txtNombre, txtApellido, txtDireccion,
                  txtTelefono, txtEdad, txtEstrato, txtEstadoCivil,
                  txtInstitucion, txtEspecialidad;
     public JComboBox<String> cmbTipoDocumento, cmbTipo, cmbNivel;
     public JCheckBox chkCabezaHogar;

     public JPanel panel2;
     public JButton btnGuardar, btnLimpiar, btnBuscar;

     public JPanel panel3;
     public JLabel lblBioseguridad, lblMedicinaSalud;
     public JTextField txtBioseguridad, txtMedicinaSalud;

     public JPanel panel4;
     public JLabel lblTecnologia, lblServicios;
     public JTextField txtTecnologia, txtServicios; 

     public JPanel panel5; 
     public JLabel lblMedicinaInd, lblCanasta;
     public JTextField txtMedicinaInd, txtCanasta;
     public JPanel panelPrincipal, panelDerecho;
    
    public JFRegistro() {
        estructura();
    }
    
    public void estructura() {
        setTitle("Registro datos básicos");
        setSize(780, 520);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout(8, 8));
        panelPrincipal.setBackground(new Color(240, 240, 240));
        panelPrincipal.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));
        
        panel1 = new JPanel();
        panel1.setLayout(new GridLayout(14, 2, 5, 4));
        panel1.setBackground(new Color(245, 245, 245));
        panel1.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY), "Registro datos básicos"));
        
        // Tipo Documento
        lblTipoDocumento = new JLabel("Tipo Documento");
        cmbTipoDocumento = new JComboBox<String>();
        cmbTipoDocumento.addItem("CC");
        cmbTipoDocumento.addItem("CE");
        cmbTipoDocumento.addItem("TI");
        cmbTipoDocumento.addItem("Pasaporte");
        
        // Documento
        lblDocumento = new JLabel("Documento");
        txtDocumento = new JTextField();
        
        // Nombre
        lblNombre = new JLabel("Nombre");
        txtNombre = new JTextField();
        
        // Apellido
        lblApellido = new JLabel("Apellido");
        txtApellido = new JTextField();
        
        // Direccion
        lblDireccion = new JLabel("Direccion");
        txtDireccion = new JTextField();
        
        // Telefono
        lblTelefono = new JLabel("Telefono");
        txtTelefono = new JTextField();
        
        // Edad
        lblEdad = new JLabel("Edad");
        txtEdad = new JTextField();
        
        // Estrato
        lblEstrato = new JLabel("Estrato");
        txtEstrato = new JTextField();
        
        // Estado Civil
        lblEstadoCivil = new JLabel("Estado Civil");
        txtEstadoCivil = new JTextField();
        
        // Tipo
        lblTipo = new JLabel("Tipo");
        cmbTipo = new JComboBox<String>();
        cmbTipo.addItem("Seleccione...");
        cmbTipo.addItem("Persona Independiente");
        cmbTipo.addItem("Profesional Salud");
        cmbTipo.addItem("Docente");
        
        // Institucion
        lblInstitucion = new JLabel("Institucion");
        txtInstitucion = new JTextField();
        
        // Especialidad
        lblEspecialidad = new JLabel("Especialidad");
        txtEspecialidad = new JTextField();
        
        // Nivel
        lblNivel = new JLabel("Nivel");
        cmbNivel = new JComboBox<String>();
        cmbNivel.addItem("Primaria");
        cmbNivel.addItem("Secundaria");
        cmbNivel.addItem("Técnico");
        cmbNivel.addItem("Tecnólogo");
        cmbNivel.addItem("Profesional");
        cmbNivel.addItem("Especialización");
        cmbNivel.addItem("Maestría");
        cmbNivel.addItem("Doctorado");
        
        // Cabeza de hogar
        chkCabezaHogar = new JCheckBox("Cabeza de hogar");
        
        //Panel 1
        panel1.add(lblTipoDocumento);
        panel1.add(cmbTipoDocumento);
        panel1.add(lblDocumento);
        panel1.add(txtDocumento);
        panel1.add(lblNombre);
        panel1.add(txtNombre);
        panel1.add(lblApellido);
        panel1.add(txtApellido);
        panel1.add(lblDireccion);
        panel1.add(txtDireccion);
        panel1.add(lblTelefono);
        panel1.add(txtTelefono);
        panel1.add(lblEdad);
        panel1.add(txtEdad);
        panel1.add(lblEstrato);
        panel1.add(txtEstrato);
        panel1.add(lblEstadoCivil);
        panel1.add(txtEstadoCivil);
        panel1.add(lblTipo);
        panel1.add(cmbTipo);
        panel1.add(lblInstitucion);
        panel1.add(txtInstitucion);
        panel1.add(lblEspecialidad);
        panel1.add(txtEspecialidad);
        panel1.add(lblNivel);
        panel1.add(cmbNivel);
        panel1.add(chkCabezaHogar);
        panel1.add(new JLabel(""));
        
        //PANEL DERECHO
        panelDerecho = new JPanel();
        panelDerecho.setLayout(new BorderLayout(5, 5));
        panelDerecho.setBackground(new Color(240, 240, 240));
        
        //PANEL BOTONES
        panel2 = new JPanel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 8));
        panel2.setBackground(new Color(230, 230, 230));
        panel2.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY), "Panel botones"));
        
        btnGuardar = new JButton("Guardar");
        btnGuardar.setPreferredSize(new Dimension(100, 30));
        
        btnLimpiar = new JButton("Limpiar");
        btnLimpiar.setPreferredSize(new Dimension(100, 30));
        
        btnBuscar = new JButton("Buscar");
        btnBuscar.setPreferredSize(new Dimension(100, 30));
        
        panel2.add(btnGuardar);
        panel2.add(btnLimpiar);
        panel2.add(btnBuscar);
        
        //PANEL DE DISTRIBUCIONES
        JPanel panelDistribuciones = new JPanel();
        panelDistribuciones.setLayout(new GridLayout(3, 1, 5, 5));
        panelDistribuciones.setBackground(new Color(240, 240, 240));
        
        // PANEL 3
        panel3 = new JPanel();
        panel3.setLayout(new GridLayout(2, 2, 5, 5));
        panel3.setBackground(new Color(245, 245, 245));
        panel3.setBorder(BorderFactory.createTitledBorder(
                BorderFactory.createLineBorder(Color.GRAY), "Distribución Bono Prof Salud"));
        
        lblBioseguridad = new JLabel("Elemento Bioseguridad");
        txtBioseguridad = new JTextField();
        lblMedicinaSalud = new JLabel("Medicina");
        txtMedicinaSalud = new JTextField();
        
        panel3.add(lblBioseguridad);
        panel3.add(txtBioseguridad);
        panel3.add(lblMedicinaSalud);
        panel3.add(txtMedicinaSalud);
        
        // PANEL 4
        panel4 = new JPanel();
        panel4.setLayout(new GridLayout(2, 2, 5, 5));
        panel4.setBackground(new Color(245, 245, 245));
        panel4.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Distribución Bono Docente"));
        
        lblTecnologia = new JLabel("Implementos Tecnológicos");
        txtTecnologia = new JTextField();
        lblServicios = new JLabel("Servicio Internet / Energía");
        txtServicios = new JTextField();
        
        panel4.add(lblTecnologia);
        panel4.add(txtTecnologia);
        panel4.add(lblServicios);
        panel4.add(txtServicios);
        
        // PANEL 5
        panel5 = new JPanel();
        panel5.setLayout(new GridLayout(2, 2, 5, 5));
        panel5.setBackground(new Color(245, 245, 245));
        panel5.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.GRAY), "Distribución Bono Persona Independiente"));
        
        lblMedicinaInd = new JLabel("Medicina");
        txtMedicinaInd = new JTextField();
        lblCanasta = new JLabel("Canasta Familiar");
        txtCanasta = new JTextField();
        
        panel5.add(lblMedicinaInd);
        panel5.add(txtMedicinaInd);
        panel5.add(lblCanasta);
        panel5.add(txtCanasta);
        
        panelDistribuciones.add(panel3);
        panelDistribuciones.add(panel4);
        panelDistribuciones.add(panel5);
        

        panelDerecho.add(panel2, BorderLayout.NORTH);
        panelDerecho.add(panelDistribuciones, BorderLayout.CENTER);
        
        panelPrincipal.add(panel1, BorderLayout.WEST);
        panelPrincipal.add(panelDerecho, BorderLayout.CENTER);
        
        add(panelPrincipal);
        
        deshabilitarTodoEspecifico();
    }
    
    // Deshabilita campos específicos y paneles de distribución
    public void deshabilitarTodoEspecifico() {
        txtInstitucion.setEnabled(false);
        txtEspecialidad.setEnabled(false);
        cmbNivel.setEnabled(false);
        
        // Panel 3
        panel3.setEnabled(false);
        txtBioseguridad.setEnabled(false);
        txtMedicinaSalud.setEnabled(false);
        
        // Panel 4
        panel4.setEnabled(false);
        txtTecnologia.setEnabled(false);
        txtServicios.setEnabled(false);
        
        // Panel 5
        panel5.setEnabled(false);
        txtMedicinaInd.setEnabled(false);
        txtCanasta.setEnabled(false);
    }
    
    // Habilita según el tipo seleccionado
    public void habilitarSegunTipo(String tipo) {
        deshabilitarTodoEspecifico();
        
        if (tipo.equals("Profesional Salud")) {
            
            txtInstitucion.setEnabled(true);
            txtEspecialidad.setEnabled(true);
            cmbNivel.setEnabled(false);
            
            //Panel 3
            panel3.setEnabled(true);
            txtBioseguridad.setEnabled(true);
            txtMedicinaSalud.setEnabled(true);
            
        } else if (tipo.equals("Docente")) {
            // Campos específicos de docente
            txtInstitucion.setEnabled(true);
            txtEspecialidad.setEnabled(false);
            cmbNivel.setEnabled(true);
            
            //Panel 4
            panel4.setEnabled(true);
            txtTecnologia.setEnabled(true);
            txtServicios.setEnabled(true);
            
        } else if (tipo.equals("Persona Independiente")) {
            txtInstitucion.setEnabled(false);
            txtEspecialidad.setEnabled(false);
            cmbNivel.setEnabled(false);
            
            //Panel 5
            panel5.setEnabled(true);
            txtMedicinaInd.setEnabled(true);
            txtCanasta.setEnabled(true);
        }
    }
    
    // Limpia todos los campos
    public void limpiarCampos() {
        cmbTipoDocumento.setSelectedIndex(0);
        txtDocumento.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtEdad.setText("");
        txtEstrato.setText("");
        txtEstadoCivil.setText("");
        cmbTipo.setSelectedIndex(0);
        txtInstitucion.setText("");
        txtEspecialidad.setText("");
        cmbNivel.setSelectedIndex(0);
        chkCabezaHogar.setSelected(false);
        
        txtBioseguridad.setText("");
        txtMedicinaSalud.setText("");
        txtTecnologia.setText("");
        txtServicios.setText("");
        txtMedicinaInd.setText("");
        txtCanasta.setText("");
        
        deshabilitarTodoEspecifico();
    }
}
