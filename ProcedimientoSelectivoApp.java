package EntregableEstudio;

import java.util.Scanner;

public class ProcedimientoSelectivoApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        IntroducirAspirantes introducirAspirantes = new IntroducirAspirantes();
        CalificacionPruebas calificacionPruebas = new CalificacionPruebas();
        Aprobados aprobados = new Aprobados();

        while (true) {
            System.out.println("Menú Principal:");
            System.out.println("1. Introducir datos de aspirantes");
            System.out.println("2. Calificar prueba");
            System.out.println("3. Aprobados");
            System.out.println("4. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre del aspirante: ");
                    String nombre = scanner.next();
                    System.out.print("DNI del aspirante: ");
                    String dni = scanner.next();
                    System.out.print("Teléfono del aspirante: ");
                    String telefono = scanner.next();
                    introducirAspirantes.InsertaAspirante(nombre, dni, telefono);
                    break;
                case 2:
                    System.out.print("Número identificativo del aspirante: ");
                    int numeroIdentificativo = scanner.nextInt();
                    System.out.print("Calificación de la prueba: ");
                    double calificacion = scanner.nextDouble();
                    calificacionPruebas.introducirCalificacion(numeroIdentificativo, calificacion);
                    break;
                case 3:
                    aprobados.cargarCalificaciones();
                    aprobados.generarInforme();
                    break;
                case 4:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        }
    }
}