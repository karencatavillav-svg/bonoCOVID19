package modelo;

public class PersonaIndependiente extends Persona {
    
    // Atributos propios del bono (160.000)
    private double montoMedicina;
    private double montoCanasta;
    
    // Constructor vacío
    public PersonaIndependiente() {
        super();
    }
    
    // Constructor completo
    public PersonaIndependiente(String tipoDocumento, String numeroDocumento, String nombre, 
                                String apellidos, String direccion, String telefono, 
                                int edad, int estrato, String estadoCivil, boolean cabezaHogar,
                                double montoMedicina, double montoCanasta) {
        super(tipoDocumento, numeroDocumento, nombre, apellidos, direccion, telefono, 
              edad, estrato, estadoCivil, cabezaHogar, "Persona Independiente");
        this.montoMedicina = montoMedicina;
        this.montoCanasta = montoCanasta;
    }
    
    // Getters y Setters
    public double getMontoMedicina() {
        return montoMedicina;
    }
    
    public void setMontoMedicina(double montoMedicina) {
        this.montoMedicina = montoMedicina;
    }
    
    public double getMontoCanasta() {
        return montoCanasta;
    }
    
    public void setMontoCanasta(double montoCanasta) {
        this.montoCanasta = montoCanasta;
    }
    
    // Método para mostrar todos los datos
    public String mostrarDatos() {
        String texto = super.mostrarDatos();
        texto = texto + "Monto Medicina: " + montoMedicina + "\n";
        texto = texto + "Monto Canasta Familiar: " + montoCanasta + "\n";
        texto = texto + "Total distribuido: " + (montoMedicina + montoCanasta) + "\n";
        return texto;
    }
}
