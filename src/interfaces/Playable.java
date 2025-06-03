package interfaces;

/**
 * Interfaz que define el comportamiento de los elementos reproducibles en el sistema
 * (canciones, episodios de podcast, etc.). Implementa el patrón Strategy para
 * permitir diferentes tipos de contenido multimedia.
 */

public interface Playable {

    /**
     * Obtiene el título del contenido reproducible
     */
    String obtenerTitulo();

     /**
     * Obtiene la descripción del contenido
     */
    String obtenerDescripcion();

    /**
     * Obtiene la duración en segundos
     */
    double obtenerDuracion();

    /**
     * Método que inicia la reproducción del contenido.
     * Debe implementar la lógica específica para cada tipo.
     */
    void reproducir();

    /**
     * Método default que proporciona la duración formateada (MM:SS)
     */
    default String obtenerDuracionFormateada() {
        long segundosTotales = (long) obtenerDuracion();
        long minutos = segundosTotales / 60;
        long segundos = segundosTotales % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }

    /**
     * Método default que proporciona una descripción general del contenido
     * incluyendo título y duración formateada.
     */
    default String obtenerInformacion() {
        return String.format("%s - Duración: %s",
                obtenerTitulo(), obtenerDuracionFormateada());
    }
}
