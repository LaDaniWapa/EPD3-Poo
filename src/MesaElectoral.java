/**
 * Representa una mesa electoral concreta en un municipio andaluz
 */
public class MesaElectoral {
    /// Identificador de la mesa [Mayus]
    private String codigo;
    /// Nombre del municipio donde se ubica la mesa [Mayus]
    private String municipio;
    /// Numero de personas censadas en la mesa [>0]
    private int censo;
    /// Numero de votantes que han participado en dicha mesa [0~censo]
    private int participacion;

    public MesaElectoral() {
    }

    public MesaElectoral(String codigo, String municipio, int censo, int participacion) {
        if (censo <= 0) throw new IllegalArgumentException("El numero de personas censadas debe ser mayor a 0");
        checkParticipacion(participacion, censo);

        this.codigo = codigo.toUpperCase();
        this.municipio = municipio.toUpperCase();
        this.censo = censo;
        this.participacion = participacion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMunicipio() {
        return municipio;
    }

    public int getCenso() {
        return censo;
    }

    public int getParticipacion() {
        return participacion;
    }

    public void setParticipacion(int participacion) {
        checkParticipacion(participacion, censo);
        this.participacion = participacion;
    }

    /**
     * Valida que la participacion sea positiva y no supere el censo.
     *
     * @param participacion Numero de votantes.
     * @param censo         Numero total de personas censadas.
     */
    private static void checkParticipacion(int participacion, int censo) {
        if (participacion < 0)
            throw new IllegalArgumentException("El numero de votantes participantes debe ser mayor a 0");
        if (participacion > censo)
            throw new IllegalArgumentException("El numero de votantes participantes debe ser menor o igual al numero de personas censadas");
    }

    @Override
    public String toString() {
        return String.format("MESA: %s <%s> Censo: %d, Participacion: %d", codigo, municipio, censo, participacion);
    }
}
