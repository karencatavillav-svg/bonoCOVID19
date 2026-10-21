import vista.JFRegistro;
import controlador.RegistroControlador;

public class Principal {
    
    public static void main(String[] args) {
        // Crear la vista
        JFRegistro ventana = new JFRegistro();
        
        // Crear el controlador y pasarle la vista
        RegistroControlador controlador = new RegistroControlador(ventana);
        
        // Mostrar la ventana
        ventana.setVisible(true);
    }
}
