package domain.entities;

import java.util.concurrent.Flow.Subscription;

public class Usuario {


    // atributos
    private String id;
    private String name;
    private String email;
    private String password;
    private Rol rol;
    private Suscripcion suscripcion;

    // constructores

    public Usuario() {
    }

    public Usuario(String id, String name, String email, String password, Rol rol, Suscripcion suscripcion) {
        this.id = id;
        this.name = name;
        setEmail(email);   // Validación de email con setter
        this.password = password;
        this.rol = rol;
        this.suscripcion = suscripcion;
    }

    // getters y setters

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("ID no puede ser nulo o vacío");
        }
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre no puede ser nulo o vacío");
        }
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email == null || !email.matches("^[\\w-.]+@usantoto\\.edu\\.co$")) {
            throw new IllegalArgumentException("Email debe ser del dominio @usantoto.edu.co");
        }
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Contraseña debe tener al menos 8 caracteres");
        }
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        if (rol == null) {
            throw new IllegalArgumentException("Rol no puede ser nulo");
        }
        this.rol = rol;
    }

    public Suscripcion getSuscripcion() {
        return suscripcion;
    }

    public void setSuscripcion(Suscripcion suscripcion) {
        this.suscripcion = suscripcion;
    }

      // 3. Métodos de negocio (HU006, HU007)

    public boolean esPremium() {
        return suscripcion != null && suscripcion.esPremium();
    }

    public boolean esAdministrador() {
        return rol != null && rol.esAdministrador();
    }

    public void ActualizarAPremium() {
        this.suscripcion = Suscripcion.obtenerSuscripcionPremium();
    }

    public void DevolverAGratuito() {
        this.suscripcion = Suscripcion.obtenerSuscripcionGratuita();
    }

    // 4. Métodos estáticos de fábrica 
    public static Usuario crearUsuarioGratuito(String id, String name, String email, String password) {
        return new Usuario(
                generarId(id),
                name,
                email,
                password,
                Rol.obtenerRolDefecto(),
                Suscripcion.obtenerSuscripcionGratuita());
    }

    private static String generarId(String id2) {
        return java.util.UUID.randomUUID().toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Usuario usuario = (Usuario) o;
        return id.equals(usuario.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", rol=" + rol +
                ", suscripcion=" + suscripcion +
                '}';
    }

}
