/**
 * Representa el sistema general de gestion de las elecciones
 */
public class SistemaElecciones {
    /// Listado de provincias que participan en las elecciones
    private Provincia[] provincias;
    /// Listado de mesas electorales registradas
    private MesaElectoral[] mesas;
    /// Contador de provincias añadidas al vector
    private int contadorProvincias;
    /// Contador de mesas añadidas al vector
    private int contadorMesas;

    public SistemaElecciones() {
    }

    public SistemaElecciones(int maxProvincias, int maxMesas) {
        this.provincias = new Provincia[maxProvincias];
        this.mesas = new MesaElectoral[maxMesas];
        this.contadorProvincias = 0;
        this.contadorMesas = 0;
    }

    public void anadirProvincia(Provincia p) {
        if (contadorProvincias == provincias.length)
            System.err.println("<No caben mas provincias en el sistema>");
        else
            provincias[contadorProvincias++] = p;
    }

    public void anadirMesa(MesaElectoral m) {
        if (contadorMesas == mesas.length)
            System.err.println("<No caben mas mesas en el sistema>");
        else
            mesas[contadorMesas++] = m;
    }

    public String mostrarSistema() {
        StringBuilder sb = new StringBuilder("=== SISTEMA DE ELECCIONES AL PARLAMENTO DE ANDALUCIA ===\n\n");

        if (contadorProvincias == 0)
            sb.append("<Aun no hay provincias registradas en el sistema>");

        else {
            sb.append("[ PROVINCIAS REGISTRADAS ]\n");

            for (int i = 0; i < contadorProvincias; i++) {
                sb.append(provincias[i]).append("\n");
            }
            sb.append("\n[ MESAS ELECTORALES REGISTRADAS ]\n");

            for (int i = 0; i < contadorMesas; i++) {
                sb.append(mesas[i]).append("\n");
            }
        }

        return sb.toString();
    }
}