package modelo;

public class Persona {
    
    // Atributos comunes
    private String tipoDocumento;
    private String numeroDocumento;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String telefono;
    private int edad;
    private int estrato;
    private String estadoCivil;
    private boolean cabezaHogar;
    private String tipoPersona; 
    
    // Constructor vacío
    public Persona() {
    }
    
    // Constructor completo
    public Persona(String tipoDocumento, String numeroDocumento, String nombre, 
                   String apellidos, String direccion, String telefono, 
                   int edad, int estrato, String estadoCivil, boolean cabezaHogar,
                   String tipoPersona) {
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.edad = edad;
        this.estrato = estrato;
        this.estadoCivil = estadoCivil;
        this.cabezaHogar = cabezaHogar;
        this.tipoPersona = tipoPersona;
    }
    
    // Getters y Setters
    public String getTipoDocumento() {
        return tipoDocumento;
    }
    
    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }
    
    public String getNumeroDocumento() {
        return numeroDocumento;
    }
    
    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getApellidos() {
        return apellidos;
    }
    
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    public int getEdad() {
        return edad;
    }
    
    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    public int getEstrato() {
        return estrato;
    }
    
    public void setEstrato(int estrato) {
        this.estrato = estrato;
    }
    
    public String getEstadoCivil() {
        return estadoCivil;
    }
    
    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }
    
    public boolean isCabezaHogar() {
        return cabezaHogar;
    }
    
    public void setCabezaHogar(boolean cabezaHogar) {
        this.cabezaHogar = cabezaHogar;
    }
    
    public String getTipoPersona() {
        return tipoPersona;
    }
    
    public void setTipoPersona(String tipoPersona) {
        this.tipoPersona = tipoPersona;
    }
    
    // Método para mostrar información básica
    public String mostrarDatos() {
        String texto = "Tipo Documento: " + tipoDocumento + "\n";
        texto = texto + "Número Documento: " + numeroDocumento + "\n";
        texto = texto + "Nombre: " + nombre + "\n";
        texto = texto + "Apellidos: " + apellidos + "\n";
        texto = texto + "Dirección: " + direccion + "\n";
        texto = texto + "Teléfono: " + telefono + "\n";
        texto = texto + "Edad: " + edad + "\n";
        texto = texto + "Estrato: " + estrato + "\n";
        texto = texto + "Estado Civil: " + estadoCivil + "\n";
        texto = texto + "Cabeza de Hogar: " + (cabezaHogar ? "Sí" : "No") + "\n";
        texto = texto + "Tipo de Persona: " + tipoPersona + "\n";
        return texto;
    }
}
