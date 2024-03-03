package EntregableEstudio;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

class IntroducirAspirantes {
    private List<Aspirante> aspirantes = new ArrayList<>();

    public void InsertaAspirante(String nombre, String dni, String telefono) {
        Aspirante aspirante = new Aspirante(nombre, dni, telefono);
        aspirantes.add(aspirante);

        Scanner scanner = new Scanner(System.in);
        System.out.print("¿Quieres insertar otro aspirante? (Sí/No): ");
        String respuesta = scanner.nextLine().toLowerCase();

        if (respuesta.equals("no")) {
            guardarFicheros();
            System.exit(0);
        }
    }

    public void guardarFicheros() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("aspirantes.dat"))) {
            oos.writeObject(aspirantes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ids_aspirantes.dat"))) {
            for (Aspirante aspirante : aspirantes) {
                oos.writeInt(aspirante.getNumeroIdentificativo());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

