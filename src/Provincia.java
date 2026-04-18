/**
 * Representa una provincia andaluza y contiene las candidaturas registradas en la misma
 */
public class Provincia {
    /// Nombre de la provincia [Mayus]
    private String nombre;
    /// Numero de escaños que reparte la provincia [>0]
    private int numEscanos;
    /// Listado de candidaturas
    private Candidatura[] candidaturas;
    /// Contador de candidaturas añadidas al vector
    private int contadorCandidaturas;

    public Provincia() {
    }

    public Provincia(String nombre, int numEscanos, int maxCandidaturas) {
        this.nombre = nombre.toUpperCase();
        this.numEscanos = numEscanos;
        this.candidaturas = new Candidatura[maxCandidaturas];
        this.contadorCandidaturas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    /**
     * Añade una candidatura a la provincia si aun caben
     *
     * @param c Candidatura a añadir
     */
    public void anadirCandidatura(Candidatura c) {
        if (contadorCandidaturas == candidaturas.length)
            System.err.println("No caben mas candidaturas en esta provincia");
        else
            candidaturas[contadorCandidaturas++] = c;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.format("- Provincia: %s <%d escaños>\n", nombre, numEscanos));

        if (contadorCandidaturas == 0)
            sb.append("<Aun no hay candidaturas registradas en esta provincia>");

        else
            for (int i = 0; i < contadorCandidaturas; i++)
                sb.append(candidaturas[i]).append("\n");

        return sb.toString();
    }
}