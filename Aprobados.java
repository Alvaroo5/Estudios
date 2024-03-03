package EntregableEstudio;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

class Aprobados {
    private Map<Integer, List<Double>> calificaciones = new HashMap<>();
    private Map<Integer, Aspirante> aspirantesMap = new HashMap<>();

    public void cargarCalificaciones() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("calificaciones.dat"))) {
            calificaciones = (Map<Integer, List<Double>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("aspirantes.dat"))) {
            List<Aspirante> aspirantes = (List<Aspirante>) ois.readObject();
            for (Aspirante aspirante : aspirantes) {
                aspirantesMap.put(aspirante.getNumeroIdentificativo(), aspirante);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private double calcularMedia(int numeroIdentificativo) {
        List<Double> calificacionesList = calificaciones.get(numeroIdentificativo);
        if (calificacionesList != null && !calificacionesList.isEmpty()) {
            double sum = calificacionesList.stream().mapToDouble(Double::doubleValue).sum();
            return sum / calificacionesList.size();
        }
        return 0.0;
    }

    public void generarInforme() {
        System.out.println("Nombre\t\tDNI\t\tCalificación Media");
        System.out.println("--------------------------------------------------");

        List<Integer> sortedIds = new ArrayList<>(aspirantesMap.keySet());
        sortedIds.sort(Comparator.comparingInt(id -> aspirantesMap.get(id).getNombre().compareToIgnoreCase(aspirantesMap.get(id).getNombre())));

        for (int numeroIdentificativo : sortedIds) {
            Aspirante aspirante = aspirantesMap.get(numeroIdentificativo);
            double calificacionMedia = calcularMedia(numeroIdentificativo);

            System.out.printf("%-20s%-15s%.2f\n", aspirante.getNombre(), aspirante.getDni(), calificacionMedia);
        }
    }
}