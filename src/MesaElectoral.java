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
//        if (censo <= 0) throw new IllegalArgumentException("El numero de personas censadas debe ser mayor a 0");

        if (censo <= 0) {
            System.err.println("El numero de personas censadas debe ser mayor a 0");
            this.censo = 0;
        } else
            this.censo = censo;

        this.participacion = checkParticipacion(participacion, this.censo);

        this.codigo = codigo.toUpperCase();
        this.municipio = municipio.toUpperCase();
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
     * Si no es valida, devuelve 0 o el tope y muestra un mensaje de error.
     *
     * @param participacion Numero de votantes.
     * @param censo         Numero total de personas censadas.
     * @return participacion si es valida, 0 en caso negativo, censo en caso de superarlo.
     */
    private static int checkParticipacion(int participacion, int censo) {
//        if (participacion < 0)
//            throw new IllegalArgumentException("El numero de votantes participantes debe ser mayor a 0");
//        if (participacion > censo)
//            throw new IllegalArgumentException("El numero de votantes participantes debe ser menor o igual al numero de personas censadas");

        if (participacion < 0) {
            System.err.println("El numero de votantes participantes debe ser mayor a 0");
            return 0;
        }
        if (participacion > censo) {
            System.err.println("El numero de votantes participantes debe ser menor o igual al numero de personas censadas");
            return censo;
        }
        return participacion;
    }

    @Override
    public String toString() {
        return String.format("MESA: %s <%s> Censo: %d, Participacion: %d", codigo, municipio, censo, participacion);
    }
}
