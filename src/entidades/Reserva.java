package entidades;

import java.time.LocalDateTime;

/**
 * @author Sergio Flores
 * @version 1.0 
 */
public class Reserva {
	/**
	 * Atributos de clase
	 */
    private int idPista;
    private LocalDateTime fecha;
    private int duracion;
    
    /**
     * Constructor de la clase Reserva
     * @param idPista
     * @param fecha
     * @param duracion
     */
    public Reserva(int idPista, LocalDateTime fecha, int duracion) {
        this.idPista = idPista;
        this.fecha = fecha;
        this.duracion = duracion;
    }

    /**
     * @return Devuelve el id de la pista
     */
    public int getIdPista() {
        return idPista;
    }

    /**
     * @return Devuelve la fecha de la reserva
     */
    public LocalDateTime getFecha() {
        return fecha;
    }

    /**
     * @return Devuelve la duracion de la reserva
     */
    public int getDuracion() {
        return duracion;
    }
}