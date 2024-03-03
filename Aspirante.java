package EntregableEstudio;

import java.io.Serializable;

class Aspirante implements Serializable {
    private static final long serialVersionUID = 1L;
    private static int contador = 1;

    private int numeroIdentificativo;
    private String nombre;
    private String dni;
    private String telefono;

    public Aspirante(String nombre, String dni, String telefono) {
        this.numeroIdentificativo = contador++;
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
    }

    public int getNumeroIdentificativo() {
        return numeroIdentificativo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getTelefono() {
        return telefono;
    }
}