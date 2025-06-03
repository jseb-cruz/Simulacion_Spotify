package domain.entities;

import java.util.Objects;

public class Artista {

    private String id;
    private String nombre;
    private String descripcion;
    private String genero; // genero principal del artista
    private boolean activo;
    private int numCanciones; // número de canciones del artista

    // Constructores
    public Artista() {
        this.activo = true;
        this.numCanciones = 0;
    }

    public Artista(String id, String nombre) {
        this();
        this.id = id;
        this.nombre = nombre;
    }

    public Artista(String id, String nombre, String descripcion, String genero) {
        this(id, nombre);
        this.descripcion = descripcion;
        this.genero = genero;
    }

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID de artista no puede ser nulo o vacío");
        }
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre de artista no puede ser nulo o vacío");
        }
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getNumCanciones() {
        return numCanciones;
    }

    public void setNumCanciones(int numCanciones) {
        this.numCanciones = numCanciones;
    }

    // Métodos de negocio

    public void aumentarCanciones() {
        this.numCanciones++;
    }

    public void disminuirCanciones() {
        if (this.numCanciones > 0) {
            this.numCanciones--;
        } else {
            throw new IllegalStateException("No se pueden disminuir las canciones por debajo de cero");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Artista artista = (Artista) o;
        return Objects.equals(id, artista.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Artista{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", numCanciones=" + numCanciones +
                '}';
    }

    // Métodos estáticos de fábrica
    public static Artista crearArtista(String nombre) {
        return new Artista(generarId(), nombre);
    }

    public static Artista crearArtista(String nombre, String genero) {
        Artista artista = new Artista(generarId(), nombre);
        artista.setGenero(genero);
        return artista;
    }

    private static String generarId() {
        return java.util.UUID.randomUUID().toString();

    }
}
