package domain.entities;

import java.util.Objects;

public class Genero {

    // Atributos

    private String id;
    private String nombre;
    private String descripcion;
    private boolean activo;

    // Constructores

    public Genero() {
    }

    public Genero(String id, String nombre, String descripcion, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.activo = activo;
    }

    // Getters y Setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }


    // Métodos estáticos para géneros predefinidos

    public static Genero obtenerGeneroRock() {
        return new Genero("1", "Rock", "Género musical popular desarrollado a partir del rock and roll y el blues a mediados de la década de 1950.", true);
    }
    public static Genero obtenerGeneroPop() {
        return new Genero("2", "Pop", "Género de música popular que se originó a mediados de la década de 1950.", true);
    }
    public static Genero obtenerGeneroElectronica() {
        return new Genero("3", "Electrónica", "Amplio género musical que utiliza instrumentos electrónicos para producir sonido.", true);
    }
    public static Genero obtenerGeneroHipHop() {
        return new Genero("4", "HipHop", "Género musical y cultural desarrollado en la década de 1970 en comunidades afroamericanas y latinas de Nueva York.", true);
    }
    public static Genero obtenerGeneroClasica() {
        return new Genero("5", "Clásica", "Tradición de música artística occidental.", true);
    }
    public static Genero obtenerGeneroJazz() {
        return new Genero("6", "Jazz", "Género musical que se originó a finales del siglo XIX y principios del XX en las comunidades afroamericanas de Nueva Orleans.", true);
    }
    public static Genero obtenerGeneroReggae() {
        return new Genero("7", "Reggae", "Género musical que se originó a finales del siglo XIX en las comunidades afroamericanas del sur de Estados Unidos.", true);
    }
    public static Genero obtenerGeneroCumbia() {
        return new Genero("8", "Cumbia", "Género musical y baile folclórico tradicional de Colombia.", true);
    }
    public static Genero obtenerGeneroBlues() {
        return new Genero("9", "Blues", "Género musical vocal e instrumental que se basa en el uso de las notas de blues.", true);
    }
    public static Genero obtenerGeneroCountry() {
        return new Genero("10", "Country", "Género de música popular que se originó en el sur de Estados Unidos a principios del siglo XX.", true);
    }
    public static Genero obtenerGeneroSalsa() {
        return new Genero("11", "Salsa", "Género musical que surgió en Nueva York en los años 70, con raíces en el son cubano, jazz y otros ritmos caribeños. Se caracteriza por su ritmo vibrante y complejas armonías.", true);
    }
    public static Genero obtenerGeneroTrap() {
        return new Genero("12", "Trap", "Subgénero del hip hop que se originó en el sur de Estados Unidos a principios de los años 2000. Se caracteriza por sus ritmos oscuros, hi-hats rápidos y letras que a menudo tratan sobre la vida en las calles.", true);
    }
    public static Genero obtenerGeneroReggaeton() {
        return new Genero("13", "Reggaeton", "Género musical originario de Puerto Rico que mezcla reggae, dancehall y hip hop. Se popularizó a nivel internacional en los años 2000 con su característico ritmo \"dembow\".", true);
    }
    public static Genero obtenerGeneroMerengue() {
        return new Genero("14", "Merengue", "Género musical y baile originario de la República Dominicana, con un ritmo rápido y alegre que se toca con güira, tambora y acordeón.", true);
    }
    public static Genero obtenerGeneroVallenato() {
        return new Genero("15", "Vallenato", "Género musical originario de la Costa Caribe colombiana, interpretado con acordeón, caja y guacharaca. Declarado Patrimonio Cultural Inmaterial de la Humanidad por la UNESCO.", true);
    }
    public static Genero obtenerGeneroRanchera() {
        return new Genero("16", "Ranchera", "Género musical tradicional mexicano que se desarrolló durante la Revolución Mexicana, caracterizado por sus letras sentimentales y patrióticas.", true);
    }
    public static Genero obtenerGeneroNorteno() {
        return new Genero("17", "Norteño", "Género musical originario del norte de México, interpretado con acordeón y bajo sexto, con influencias de polka y corridos.", true);
    }
    public static Genero obtenerGeneroCorridos() {
        return new Genero("18", "Corridos", "Narrativas musicales tradicionales mexicanas que cuentan historias reales o ficticias, desde la Revolución hasta el narcotráfico (narcocorridos).", true);
    }
    public static Genero obtenerGeneroBanda() {
        return new Genero("19", "Banda", "Género musical originario de Sinaloa interpretado con instrumentos de viento, con ritmos alegres y versos cantados.", true);
    }

    // Métodos de negocio

    public boolean esValidoParaCancion() {
        return this.activo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Genero genero = (Genero) o;
        return Objects.equals(id, genero.id);
        
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Genero{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", activo=" + activo +
                '}';
    }

    
}
