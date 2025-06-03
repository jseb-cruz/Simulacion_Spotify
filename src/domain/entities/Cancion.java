package domain.entities;

import interfaces.Playable;
import java.time.Duration;
import java.util.Objects;

public class Cancion implements Playable {

    // Atributos
    private String id;
    private String titulo;
    private String descripcion;
    private Duration duracion; // en segundos
    private Artista artista;
    private Genero genero;
    private String rutaArchivo;
    private boolean explicito;
    private int reproducciones;
    private boolean activo;

    // Constructores
    public Cancion() {
        this.reproducciones = 0;
        this.activo = true;
    }

    public Cancion(String id, String titulo, String descripcion, Duration duracion, Artista artista, Genero genero,
            String rutaArchivo, boolean explicito) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.artista = artista;
        this.genero = genero;
        this.rutaArchivo = rutaArchivo;
        this.explicito = explicito;
    }

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID de canción no puede ser nulo o vacío");
        }
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Título no puede ser nulo o vacío");
        }
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Duration getDuracion() {
        return duracion; // Retorna la duración en segundos
    }

    public void setDuracion(Duration duracion) {
        if (duracion == null || duracion.isNegative() || duracion.isZero()) {
            throw new IllegalArgumentException("Duración debe ser un valor positivo");
        }
        this.duracion = duracion;
    }

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        if (artista == null) {
            throw new IllegalArgumentException("Artista no puede ser nulo");
        }
        this.artista = artista;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        if (genero == null) {
            throw new IllegalArgumentException("Género no puede ser nulo");
        }
        this.genero = genero;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        if (rutaArchivo == null || rutaArchivo.trim().isEmpty()) {
            throw new IllegalArgumentException("Ruta de archivo de audio no puede ser nula");
        }
        this.rutaArchivo = rutaArchivo;
    }

    public boolean isExplicito() {
        return explicito;
    }

    public void setExplicito(boolean explicito) {
        this.explicito = explicito;
    }

    public int getReproducciones() {
        return reproducciones;
    }

    public void setReproducciones(int reproducciones) {
        this.reproducciones = reproducciones;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // Métodos de la interfaz Playable

    @Override
    public String obtenerTitulo() {
        return titulo;
    }

    @Override
    public String obtenerDescripcion() {
        return descripcion;
    }

    @Override
    public double obtenerDuracion() {
        return duracion.toMinutes() + duracion.getSeconds() / 60.0; // Retorna la duración en minutos
    }

    @Override
    public void reproducir() {
        this.reproducciones++;
        System.out.println("Reproduciendo: " + titulo + " - " + artista.getNombre());
    }

    // Métodos de negocio
    public void incrementPlayCount() {
        this.reproducciones++;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cancion cancion = (Cancion) o;
        return Objects.equals(id, cancion.id)&&
               Objects.equals(titulo, cancion.titulo) &&
               Objects.equals(artista, cancion.artista);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, titulo, artista);
    }

    @Override
    public String toString() {
        return "Cancion{" +
                ", titulo='" + titulo + '\'' +
                ", duracion=" + obtenerDuracionFormateada() +
                ", artista='" + artista.getNombre() + '\'' +
                ", genero=" + genero.getNombre() ;
                
    }

    // Método estatico de fabrica
    public static Cancion crearCancion(String titulo,Artista artista, Genero genero,Duration duracion, String rutaArchivo) {
        return new Cancion(generarId(), titulo, "",
                duracion, artista, genero, rutaArchivo, false);
    }

    private static String generarId() {
        return "song_" + java.util.UUID.randomUUID().toString();
    }
}
