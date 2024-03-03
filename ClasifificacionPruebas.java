package EntregableEstudio;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class CalificacionPruebas {
    private Map<Integer, List<Double>> calificaciones = new HashMap<>();

    public void cargarCalificaciones() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ids_aspirantes.dat"))) {
            while (true) {
                try {
                    int numeroIdentificativo = ois.readInt();
                    calificaciones.put(numeroIdentificativo, new ArrayList<>());
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void introducirCalificacion(int numeroIdentificativo, double calificacion) {
        calificaciones.computeIfAbsent(numeroIdentificativo, k -> new ArrayList<>()).add(calificacion);

        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Quieres introducir otra calificación? (Sí/No): ");
        String respuesta = scanner.nextLine().toLowerCase();

        if (respuesta.equals("no")) {
            guardarFichero();
            System.exit(0);
        }
    }

    public void guardarFichero() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("calificaciones.dat"))) {
            oos.writeObject(calificaciones);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
