import java.util.Arrays;

public class Principal {
    public static void main(String[] args) {
        Partido p1 = new Partido("Partido Verde Andaluz");
        p1.setSiglas("PVA");
        p1.setIdeologia("Ecologista");

        Partido p2 = new Partido("Union Social Andaluza");
        p2.setSiglas("USA");
        p2.setIdeologia("Socialdemocrata");

        Partido p3 = new Partido("Alternativa Ciudadana");
        p3.setSiglas("AC");
        p3.setIdeologia("Centrista");

        Partido[] partidos = {p1, p2, p3, new Partido(p1)};
        partidos[3].setSiglas("PVB");
        Arrays.sort(partidos);

        System.out.println("PARTIDOS ORDENADOS:");
        for (int i = 0; i < partidos.length; i++) {
            System.out.println(partidos[i]);
        }
        System.out.println();

        Candidatura c1 = new Candidatura("María López", "12345678a", 45, p1.getNombre(), p1.getSiglas(), 120000, 5);
        Candidatura c2 = new Candidatura("Juan Pérez", "22345678b", 51, p2.getNombre(), p2.getSiglas(), 110200, 4);
        Candidatura c3 = new Candidatura("Ana Romero", "33445566c", 39, p3.getNombre(), p3.getSiglas(), 84500, 3);

        c1.sumarVotos(5430);

        Provincia sevilla = new Provincia("Sevilla", 18, 5);
        Provincia granada = new Provincia("Granada", 13, 5);
        Provincia cadiz = new Provincia("Cadiz", 15, 5);

        sevilla.anadirCandidatura(c1);
        sevilla.anadirCandidatura(c2);
        granada.anadirCandidatura(c3);

        MesaElectoral m1 = new MesaElectoral("SE-41001-001", "Sevilla", 800, 612);
        MesaElectoral m2 = new MesaElectoral("GR-18087-002", "Granada", 720, 544);
        MesaElectoral m3 = new MesaElectoral("CA-11012-003", "Jerez de la Frontera", 750, 590);

        SistemaElecciones sistema = new SistemaElecciones(8, 20);
        sistema.anadirProvincia(sevilla);
        sistema.anadirProvincia(granada);
        sistema.anadirProvincia(cadiz);
        sistema.anadirMesa(m1);
        sistema.anadirMesa(m2);
        sistema.anadirMesa(m3);

        sistema.mostrarSistema();
    }
}
