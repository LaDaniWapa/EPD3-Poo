/**
 * Representa un partido politico que concurre a las elecciones
 */
public class Partido implements Comparable {
    /// Nombre completo del partido [Mayus]
    private String nombre;
    /// Siglas del partido [Mayus]
    private String siglas;
    /// Descripcion breve de la ideologia del partido [Mayus]
    private String ideologia;

    public Partido() {
    }

    public Partido(String nombre) {
        this.nombre = nombre.toUpperCase();
        this.siglas = generarSiglas(nombre.toUpperCase());
        this.ideologia = "";
    }

    public Partido(Partido p) {
        this.nombre = p.nombre;
        this.siglas = p.siglas;
        this.ideologia = p.ideologia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getSiglas() {
        return siglas;
    }

    public String getIdeologia() {
        return ideologia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre.toUpperCase();
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas.toUpperCase();
    }

    public void setIdeologia(String ideologia) {
        this.ideologia = ideologia;
    }

    /**
     * Genera las siglas del nombre de un partido politico
     *
     * @param nombre Nombre completo del partido politico
     * @return siglas del partido politico
     */
    private String generarSiglas(String nombre) {
        if (nombre.isBlank()) return "";

        String siglas = "";

        // \\s+ significa cualquier cantidad de espacios o tabulaciones,
        // para no generar palabras vacias,
        // ya que "".charAt(0) lanza una excepcion
        for (String palabra : nombre.split("\\s+"))
            siglas += palabra.charAt(0);

        return siglas.toUpperCase();
    }

    @Override
    public String toString() {
        return String.format("%s - %s", siglas, nombre);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) return false;
        if (obj == this) return true;

        if (obj instanceof Partido p)
            return this.nombre.equals(p.nombre) && this.siglas.equals(p.siglas);
        else return false;
    }

    @Override
    public int compareTo(Object obj) {
        if (obj == null) return 1;
        if (obj == this) return 0;

        if (obj instanceof Partido p) {
            int res = this.siglas.compareTo(p.siglas);
            if (res == 0) res = this.nombre.compareTo(p.nombre);
            return res;
        } else
            return 1;
    }
}