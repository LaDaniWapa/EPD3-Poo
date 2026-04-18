/**
 * Representa un partido politico que concurre a las elecciones
 */
public class Partido implements Comparable<Partido> {
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
        this.nombre = nombre;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
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
        StringBuilder siglas = new StringBuilder();

        for (String palabra : nombre.split(" "))
            siglas.append(palabra.charAt(0));

        return siglas.toString();
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
    public int compareTo(Partido p) {
        int res = this.siglas.compareTo(p.siglas);

        if (res == 0) res = this.nombre.compareTo(p.nombre);

        return res;
    }
}