package modelo;

public class ProfesionalSalud extends Persona {
    
    // Atributos propios
    private String institucionSalud;
    private String especialidad;
    
    // Atributos del bono (350.000)
    private double montoMedicina;
    private double montoBioseguridad;
    
    // Constructor vacío
    public ProfesionalSalud() {
        super();
    }
    
    // Constructor completo
    public ProfesionalSalud(String tipoDocumento, String numeroDocumento, String nombre, 
                            String apellidos, String direccion, String telefono, 
                            int edad, int estrato, String estadoCivil, boolean cabezaHogar,
                            String institucionSalud, String especialidad,
                            double montoMedicina, double montoBioseguridad) {
        super(tipoDocumento, numeroDocumento, nombre, apellidos, direccion, telefono, 
              edad, estrato, estadoCivil, cabezaHogar, "Profesional Salud");
        this.institucionSalud = institucionSalud;
        this.especialidad = especialidad;
        this.montoMedicina = montoMedicina;
        this.montoBioseguridad = montoBioseguridad;
    }
    
    // Getters y Setters
    public String getInstitucionSalud() {
        return institucionSalud;
    }
    
    public void setInstitucionSalud(String institucionSalud) {
        this.institucionSalud = institucionSalud;
    }
    
    public String getEspecialidad() {
        return especialidad;
    }
    
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    public double getMontoMedicina() {
        return montoMedicina;
    }
    
    public void setMontoMedicina(double montoMedicina) {
        this.montoMedicina = montoMedicina;
    }
    
    public double getMontoBioseguridad() {
        return montoBioseguridad;
    }
    
    public void setMontoBioseguridad(double montoBioseguridad) {
        this.montoBioseguridad = montoBioseguridad;
    }
    
    // Método para mostrar todos los datos
    public String mostrarDatos() {
        String texto = super.mostrarDatos();
        texto = texto + "Institución de Salud: " + institucionSalud + "\n";
        texto = texto + "Especialidad: " + especialidad + "\n";
        texto = texto + "Monto Medicina: " + montoMedicina + "\n";
        texto = texto + "Monto Bioseguridad: " + montoBioseguridad + "\n";
        texto = texto + "Total distribuido: " + (montoMedicina + montoBioseguridad) + "\n";
        return texto;
    }
}
