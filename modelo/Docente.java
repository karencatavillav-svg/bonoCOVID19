package modelo;

public class Docente extends Persona {
    
    // Atributos propios
    private String institucionEducativa;
    private String nivelEducativo;
    
    // Atributos del bono (100.000)
    private double montoTecnologia;
    private double montoServicios;
    
    // Constructor vacío
    public Docente() {
        super();
    }
    
    // Constructor completo
    public Docente(String tipoDocumento, String numeroDocumento, String nombre, 
                   String apellidos, String direccion, String telefono, 
                   int edad, int estrato, String estadoCivil, boolean cabezaHogar,
                   String institucionEducativa, String nivelEducativo,
                   double montoTecnologia, double montoServicios) {
        super(tipoDocumento, numeroDocumento, nombre, apellidos, direccion, telefono, 
              edad, estrato, estadoCivil, cabezaHogar, "Docente");
        this.institucionEducativa = institucionEducativa;
        this.nivelEducativo = nivelEducativo;
        this.montoTecnologia = montoTecnologia;
        this.montoServicios = montoServicios;
    }
    
    // Getters y Setters
    public String getInstitucionEducativa() {
        return institucionEducativa;
    }
    
    public void setInstitucionEducativa(String institucionEducativa) {
        this.institucionEducativa = institucionEducativa;
    }
    
    public String getNivelEducativo() {
        return nivelEducativo;
    }
    
    public void setNivelEducativo(String nivelEducativo) {
        this.nivelEducativo = nivelEducativo;
    }
    
    public double getMontoTecnologia() {
        return montoTecnologia;
    }
    
    public void setMontoTecnologia(double montoTecnologia) {
        this.montoTecnologia = montoTecnologia;
    }
    
    public double getMontoServicios() {
        return montoServicios;
    }
    
    public void setMontoServicios(double montoServicios) {
        this.montoServicios = montoServicios;
    }
    
    // Método para mostrar todos los datos
    public String mostrarDatos() {
        String texto = super.mostrarDatos();
        texto = texto + "Institución Educativa: " + institucionEducativa + "\n";
        texto = texto + "Nivel Educativo: " + nivelEducativo + "\n";
        texto = texto + "Monto Tecnología: " + montoTecnologia + "\n";
        texto = texto + "Monto Servicios (luz/internet): " + montoServicios + "\n";
        texto = texto + "Total distribuido: " + (montoTecnologia + montoServicios) + "\n";
        return texto;
    }
}
