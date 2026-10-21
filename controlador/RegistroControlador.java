package controlador;

import modelo.*;
import vista.JFRegistro;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

public class RegistroControlador {
    
    private JFRegistro vista;
    private ArrayList<Persona> listaPersonas;
    
    public RegistroControlador(JFRegistro vista) {
        this.vista = vista;
        this.listaPersonas = new ArrayList<Persona>();
        asignarEventos();
    }
    
    private void asignarEventos() {
        // Evento del combo Tipo
        vista.cmbTipo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tipo = (String) vista.cmbTipo.getSelectedItem();
                if (tipo != null && !tipo.equals("Seleccione...")) {
                    vista.habilitarSegunTipo(tipo);
                } else {
                    vista.deshabilitarTodoEspecifico();
                }
            }
        });
        
        // Botón Guardar
        vista.btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardar();
            }
        });
        
        // Botón Buscar
        vista.btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscar();
            }
        });
        
        // Botón Limpiar
        vista.btnLimpiar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiar();
            }
        });
    }
    
    // Validar campos básicos obligatorios
    private boolean validarCamposBasicos() {
        if (vista.txtDocumento.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(vista, "Debe ingresar el documento", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (vista.txtNombre.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(vista, "Debe ingresar el nombre", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (vista.txtApellido.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(vista, "Debe ingresar el apellido", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        if (vista.txtEdad.getText().trim().equals("")) {
            JOptionPane.showMessageDialog(vista, "Debe ingresar la edad", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        String tipo = (String) vista.cmbTipo.getSelectedItem();
        if (tipo == null || tipo.equals("Seleccione...")) {
            JOptionPane.showMessageDialog(vista, "Debe seleccionar el tipo de persona", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    // Validación de la distribución del bono
    private boolean validarDistribucion(String tipo) {
        try {
            if (tipo.equals("Profesional Salud")) {
                double medicina = Double.parseDouble(vista.txtMedicinaSalud.getText().trim());
                double bio = Double.parseDouble(vista.txtBioseguridad.getText().trim());
                double total = medicina + bio;
                
                if (medicina < 0 || bio < 0) {
                    JOptionPane.showMessageDialog(vista, "Los montos no pueden ser negativos", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                if (total > 350000) {
                    JOptionPane.showMessageDialog(vista, 
                        "La suma de Medicina + Bioseguridad no puede superar $350.000\nTotal actual: " + total, 
                        "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                
            } else if (tipo.equals("Persona Independiente")) {
                double medicina = Double.parseDouble(vista.txtMedicinaInd.getText().trim());
                double canasta = Double.parseDouble(vista.txtCanasta.getText().trim());
                double total = medicina + canasta;
                
                if (medicina < 0 || canasta < 0) {
                    JOptionPane.showMessageDialog(vista, "Los montos no pueden ser negativos", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                if (total > 160000) {
                    JOptionPane.showMessageDialog(vista, 
                        "La suma de Medicina + Canasta Familiar no puede superar $160.000\nTotal actual: " + total, 
                        "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                
            } else if (tipo.equals("Docente")) {
                double tecnologia = Double.parseDouble(vista.txtTecnologia.getText().trim());
                double servicios = Double.parseDouble(vista.txtServicios.getText().trim());
                double total = tecnologia + servicios;
                
                if (tecnologia < 0 || servicios < 0) {
                    JOptionPane.showMessageDialog(vista, "Los montos no pueden ser negativos", "Error", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
                if (total > 100000) {
                    JOptionPane.showMessageDialog(vista, 
                        "La suma de Tecnología + Servicios no puede superar $100.000\nTotal actual: " + total, 
                        "Error de validación", JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "Los montos de distribución deben ser números válidos", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        
        return true;
    }
    
    // Método GUARDAR
    public void guardar() {
        if (!validarCamposBasicos()) {
            return;
        }
        
        String tipo = (String) vista.cmbTipo.getSelectedItem();
        
        // Validar distribución del bono
        if (!validarDistribucion(tipo)) {
            return;
        }
        
        // Validar campos específicos según tipo
        if (tipo.equals("Profesional Salud")) {
            if (vista.txtInstitucion.getText().trim().equals("") || 
                vista.txtEspecialidad.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(vista, "Debe completar Institución y Especialidad", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } else if (tipo.equals("Docente")) {
            if (vista.txtInstitucion.getText().trim().equals("")) {
                JOptionPane.showMessageDialog(vista, "Debe completar la Institución Educativa", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        // Verificar si el documento ya existe
        String numeroDoc = vista.txtDocumento.getText().trim();
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i).getNumeroDocumento().equals(numeroDoc)) {
                JOptionPane.showMessageDialog(vista, "Ya existe una persona con ese documento", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }
        
        // Obtener datos comunes
        String tipoDoc = (String) vista.cmbTipoDocumento.getSelectedItem();
        String nombre = vista.txtNombre.getText().trim();
        String apellido = vista.txtApellido.getText().trim();
        String direccion = vista.txtDireccion.getText().trim();
        String telefono = vista.txtTelefono.getText().trim();
        int edad = Integer.parseInt(vista.txtEdad.getText().trim());
        
        int estrato = 0;
        try {
            estrato = Integer.parseInt(vista.txtEstrato.getText().trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(vista, "El estrato debe ser un número", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String estadoCivil = vista.txtEstadoCivil.getText().trim();
        boolean cabezaHogar = vista.chkCabezaHogar.isSelected();
        
       
        Persona nuevaPersona = null;
        
        if (tipo.equals("Persona Independiente")) {
            double montoMed = Double.parseDouble(vista.txtMedicinaInd.getText().trim());
            double montoCan = Double.parseDouble(vista.txtCanasta.getText().trim());
            
            nuevaPersona = new PersonaIndependiente(tipoDoc, numeroDoc, nombre, apellido, 
                    direccion, telefono, edad, estrato, estadoCivil, cabezaHogar,
                    montoMed, montoCan);
            
        } else if (tipo.equals("Profesional Salud")) {
            String inst = vista.txtInstitucion.getText().trim();
            String esp = vista.txtEspecialidad.getText().trim();
            double montoMed = Double.parseDouble(vista.txtMedicinaSalud.getText().trim());
            double montoBio = Double.parseDouble(vista.txtBioseguridad.getText().trim());
            
            nuevaPersona = new ProfesionalSalud(tipoDoc, numeroDoc, nombre, apellido, 
                    direccion, telefono, edad, estrato, estadoCivil, cabezaHogar,
                    inst, esp, montoMed, montoBio);
            
        } else if (tipo.equals("Docente")) {
            String inst = vista.txtInstitucion.getText().trim();
            String nivel = (String) vista.cmbNivel.getSelectedItem();
            double montoTec = Double.parseDouble(vista.txtTecnologia.getText().trim());
            double montoSer = Double.parseDouble(vista.txtServicios.getText().trim());
            
            nuevaPersona = new Docente(tipoDoc, numeroDoc, nombre, apellido, 
                    direccion, telefono, edad, estrato, estadoCivil, cabezaHogar,
                    inst, nivel, montoTec, montoSer);
        }
        
        // Guardar en el ArrayList
        if (nuevaPersona != null) {
            listaPersonas.add(nuevaPersona);
            JOptionPane.showMessageDialog(vista, 
                "Persona guardada exitosamente.\nTotal de personas registradas: " + listaPersonas.size(), 
                "Éxito", JOptionPane.INFORMATION_MESSAGE);
            limpiar();
        }
    }
    
    // Método BUSCAR
    public void buscar() {
        String numeroDoc = vista.txtDocumento.getText().trim();
        
        if (numeroDoc.equals("")) {
            JOptionPane.showMessageDialog(vista, "Ingrese el documento a buscar", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Persona encontrada = null;
        
        for (int i = 0; i < listaPersonas.size(); i++) {
            if (listaPersonas.get(i).getNumeroDocumento().equals(numeroDoc)) {
                encontrada = listaPersonas.get(i);
                break;
            }
        }
        
        if (encontrada == null) {
            JOptionPane.showMessageDialog(vista, "No se encontró ninguna persona con el documento: " + numeroDoc, 
                    "No encontrado", JOptionPane.INFORMATION_MESSAGE);
            return;
        }
        
        // Mostrar los datos (polimorfismo)
        String mensaje = encontrada.mostrarDatos();
        JOptionPane.showMessageDialog(vista, mensaje, "Datos de la Persona", JOptionPane.INFORMATION_MESSAGE);
        
        // Cargar los datos en el formulario
        cargarDatosEnFormulario(encontrada);
    }
    
    // Cargar datos de una persona en el formulario
    private void cargarDatosEnFormulario(Persona p) {
        vista.cmbTipoDocumento.setSelectedItem(p.getTipoDocumento());
        vista.txtDocumento.setText(p.getNumeroDocumento());
        vista.txtNombre.setText(p.getNombre());
        vista.txtApellido.setText(p.getApellidos());
        vista.txtDireccion.setText(p.getDireccion());
        vista.txtTelefono.setText(p.getTelefono());
        vista.txtEdad.setText(String.valueOf(p.getEdad()));
        vista.txtEstrato.setText(String.valueOf(p.getEstrato()));
        vista.txtEstadoCivil.setText(p.getEstadoCivil());
        vista.chkCabezaHogar.setSelected(p.isCabezaHogar());
        vista.cmbTipo.setSelectedItem(p.getTipoPersona());
        
        // Habilitar según tipo
        vista.habilitarSegunTipo(p.getTipoPersona());
        
        // Cargar datos específicos
        if (p instanceof ProfesionalSalud) {
            ProfesionalSalud ps = (ProfesionalSalud) p;
            vista.txtInstitucion.setText(ps.getInstitucionSalud());
            vista.txtEspecialidad.setText(ps.getEspecialidad());
            vista.txtMedicinaSalud.setText(String.valueOf(ps.getMontoMedicina()));
            vista.txtBioseguridad.setText(String.valueOf(ps.getMontoBioseguridad()));
            
        } else if (p instanceof PersonaIndependiente) {
            PersonaIndependiente pi = (PersonaIndependiente) p;
            vista.txtMedicinaInd.setText(String.valueOf(pi.getMontoMedicina()));
            vista.txtCanasta.setText(String.valueOf(pi.getMontoCanasta()));
            
        } else if (p instanceof Docente) {
            Docente d = (Docente) p;
            vista.txtInstitucion.setText(d.getInstitucionEducativa());
            vista.cmbNivel.setSelectedItem(d.getNivelEducativo());
            vista.txtTecnologia.setText(String.valueOf(d.getMontoTecnologia()));
            vista.txtServicios.setText(String.valueOf(d.getMontoServicios()));
        }
    }
    
    // Método LIMPIAR
    public void limpiar() {
        vista.limpiarCampos();
    }
}
