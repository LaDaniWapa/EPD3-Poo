/**
 * Clase base para cualquier persona involucrada en el sistema electoral
 */
public abstract class Persona {
    /// Nombre de la persona
    protected String nombre;
    /// Edad de la persona [>0]
    protected int edad;
    /// Documento identificativo de la persona [Mayus]
    protected String dni;

    public Persona() {
    }

    public Persona(String nombre, int edad, String dni) {
//        if (edad <= 0) throw new IllegalArgumentException("La edad debe ser mayor a 0");

        if (edad <= 0) {
            System.err.println("La edad debe ser mayor a 0");
            this.edad = 0;
        } else
            this.edad = edad;

        this.nombre = nombre;
        this.dni = dni.toUpperCase();
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public void setEdad(int edad) {
        if (edad <= 0) {
            System.err.println("La edad debe ser mayor a 0");
            this.edad = 0;
        } else
            this.edad = edad;
    }

    public void setDni(String dni) {
        this.dni = dni.toUpperCase();
    }

    @Override
    public String toString() {
        return String.format("%s (%s) - %d años", nombre, dni, edad);
    }
}