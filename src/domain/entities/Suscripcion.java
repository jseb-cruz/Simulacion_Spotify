package domain.entities;


public class Suscripcion {

    // atributos

    private String id;
    private String nombre;
    private String descripcion;
    private String beneficios;
    private double precio;
    private boolean premium;
    private boolean activa;

    // constructores

    public Suscripcion() {
    }

    public Suscripcion(String id, String nombre, String descripcion, String beneficios, double precio, boolean premium,
            boolean activa) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.beneficios = beneficios;
        this.precio = precio;
        this.premium = premium;
        this.activa = activa;
    }

    // Getters and Setters

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
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la suscripción no puede estar vacío");
        }
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getBeneficios() {
        return beneficios;
    }

    public void setBeneficios(String beneficios) {
        this.beneficios = beneficios;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.precio = precio;
    }

    public boolean esPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    // Métodos estáticos para crear suscripciones predefinidas

    public static Suscripcion obtenerSuscripcionPremium() {
        return new Suscripcion("1", "Premium",
                "Disfruta de una experiencia musical ininterrumpida y de alta calidad con la suscripción Premium de Spotify.",
                " Escucha música sin anuncios, descarga canciones para escuchar sin conexión, escucha canciones en cualquier orden, calidad de audio alta, escucha con amigos en tiempo real, organiza la cola de reproducción.",
                9.99, true, true);
    }

    public static Suscripcion obtenerSuscripcionGratuita() {
        return new Suscripcion("2", "Gratuita",
                "Escucha una amplia selección de música y podcasts de forma gratuita con algunas limitaciones como anuncios.",
                "Acceso a millones de canciones y podcasts, listas de reproducción seleccionadas, descubrimiento de nueva música.",
                0.0, false, true);

    }

    //metodos de negocio
    public boolean accederContenidoPremium() {
        return this.premium;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Suscripcion that = (Suscripcion) o;
        return id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Suscripcion{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", beneficios='" + beneficios + '\'' +
                ", precio=" + precio +
                ", premium=" + premium +
                ", activa=" + activa +
                '}';
    }

    
}