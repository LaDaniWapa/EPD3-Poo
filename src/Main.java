import java.util.Arrays;

public class Main {
    public static void main2(String[] args) {
        // Partidos
        Partido usa = new Partido("union social andaluza");
        Partido ac = new Partido("alternativa ciudadana");
        Partido pvb = new Partido("partido verde betis");
        Partido pva = new Partido("partido verde andaluz");
        Partido[] p = {usa, ac, pvb, pva};

        Arrays.sort(p);

        System.out.println("PARTIDOS ORDENADOS:");
        for (Partido partido : p) {
            System.out.println(partido);
        }

        System.out.println(); // separar un poco

        // Sistema de elecciones
        Provincia sevilla = new Provincia("sevilla", 18,2);
        sevilla.anadirCandidatura(new Candidatura("Maria Lopez", "12345678a", 45, pva.getNombre(), pva.getSiglas(), 125430, 9));
        sevilla.anadirCandidatura(new Candidatura("Juan Perez", "22345678B", 51, usa.getNombre(), usa.getSiglas(), 110200, 9));

        Provincia granada = new Provincia("granada", 13,1);
        granada.anadirCandidatura(new Candidatura("Ana Romero", "33445566C", 39, ac.getNombre(), ac.getSiglas(), 84500, 13));

        Provincia cadiz = new Provincia("cadiz", 15, 0);

        SistemaElecciones sys = new SistemaElecciones(3,3);
        sys.anadirProvincia(sevilla);
        sys.anadirProvincia(granada);
        sys.anadirProvincia(cadiz);

        sys.anadirMesa(new MesaElectoral("SE-41001-001", "sevilla", 800, 612));
        sys.anadirMesa(new MesaElectoral("GR-18087-002", "granada", 720, 544));
        sys.anadirMesa(new MesaElectoral("CA-11012-003", "jerez de la frontera", 750, 590));

        System.out.println(sys.mostrarSistema());
    }
}