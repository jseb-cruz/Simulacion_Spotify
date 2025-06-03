package domain.entities;


public class Rol {

    //atributos

    private String id;
    private String nombre;
    private String descripcion;
    private boolean PrivilegiosAdmin;
    private boolean activo;

    //constructores

    public Rol() {
    }
    public Rol(String id, String nombre, String descripcion, boolean PrivilegiosAdmin, boolean activo) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.PrivilegiosAdmin = PrivilegiosAdmin;
        this.activo = activo;
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
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public boolean isPrivilegiosAdmin() {
        return PrivilegiosAdmin;
    }
    public void setPrivilegiosAdmin(boolean privilegiosAdmin) {
        PrivilegiosAdmin = privilegiosAdmin;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    // Métodos estáticos para roles predefinidos

    public static Rol obtenerRolAdmin() {
        return new Rol("1", "Administrador", "Rol con privilegios de administrador", true, true);
    }
    public static Rol obtenerRolEspectador() {
        return new Rol("2", "Espectador", "Rol estándar de usuario", false, true);
    }

    public static Rol obtenerRolDefecto() {
        return obtenerRolEspectador(); // Por defecto es espectador (HU011)
    }

    //metodo de negocio
    public boolean tienePrivilegiosAdmin() {
        return PrivilegiosAdmin;
    }
    public boolean esAdministrador() {
        return PrivilegiosAdmin && activo; // Un rol es administrador si tiene privilegios de admin y está activo
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rol rol = (Rol) o;
        return id.equals(rol.id);
    }
    @Override
    public int hashCode() {
        return id.hashCode();
    }
    @Override
    public String toString() {
        return "Rol{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", PrivilegiosAdmin=" + PrivilegiosAdmin +
                ", activo=" + activo +
                '}';
    }

    
}