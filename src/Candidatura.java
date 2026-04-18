/**
 * Representa a la persona cabeza de la lista de una candidatura electoral
 */
public class Candidatura extends Persona implements IVotable {
    /// Nombre completo del partido politico [Mayus]
    private String partido;
    /// Siglas del partido politico [Mayus]
    private String siglas;
    /// Numero de votos acumulados [0~MAXVOTOS]
    private int votos;
    /// Escaños obtenidos [>=0]
    private int escanos;

    public Candidatura() {
    }

    public Candidatura(String nombre, int edad, String dni, String partido, String siglas, int votos, int escanos) {
        super(nombre, edad, dni);

        if (escanos < 0) throw new IllegalArgumentException("El numero de escaños debe ser mayor a 0");
        if (votos < 0) throw new IllegalArgumentException("El numero de votos debe ser mayor a 0");
        if (votos > MAXVOTOS) throw new IllegalArgumentException(String.format("El numero de votos debe ser menor a %d", MAXVOTOS));

        this.partido = partido.toUpperCase();
        this.siglas = siglas.toUpperCase();
        this.votos = votos;
        this.escanos = escanos;
    }

    public String getPartido() {
        return partido;
    }

    public String getSiglas() {
        return siglas;
    }

    @Override
    public int getVotos() {
        return votos;
    }

    public int getEscanos() {
        return escanos;
    }

    /**
     * Incrementa el numero de votos de la candidatura sin superar a MAXVOTOS
     *
     * @param votos numero de votos a añadir
     */
    public void sumarVotos(int votos) {
        this.votos = Math.min(this.votos + votos, MAXVOTOS);
    }

    public void setEscanos(int escanos) {
        if (escanos < 0) throw new IllegalArgumentException("El numero de escaños debe ser mayor a 0");
        this.escanos = escanos;
    }

    @Override
    public String toString() {
        return String.format("""
                        - CANDIDATURA: %s
                            * Partido: %s
                            * Siglas: %s
                            * Votos: %d
                            * Escaños: %d""",
                super.toString(), partido, siglas, votos, escanos);
    }
}
